package io.mine.ft.train.conf.filter;

import io.mine.ft.train.common.exception.BusinessException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;

public class SqlRewriteWrapper {
    
    private static final String IS_DELETED = "IS_DELETED";

    public static String sqlRewrite(String sql) {
        String newSql = sql;
        try {
            Statement statement = CCJSqlParserUtil.parse(sql);
            if ((statement instanceof Select)) {
                newSql = dealSelect(statement);
            } else if ((statement instanceof Insert)) {
                //newSql = dealInsert(statement);
            } else if ((statement instanceof Update)) {
                newSql = dealUpdate(statement);
            } else if ((statement instanceof Delete)) {
                //newSql = dealDelete(statement);
            } else {
                throw new BusinessException("", "SQL解析失败, sql: " + sql);
            }
        } catch (Exception e) {
            //throw new BusinessException("SQL解析失败, sql: " + sql);
        }

        return newSql;
    }

    private static String dealUpdate(Statement statement) throws Exception {
        Update realStatement = (Update) statement;

        Expression where = realStatement.getWhere();

        realStatement.getFromItem();

        if(where.toString().toUpperCase().indexOf(IS_DELETED) < 0){
            where = dealWhere(where, IS_DELETED, "N");
        }

        realStatement.setWhere(where);

        return realStatement.toString();
    }

    private static String dealSelect(Statement statement) throws Exception {

        Select realStatement = (Select) statement;
        PlainSelect ps = (PlainSelect) realStatement.getSelectBody();
        FromItem fi = ps.getFromItem();
        Alias alias = fi.getAlias();

        Expression where = ps.getWhere();
        if(where == null){
            return realStatement.toString();
        }

        String keyIsDeleted = IS_DELETED;

        if (alias != null) {
            keyIsDeleted = alias + "." + IS_DELETED;
        }

        if(where.toString().toUpperCase().indexOf(IS_DELETED) < 0){
            where = dealWhere(where, keyIsDeleted, "N");
        }
        ps.setWhere(where);

        return realStatement.toString();
    }

    private static Expression dealWhere(Expression where, String columnName, String columnValue) {
        EqualsTo et = new EqualsTo();
        et.setLeftExpression(new Column(columnName));

        et.setRightExpression(new StringValue(columnValue));
        if (where == null) {
            where = et;
        } else if ((where instanceof BinaryExpression)) {
            BinaryExpression be = (BinaryExpression) where;
            while (true) {
                Expression right = be.getRightExpression();
                if ((right instanceof BinaryExpression)) {
                    be = (BinaryExpression) right;
                } else {
                    AndExpression andExpression = new AndExpression(right, et);
                    be.setRightExpression(andExpression);
                    break;
                }
            }
        } else if ((where instanceof Parenthesis)) {
            Expression inp = ((Parenthesis) where).getExpression();
            dealWhere(inp, columnName, columnValue);
        }
        return where;
    }

}
