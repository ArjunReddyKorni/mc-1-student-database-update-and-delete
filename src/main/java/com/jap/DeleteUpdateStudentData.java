package com.jap;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class DeleteUpdateStudentData
{

    public Connection getConnection(){

        Connection  connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","Arjun@123");
         if(connection != null){
             System.out.println("CONNECTED SUCCESSFULLY");
         }else System.out.println("NOT CONNECTED");
        } catch (ClassNotFoundException e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;

    }

    public void deleteStudentData(){
      // call getConnection() method
        DeleteUpdateStudentData deleteUpdateStudentData = new DeleteUpdateStudentData();
        Connection connection = deleteUpdateStudentData.getConnection();
        int row = 0;
        try {
            Statement st = connection.createStatement();

            row = st.executeUpdate("DELETE  from student WHERE rollNo = 14");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(row == 1){
            System.out.println("ROW DELETED WHERE rollNo = 14");
        }

        //execute delete query
    }

    public void updateStudentData(){
        // call getConnection() method
        DeleteUpdateStudentData deleteUpdateStudentData = new DeleteUpdateStudentData();
        Connection connection = deleteUpdateStudentData.getConnection();
        int row = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student set name = 'suresh' WHERE TotalMarks = 678 AND rollNo = 15 ");
             row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(row == 1){
            System.out.println("update successful");
        }


        //execute update query
    }

    public static void main(String[] args) {
        DeleteUpdateStudentData salesDataDemo = new DeleteUpdateStudentData();
        salesDataDemo.deleteStudentData();
        salesDataDemo.updateStudentData();
    }
}
