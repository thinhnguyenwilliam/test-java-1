/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhdidong_hcmus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class Login_DAO extends DAO
{
    public Login_DAO()
    {
        super();
    }
    
    public boolean check_login(String username,String pass)
    {
        String sql="SELECT * FROM tai_khoan WHERE ten_tai_khoan=? AND mat_khau=?";
        try{
            PreparedStatement ps=ket_noi.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            ResultSet res=ps.executeQuery();
            if(res.next())
                return true;
            else
                return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean addTaiKhoan(String username,String pass)
    {
        String sql="INSERT INTO tai_khoan VALUES(?,?)";
        try{
            PreparedStatement ps=ket_noi.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pass);
            int row=ps.executeUpdate();
            if(row!=0)
                return true;
            else
                return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
