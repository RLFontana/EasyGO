package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.PropertiesManager;

public class ConnectionFactory {
	private String driverClassName = PropertiesManager.getProperties("driver_class_name");
	private String connectionURL = PropertiesManager.getProperties("db_url");
	
	private static ConnectionFactory connectionFactory = null;
	
	private ConnectionFactory(){
		try{
			Class.forName(driverClassName);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(connectionURL);
		return conn;
	}
	
	public static ConnectionFactory getInstance(){
		if(connectionFactory == null){
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

}