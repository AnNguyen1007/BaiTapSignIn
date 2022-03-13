/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingConnection;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class SqlConnection {
        public static Connection getConnection() {
        String url = "jdbc:sqlserver://KANIS:1433;databaseName=Annguyen";
        String userName = "sa";
        String password = "123";
    
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userName, password);
//            java.sql.Connection connection =DriverManager.getConnection(url,userName,password);
//            System.out.println("Thanh cong");
            //--------------
//            java.sql.Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from NguoiDung");
//            while(rs.next()){
//                System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
//            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
//            System.out.println("Khong thanh cong");   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }
}
