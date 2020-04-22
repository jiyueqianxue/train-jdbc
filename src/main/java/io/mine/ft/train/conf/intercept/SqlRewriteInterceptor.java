package io.mine.ft.train.conf.intercept;

import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import freemarker.core.BugException;
import io.mine.ft.train.common.utils.ReflectHelper;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {
                java.sql.Connection.class, Integer.class})})
public class SqlRewriteInterceptor implements Interceptor {
    
	@Override
    public Object intercept(Invocation invocation) throws Throwable {
        //        log.info("intercept==>" + invocation.getClass().getName() + ":" + invocation.getMethod() + ":" + invocation.getArgs());

        if ((invocation.getTarget() instanceof RoutingStatementHandler)) {
            RoutingStatementHandler statementHandler =
                    (RoutingStatementHandler) invocation.getTarget();
            StatementHandler delegate =
                    (StatementHandler) ReflectHelper.getFieldValue(statementHandler, "delegate");
            BoundSql boundSql = delegate.getBoundSql();
            String sql = boundSql.getSql();
            //            log.info("intercept before ：" + sql);
            ReflectHelper.setFieldValue(boundSql, "sql", SqlRewriteWrapper.sqlRewrite(sql));
            sql = boundSql.getSql();
            //            log.info("after intercept sql========>：\r\n" + sql);
        } else {
            throw new BugException();
        }

        return invocation.proceed();
    }
    
    @Override
    public Object plugin(Object target) {
        //log.info("==>" + target.getClass().getName());
        if ((target instanceof StatementHandler))
            return Plugin.wrap(target, this);
        return target;
    }
    
    @Override
    public void setProperties(Properties properties) {
    }
}
