/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import project.*;

/**
 *
 * @author Suman
 */
public class view extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompresButton;
    
    view(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        
        
        compressButton = new JButton("Select File to Compresss");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        
        decompresButton = new JButton("select File to Decompress");
        decompresButton.addActionListener(this);
        decompresButton.setBounds(250,100,200,30);
        
        this.add(compressButton);
        this.add(decompresButton);
        this.setSize(500 ,200);
        this.getContentPane().setBackground(Color.blue);
        
    }
    @Override
    public void actionPerformed(ActionEvent e ){
        if(e.getSource()== compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                System.out.println(file);
                try {
                  Compress.method(file);  
                  JOptionPane.showMessageDialog(null,"Compression Sucessfull");
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource()== decompresButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
                System.out.println(file);
                try {
                  Decompress.method(file);  
                  JOptionPane.showMessageDialog(null,"Decompression Sucessfull");
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        
    } 
    
    public static void main( String[] args ) {
        view frame = new view();
        frame.setVisible(true);
    }
}
