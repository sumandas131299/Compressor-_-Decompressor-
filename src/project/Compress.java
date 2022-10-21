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
public class Compress {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "\\Compressedfile.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
        byte[] buffer = new byte[2048];
            int len;
        
        while ((len = fis.read(buffer)) != -1 ){
            gzipOS.write(buffer, 0 ,len);
       }
        gzipOS.close();
        fos.close();
        fis.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\Suman\\Documents\\NetBeansProjects\\CompressorDecompressor\\100MB.txt");
        method(path);
    }
}
