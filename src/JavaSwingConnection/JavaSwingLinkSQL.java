/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaSwingConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Data.users;
import Data.Product;
/**
 *
 * @author ADMIN
 */
public class JavaSwingLinkSQL {
     public List<users> getAllUsers(){
        List<users> users = new ArrayList<>();
        Connection connection = SqlConnection.getConnection();
        
        String sql = "SELECT * FROM NguoiDung";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                users user = new users();
                
                user.setId(rs.getInt("id"));
                user.setTen(rs.getString("ten"));
                user.setSdt(rs.getString("sdt"));
                user.setTenTK(rs.getString("tenTK"));
                user.setMatKhau(rs.getString("matKhau"));
                user.setGioiThieu(rs.getString("gioiThieu"));
                user.setVaiTro(rs.getString("vaiTro"));
                user.setSoThich(rs.getString("soThich"));
                
               users.add(user);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
     public users checkTKMK(users usercantim )
    {
        users user= new users();
        Connection connection = SqlConnection.getConnection();
        
        String sql = "SELECT * FROM NguoiDung "
                + "WHERE tenTK=? and matKhau=?";
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usercantim.getTenTK());
            preparedStatement.setString(2, usercantim.getMatKhau());
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();      
            user.setId(rs.getInt("ID"));
            user.setTen(rs.getString("ten"));
            user.setSdt(rs.getString("sdt"));
            user.setTenTK(rs.getString("tenTK"));
            user.setMatKhau(rs.getString("matKhau"));
            user.setGioiThieu(rs.getString("gioiThieu"));
            user.setVaiTro(rs.getString("vaiTro"));
            user.setSoThich(rs.getString("soThich"));
            return user;
        } catch(SQLException e){
            System.out.println("Sai tài khoản hoặc mật khẩu");
            return null;
        }
    }
      public void addUser (users user){
            Connection connection = SqlConnection.getConnection();
            
            String sql = "INSERT INTO NguoiDung (Ten,Sdt,TenTK,Matkhau,GioiThieu,VaiTro,SoThich) "
                    + "values (?,?,?,?,?,?,?) "
                    ;
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getTen());
                preparedStatement.setString(2, user.getSdt());
                preparedStatement.setString(3, user.getTenTK());
                preparedStatement.setString(4, user.getMatKhau());
                preparedStatement.setString(5, user.getGioiThieu());
                preparedStatement.setString(6, user.getVaiTro());
                preparedStatement.setString(7, user.getSoThich());
                
               int rs = preparedStatement.executeUpdate();
               System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
      public List<Product> getAllProduct(){
        List<Product> Product = new ArrayList<Product>();
        Connection connection = SqlConnection.getConnection();
        
        String sql = "SELECT * FROM SanPham";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                Product pr = new Product();
                
                pr.setId(rs.getString("ID"));
                pr.setTenSP(rs.getString("tenSP"));
                pr.setGia(rs.getString("gia"));
                pr.setTrangThai(rs.getString("trangThai"));               
                
               Product.add(pr);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return Product;
    }
      public void addProduct (Product pr){
            Connection connection = SqlConnection.getConnection();
            
            String sql = "INSERT INTO SanPham (ID,tenSP,gia,trangThai) "
                    + "values (dbo.FN_idTiepSanPham(),?,?,?) "
                    ;
            
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, pr.getTenSP());
                preparedStatement.setString(2, pr.getGia());
                preparedStatement.setString(3, pr.getTrangThai());
                
               int rs = preparedStatement.executeUpdate();
               System.out.println(rs);
                preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        

    public void deleteProduct(int id){
        Connection connection = SqlConnection.getConnection();
        
        String sql = "delete from SanPham where ID = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            System.out.println("xoa bi loi");
        }
    }
public Product getdataProduct(String productid)
    {
        Product product= new Product();
        Connection connect = SqlConnection.getConnection();
        
        try {
            String sql=  "select * " +
                         "from SanPham " +
                         "where ID=? ";
            PreparedStatement pstmt = connect.prepareStatement(sql);
            pstmt.setString(1,productid);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            product.setId(rs.getString("ID"));// tên cột
            product.setTenSP(rs.getString("tenSP"));
            product.setGia(rs.getString("gia"));
            product.setTrangThai(rs.getString("trangThai"));            
            return product;
            
        }
        catch(SQLException e)
        {
            System.out.println("tim product theo ma khong thay");
            return null;
        }      
    }
    
    public void updateDataProduct(Product product)
    {
        Connection connect = SqlConnection.getConnection();
        try {
            String sql=  "UPDATE SanPham "
                    + "SET tenSP=?,gia=?,trangThai=? "
                    + "WHERE maSP=?";
            PreparedStatement pstmt = connect.prepareStatement(sql);
            
            pstmt.setString(1, product.getTenSP());
            pstmt.setString(2, product.getGia());
            pstmt.setString(3, product.getTrangThai());
            pstmt.setString(4, product.getId());
            pstmt.execute();
        }
        catch(SQLException e)
        {
            System.out.println("Lỗi lúc cập nhật dữ liệu SP lên");
        }      
    }
    

}
