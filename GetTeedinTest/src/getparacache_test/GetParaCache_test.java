/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getparacache_test;

import com.nectec.ssi.max.teedin1.C_WriteTeedinToFile;
import com.nectec.ssi.max.teedin1.C_readLine;
import com.nectec.ssi.max.teedin1.getTeedinService;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypack.structreturn.xsd.PackParcel;

/**
 *
 * @author SSI
 */
public class GetParaCache_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                TrustAllX509TrustManager.my_passCer();
        getTeedinService func=new getTeedinService();
        //ArrayOfParcel result=getParcel("13", "01", "99999");
        PackParcel out;
        C_readLine readline;
        
        try {
            readline=new C_readLine("C:\\Users\\Max\\Desktop\\data_get_cache.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetParaCache_test.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String currentn4 = readline.my_readline().trim();
        //String[] data=linedata.split("\t");asdfsadf
        //String currentn4=data[2].trim();
        //System.out.println(data[2].trim());
        /*for (String data1 : data) {
            System.out.println(data1.trim());
        }*/
        
        C_WriteTeedinToFile writeerfi = new C_WriteTeedinToFile("C:\\Users\\Max\\Desktop\\data_cache.txt");
        while (currentn4 != null) {
            
            try {
                
                out=null;
                out = func.my_getValue("40", "01", currentn4);
                writeerfi.writeToFile("40", "01", currentn4, out);
            } catch (Exception ex) {
                
                try {
                    out=null;
                    out = func.my_getValue("40", "01", currentn4);
                    writeerfi.writeToFile("40", "01", currentn4, out);
                } catch (Exception ex1) {
                    try {
                        out=null;
                        out = func.my_getValue("40", "01", currentn4);
                        writeerfi.writeToFile("40", "01", currentn4, out);
                    } catch (Exception ex2) {
                        Logger.getLogger(GetParaCache_test.class.getName()).log(Level.SEVERE, null, ex2);
                        writeerfi.writeToFileErr("40", "01", currentn4,ex2.getMessage());
                    }                    
                }                
                //writeerfi.writeToFileErr("40", "01", currentn4);
            }finally{
                currentn4 = readline.my_readline().trim();
                
            }
        }
        readline.my_closebuff();
    }

    
}
