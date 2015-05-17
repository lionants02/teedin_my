/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nectec.ssi.max.teedin1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Max
 */
public class C_readLine {
    private File file;
    private  BufferedReader br;
    public C_readLine(String filepath) throws FileNotFoundException {
        this.file = new File(filepath);
        br = new BufferedReader(new FileReader(file));
    }
    
    public String my_readline() {
        try {
            String line;
            if ((line = br.readLine()) != null) {
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void my_closebuff(){
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(C_readLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
