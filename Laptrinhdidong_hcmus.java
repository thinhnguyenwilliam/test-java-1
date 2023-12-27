/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhdidong_hcmus;

import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author ThinhNguyen
 */
public class Laptrinhdidong_hcmus 
{
    private static String url="jdbc:mysql://localhost:3306/test_buoi_1?autoReconnect=true&useSSL=false";
    private static String username="root";
    private static String password="1234";
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        //Nap driver
        Class.forName("com.mysql.jdbc.Driver");
        Scanner sc=new Scanner(System.in);
        Connection ketNoi=(Connection) DriverManager.getConnection(url, username, password);
        
          
        //check da connect chua?
        if(ketNoi==null)
            System.out.println("tach pen");
        else
        {
            //System.out.println("ok");
            try{
                ketNoi.setAutoCommit(false);//true thi write direct, false thi write virtual
                String sql="INSERT INTO sinhvien VALUES(?,?,?,?,?,?);";
                int n=sc.nextInt();
                sc.nextLine();
                
                for(int i=0;i<n;i++)
                {
                    String maSinhVien=sc.nextLine();
                    String hoTen=sc.nextLine();
                    String ngaySinh=sc.nextLine();
                    String diaChi=sc.nextLine();
                    String email=sc.nextLine();
                    double gpa=sc.nextDouble();
                    sc.nextLine();

                    //preparedstatement thi co tham so khac voi statement binh thuong
                    //truyen tham so vao dau ?
                    PreparedStatement cau_lenh=ketNoi.prepareStatement(sql);


                    ///////////////
                    cau_lenh.setString(1, maSinhVien);
                    cau_lenh.setString(2, hoTen);
                    cau_lenh.setString(3, ngaySinh);
                    cau_lenh.setString(4, diaChi);
                    cau_lenh.setString(5, email);
                    cau_lenh.setDouble(6, gpa);
                    /////////////////

                    int so_luong=cau_lenh.executeUpdate();
                    System.out.println(so_luong);
                }
                ketNoi.commit();
            }catch(SQLException ex){
                System.out.println("Nhay vao rollback");
                ketNoi.rollback();
            }
            
        }
    }   
}


