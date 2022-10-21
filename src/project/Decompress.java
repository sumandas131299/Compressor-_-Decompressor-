/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.*;
import java.util.zip.*;

/**
 *
 * @author Suman
 */
public class Decompress {
    
    public static void method(File file) throws IOException{
       
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\Decompressed.txt");
        GZIPInputStream gis = new GZIPInputStream(fis);
        
        byte[] buffer = new byte[2048];
        int len=0;
        
        while((len = gis.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        
        gis.close();
        fis.close();
        fos.close();
    }
    
    public static void main(String[] args) throws IOException{
        File file = new File("C:\\Users\\Suman\\Documents\\NetBeansProjects\\CompressorDecompressor\\Compressedfile.gz");
        method(file);
        
    }
    
}
