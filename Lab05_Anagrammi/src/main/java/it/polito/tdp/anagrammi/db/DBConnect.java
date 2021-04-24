package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {

	static private HikariDataSource ds = null;
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root&password=1999";
		
		if(ds== null) {
			ds = new HikariDataSource();
			
			ds.setJdbcUrl(jdbcURL);
			//ds.setUsername("root");
			//ds.setPassword("1999");
			//già fatto nella url ma volendo lo posso fare qua in alternativa
		}
		return ds.getConnection(); //al posto di DriverManager.getConnection(jdbcURL)
	}
}
