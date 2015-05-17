/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nectec.ssi.max.teedin1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import mypack.structreturn.xsd.PackParcel;

/**
 *
 * @author Max
 */
public class C_WriteTeedinToFile {
    private File file;

    public C_WriteTeedinToFile(String pathfile) {
        this.file = new File(pathfile);
    }
    
    
    public void writeToFile(String provincecode,String amphoecode,String ns4No,PackParcel data){
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String datecurr=dateFormat.format(date); 
        String out = provincecode + "\t" + amphoecode + "\t" + ns4No + "\t";
        out += data.getAMPHURNAME().getValue() + "\t";
        out += data.getLANDOFFICENAME().getValue() + "\t";
        out += data.getLANDOFFICEX() + "\t";
        out += data.getLANDOFFICEY() + "\t";
        out += data.getMAPX() + "\t";
        out += data.getMAPY() + "\t";
        out += data.getPARCELNO().getValue() + "\t";
        out += data.getPIN().getValue() + "\t";
        out += data.getPROVINCENAME().getValue() + "\t";
        out += data.getSURVEYNO() + "\t";
        out += data.getTAMBOLNAME().getValue() + "\t";
        out += data.getUTMLANDNO() + "\t";
        out += data.getUTMMAP().getValue() + "\t";
        out+=data.getUTMSCALE()+"\t";
        out+=data.getAreaRai()+"\t";
        out+=data.getAreaNang()+"\t";
        out+=data.getAreaWa()+"\t";
        out+=datecurr+"\r\n";
        //System.out.println(out);
        //int err=comparetext(dataorg, out.split("\t"));        
        //out+="\r\n";
        writeStrToFile(out);
    }
    public void writeToFileErr(String provincecode,String amphoecode,String ns4No,String errstr){
        String out = provincecode + "\t" + amphoecode + "\t" + ns4No + "\t"+errstr+"\r\n";
        //int err=comparetext(dataorg, out.split("\t"));        
        //out+=err+"\r\n";
        writeStrToFile(out);
    }
    
    private int comparetext(String[] data1,String[] data2){
        int i=0;
        if(data1.length!=data2.length)return 100;
        
        try{
        for (int j = 0; j < data1.length; j++) {
            if(j>=17)
                data1[j]=Double.toString(Double.parseDouble(data1[j].trim()));
            if(!(data1[j].trim().endsWith(data2[j].trim())))
                i++;
        }
        }catch (Exception e){
            return 80;
        }
        return i;
    }
    
    private void writeStrToFile(String str) {
        FileWriter writer;
        try {
            writer = new FileWriter(file, true);  //True = Append to file, false = Overwrite
            writer.write(str);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
