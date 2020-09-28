package com.policy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.policy.domain.LicPolicy;

public class LicPolicyDAO {
	public static Connection connection=null;
	public  static Statement statement=null;
    public static PreparedStatement prepareStmt=null;
	public static ResultSet resultSet=null;
	
	//Connects to LIC_POLICY_DATABASE
	public static Connection  openConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIC_POLICY_DATABASE","root","1234");
			 if(connection!=null) {
				 System.out.println(" Database Connection successfull !\n");
			 }
		} catch (ClassNotFoundException exception) {
			System.out.println(" Database Connection failed !\n");
			exception.printStackTrace();
		}
		return connection;
	}
	//Disconnects from LIC_POLICY_DATABASE
	public static void closeConnection() {
		try 
		{
			if(statement!=null)
				statement.close();
			if(connection!=null)
				connection.close();
		}
		catch(Exception exception) 
		{
			System.out.println(exception.toString());
		}
	}
	
	//Inserts new policy holder details into database
	public int createPolicy(LicPolicy policyObject) {
		int result = 0;
		
		try 
		{
			openConnection();
			statement= connection.createStatement();
			
			prepareStmt = connection.prepareStatement("INSERT INTO LIC_POLICY" 
			+ "(POLICY_NAME,POLICY_HOLDER_NAME,POLICY_START_DATE,PREMIUM_AMOUNT,PREMIUM_TYPE) VALUES \r\n" 
			+ "( ?,?,?,?,?)");
			
			prepareStmt.setString(1,policyObject.getPolicyName());
			prepareStmt.setString(2,policyObject.getPolicyHolderName());
			prepareStmt.setString(3,policyObject.getPolicyStartDate());
			prepareStmt.setFloat(4,policyObject.getPremiumAmount());
			prepareStmt.setString(5,policyObject.getPremiumType());
			
			result = prepareStmt.executeUpdate();
		} 
		catch (SQLException sqlexp) 
		{
			sqlexp.printStackTrace();
		} 
		finally {
			closeConnection();
		}
		return result;
	}
	
	// Reads or Displays policy holder details from LIC Policy database by accepting the policy number
	public boolean readPolicy(LicPolicy policyObject) throws SQLException {
		try 
		{
			openConnection();
			statement= connection.createStatement();
			resultSet= statement.executeQuery("SELECT * FROM LIC_POLICY WHERE POLICY_NUMBER="+ policyObject.getPolicyNumber());
			
			if(resultSet.next())
			{
				resultSet=statement.executeQuery("SELECT * FROM LIC_POLICY WHERE POLICY_NUMBER=\n"+ policyObject.getPolicyNumber());	
			while(resultSet.next()) {
				System.out.println("Policy_Number : "+resultSet.getInt("POLICY_NUMBER")+ "\n"+
			    		"\nPolicy_Name : "+resultSet.getString("POLICY_NAME")+ "\n"+
			    		"\nPolicy_Holder_Name :"+resultSet.getString("POLICY_HOLDER_NAME")+"\n"+
			    		"\nPolicy_Start_Date : "+resultSet.getString("POLICY_START_DATE")+"\n"+
			    		"\nPremium_Amount : "+resultSet.getFloat("PREMIUM_AMOUNT")+"\n"+
			    		"\nPremium_Type : "+resultSet.getString("PREMIUM_TYPE") );
				}
			}
			else
			{
				System.out.println("LIC Policy Holder not found....");
			}
		}catch(NullPointerException exception) {
			exception.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return true;
	}
	
	//Updates the premium amount column in LIC Policy database  by accepting the policy number 
	public int updatePolicy(LicPolicy policyObject)  {
		int result=0;
		try 
		{
			openConnection();
			statement= connection.createStatement();
		    prepareStmt=connection.prepareStatement("UPDATE LIC_POLICY SET PREMIUM_AMOUNT=? WHERE POLICY_NUMBER=?");
			
			prepareStmt.setFloat(1, policyObject.getPremiumAmount());
			prepareStmt.setInt(2, policyObject.getPolicyNumber());
			 
			result=prepareStmt.executeUpdate();
			 
		} catch (SQLException sqlexp) {
			sqlexp.printStackTrace();
		}
		finally { 
			closeConnection();
		}
		 return result;
	}
	
	//deletes the policy holder details in LIC Policy database by accepting the policy number
	public int deletePolicy(LicPolicy policyObject) {
		int result=0;
		try 
		{
			openConnection();
			statement= connection.createStatement();
			
			prepareStmt = connection.prepareStatement("DELETE FROM LIC_POLICY WHERE POLICY_NUMBER=?");
			prepareStmt.setInt(1,policyObject.getPolicyNumber() );
		
			result = prepareStmt.executeUpdate();
		} 
		catch (SQLException sqlexp) 
		{
			sqlexp.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return result;		
	}

}

