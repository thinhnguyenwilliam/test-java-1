/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhdidong_hcmus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SinhVienDAO extends DAO
{
    public SinhVienDAO()
    {
        super();//goi constructor tao ket noi
    }
    //tim kiem sinh vien thong qua ma sinh vien trong DB
    public SinhVien_database getSVbyID(String ID)
    {
        SinhVien_database sv=null;
        String sql="SELECT *FROM sinhvien WHERE Masv=?";
        try{
            PreparedStatement ps=ket_noi.prepareStatement(sql);
            ps.setString(1, ID);
            ResultSet res=ps.executeQuery();
            if(res.next())
            {
                sv=new SinhVien_database();
                sv.setMa(res.getString(1));
                sv.setTen(res.getString(2));
                sv.setNgaysinh(res.getString(3));
                sv.setDiachi(res.getString(4));
                sv.setEmail(res.getString(5));
                sv.setGpa(res.getDouble(6));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return sv; 
    }
    
    //them sinh vien vao db
    public boolean addSinhVien(SinhVien_database s)
    {
        String sql="INSERT INTO sinhvien VALUES(?,?,?,?,?,?);";
        try{
            PreparedStatement ps=ket_noi.prepareStatement(sql);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.setString(3, s.getNgaysinh());
            ps.setString(4, s.getDiachi());
            ps.setString(5, s.getEmail());
            ps.setDouble(6, s.getGpa());
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
    
    //tim danh sach sinh vien
    public ArrayList<SinhVien_database> getSVbyaddress(String address)
    {
        ArrayList<SinhVien_database> arr=new ArrayList<>();
        String sql="SELECT *FROM sinhvien WHERE diachi=?";
        try{
            PreparedStatement ps=ket_noi.prepareStatement(sql);
            ps.setString(1, address);
            ResultSet res=ps.executeQuery();
            while(res.next())
            {
                SinhVien_database s=new SinhVien_database(res.getString(1),res.getString(2),res.getString(3),
                res.getString(4),res.getString(5),Double.parseDouble(res.getString(6)));
                arr.add(s);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            return arr;
        }
    }
    
    //tim danh sach sinh vien theo cum ten 
    public ArrayList<SinhVien_database> getSVbyname(String ten)
    {
        ArrayList<SinhVien_database> arr=new ArrayList<>();
        String sql="SELECT *FROM sinhvien WHERE Hoten LIKE ?";
        try{
            PreparedStatement ps=ket_noi.prepareStatement(sql);
            ps.setString(1, "%"+ten+"%");
            ResultSet res=ps.executeQuery();
            while(res.next())
            {
                SinhVien_database s=new SinhVien_database(res.getString(1),res.getString(2),res.getString(3),
                res.getString(4),res.getString(5),Double.parseDouble(res.getString(6)));
                arr.add(s);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            return arr;
        }
    }
}
