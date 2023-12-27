/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhdidong_hcmus;

/**
 *
 * @author Admin
 */
public class SinhVien_database 
{
    private String ma,ten,ngaysinh,diachi,email;
    private double gpa;

    public SinhVien_database() {
    }

    
    
    public SinhVien_database(String ma, String ten, String ngaysinh, String diachi, String email, double gpa) {
        this.ma = ma;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;
        this.gpa = gpa;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getEmail() {
        return email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "SinhVien_database{" + "ma=" + ma + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", diachi=" + diachi + ", email=" + email + ", gpa=" + gpa + '}';
    }
    
    
}
