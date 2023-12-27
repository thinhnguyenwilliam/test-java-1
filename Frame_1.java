/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laptrinhdidong_hcmus;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class Frame_1 extends JFrame
{

    public Frame_1(String tenapp) 
    {
        this.setTitle(tenapp);
        this.setSize(500,300);
        this.setLocationRelativeTo(null);//display center screen
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) 
    {
        Frame_1 x = new Frame_1("Thinh_ngau");
    }
}
