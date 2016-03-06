package com.oracle.procedure;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class DemoOracleProcedure {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "yq";
		String password = "123";
		String call_sql = "{call sp_pro3(?,?)}";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			
			CallableStatement cs = conn.prepareCall(call_sql);
			cs.setString(1, "SCOTT");
			cs.setDouble(2, 9898.98);
			
			cs.execute();
			cs.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("类无法找到");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("连接数据库出错");
		} 
		
	}
}
