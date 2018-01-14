package br.com.javamon.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB4FreeTest {
	
	public void getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://db4free.net:3307/stmdb?",
				"javamon",
				"Excalibur1209+");
	}
}
