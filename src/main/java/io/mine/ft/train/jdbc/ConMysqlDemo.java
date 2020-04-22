package io.mine.ft.train.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ConMysqlDemo {

	public static void main(String[] args) {
		 //声明Connection对象
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
	    String url = "jdbc:mysql://xxxx.xxxx.xxxx.xxxx:3306/name";
        //MySQL配置时的用户名
	    String user = "username";
        //MySQL配置时的密码
	    String password = "passworld";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = (Connection) DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = (Statement) con.createStatement();
            //要执行的SQL语句
            String sql = "select * from xt_user";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");  
            System.out.println("-----------------");  
            System.out.println("主键" + "\t" + "名称");  
            System.out.println("-----------------");  
             
            String id = null;
            String name = null;
            while(rs.next()){
                //获取id这列数据
                id = rs.getString("id");
                //获取name这列数据
                name = rs.getString("name");
                //输出结果
                System.out.println(id + "\t" + name);
            }
            rs.close();
            con.close();
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
	}
}
