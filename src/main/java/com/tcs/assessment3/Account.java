package com.tcs.assessment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tcs.assessment3.*;

public class Account {
	private static final Logger logger = LoggerFactory.getLogger(Account.class);
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
			//Deposit(statement);
			Withdraw(statement);
			
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
		List<String> accounts = new ArrayList<String>();
		while (resultSet.next()) {
			logger.debug(resultSet.getString("OWNER_NAME"));
			logger.debug("id={}",resultSet.getInt(1));
		}
		
	}
	
	private static void Deposit(Statement statement) throws SQLException {
		statement.executeUpdate("UPDATE ACCOUNTS set BALANCE_AMOUNT = BALANCE_AMOUNT + 48000 where ACCOUNT_ID = 987678");
		logger.debug("Amount Deposited");
	}
	private static void Withdraw(Statement statement) throws SQLException {
		
		statement.executeUpdate("UPDATE ACCOUNTS set BALANCE_AMOUNT = BALANCE_AMOUNT - 16000 where BALANCE_AMOUNT >= 1000 and ACCOUNT_ID = 987678" );
		logger.debug("Amount Withdrawn");
	}

	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO ACCOUNTS VALUES(123456, 'Alisha Dias', 394, 76878,'1999-11-16','Savings', 'Active')");
		
	}
}
