package com.tcs.assessment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Assessment3 {
	public static void main(String[] args) {
		String DB_URL="jdbc:mysql://localhost:3306/assessment";
		String DB_USER="root";
		String DB_PASSWORD="Nuvelabs123$";
		
		try(Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
				Statement statement = connection.createStatement();){
			//create(statement);//create operation 
			//update(statement);
			//retrieve(statement);
			//delete(statement);
			
		} catch (SQLException e) {
			e.printStackTrace();
		};
	}

	private static void update(Statement statement) throws SQLException {
		statement.execute("UPDATE ACCOUNTS SET OWNER_NAME='Alisha Dias' WHERE ACCOUNT_ID=987678");
		
	}

	private static void delete(Statement statement) throws SQLException {
		statement.execute("DELETE FROM ACCOUNTS WHERE ACCOUNT_ID=123456");
		
	}

	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * from accounts");
		List<String> regions = new ArrayList<String>();
		while (resultSet.next()) {
			//logger.debug(resultSet.getString("OWNER_NAME"));
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getInt("BALANCE_AMOUNT"));
		}
		
	}

	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO ACCOUNTS VALUES(123456, 'Alisha Dias', 394, 76878,'1999-11-16','Savings', 'Active')");
		
	}
}
