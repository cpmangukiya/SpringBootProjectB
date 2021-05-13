package org.example.experiments;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/camunda","root","root");

        Statement stmt = con.createStatement();
        //Check the username
        ResultSet rs = stmt.executeQuery("select msisdn from msisdn");
        System.out.println("Here is a list of numbers :");
        while(rs.next()){
            String msisdn = rs.getString("msisdn");
            System.out.println(msisdn);
        }

        //Another recommended way to get DB connection
        //Context context = new InitialContext();
        //DataSource dataSource = (DataSource) context.lookup("");

        //https://javaconceptoftheday.com/statement-vs-preparedstatement-vs-callablestatement-in-java/
    }
}
