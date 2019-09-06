package io.mine.ft.train.conf.intercept;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import com.mysql.jdbc.Connection;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object plugin(Object target) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO 自动生成的方法存根
		
	}
	
}
