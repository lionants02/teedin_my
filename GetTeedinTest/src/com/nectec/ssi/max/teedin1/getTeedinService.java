/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nectec.ssi.max.teedin1;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import mypack.structreturn.xsd.PackParcel;

/**
 *
 * @author Max
 */
public class getTeedinService {
    
    public PackParcel my_getValue(String provincecode,String amphoecode, String ns4No) throws Exception{
        
       
        
        PackParcel out;
        try{
        out=getParcel(provincecode, amphoecode, ns4No);
        }catch(Exception e){
            out=getArea(provincecode, amphoecode, ns4No);
        }
        //if(out.getAMPHURNAME().getValue().length()<1 || out.getAMPHURNAME().getValue().equals("null"))throw new Exception();
        
         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String datecurr=dateFormat.format(date); 
        int status=out.getStatus().getValue().getStatusv();
        
        
        if(status==2){
            String str="";
            str += out.getAreaRai() + "\t";
            str += out.getAreaNang()+ "\t";
            str += out.getAreaWa();
            throw new Exception("ไม่มีข้อมูลที่ตั่ง\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+str+"\t"+datecurr);
        }
        else if (status==-1) {
            throw new Exception("ไม่พบข้อมูล\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"\t"+datecurr);
        }else if(status==1){
            String str = "";
            str += out.getAMPHURNAME().getValue() + "\t";
            str += out.getLANDOFFICENAME().getValue() + "\t";
            str += out.getLANDOFFICEX() + "\t";
            str += out.getLANDOFFICEY() + "\t";
            str += out.getMAPX() + "\t";
            str += out.getMAPY() + "\t";
            str += out.getPARCELNO().getValue() + "\t";
            str += out.getPIN().getValue() + "\t";
            str += out.getPROVINCENAME().getValue() + "\t";
            str += out.getSURVEYNO() + "\t";
            str += out.getTAMBOLNAME().getValue() + "\t";
            str += out.getUTMLANDNO() + "\t";
            str += out.getUTMMAP().getValue() + "\t";
            throw new Exception(str+"ไม่มีข้อมูลเนื้อที่\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"\t"+datecurr);
        }else if(status == -1){
            throw new Exception("ข้อมูลไม่สมบูรณ์\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"\t"+datecurr);
        }else if(status == -2){
            throw new Exception("Ami Server Problem\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"\t"+datecurr);
        }
        return out;
    }    

    private static PackParcel getParcel(java.lang.String provincecode, java.lang.String amphoecode, java.lang.String ns4No) {
        com.nectec.ssi.max.teedinpack.DolParcelADX service = new com.nectec.ssi.max.teedinpack.DolParcelADX();
        com.nectec.ssi.max.teedinpack.DolParcelADXPortType port = service.getDolParcelADXHttpsSoap11Endpoint();
        return port.getParcel(provincecode, amphoecode, ns4No);
    }

    private static PackParcel getArea(java.lang.String provincecode, java.lang.String amphoecode, java.lang.String ns4No) {
        com.nectec.ssi.max.teedinpack.DolParcelADX service = new com.nectec.ssi.max.teedinpack.DolParcelADX();
        com.nectec.ssi.max.teedinpack.DolParcelADXPortType port = service.getDolParcelADXHttpsSoap11Endpoint();
        return port.getArea(provincecode, amphoecode, ns4No);
    }
 

}
