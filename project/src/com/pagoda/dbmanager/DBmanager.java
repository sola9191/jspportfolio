package com.pagoda.dbmanager;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBmanager {

	private static Connection conn;
	public DBmanager() { conn = null;}
	
	public Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource db = (DataSource)envContext.lookup("jdbc/pagoda");
		conn  = db.getConnection();
		return conn;
	}
}
