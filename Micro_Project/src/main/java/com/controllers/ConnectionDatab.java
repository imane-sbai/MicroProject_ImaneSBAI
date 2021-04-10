package com.controllers;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionDatab  extends HttpServlet{



    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username="root";
    private String password="imanesbai123";
    private String dbName="microprojet";
    
    public Connection connection;

   



    public ConnectionDatab() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ConnectionDatab(String username, String password, String dbName) {
		super();
		this.username = username;
		this.password = password;
		this.dbName = dbName;
	}

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
            		"jdbc:mysql://mysql-25365-0.cloudclusters.net:25365/microprojet", "root", "imanesbai123");
            System.out.println("Connection.");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}