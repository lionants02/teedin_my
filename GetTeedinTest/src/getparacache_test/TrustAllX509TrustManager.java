/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getparacache_test;

import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/**
 *
 * @author Max
 */
public class TrustAllX509TrustManager implements X509TrustManager {

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkClientTrusted(java.security.cert.X509Certificate[] certs,
            String authType) {
    }

    public void checkServerTrusted(java.security.cert.X509Certificate[] certs,
            String authType) {
    }
    
    static public void my_passCer(){
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier( new HostnameVerifier(){
                public boolean verify(String string,SSLSession ssls) {
                    return true;
                }
            });     } catch (Exception ex) {
            Logger.getLogger(TrustAllX509TrustManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
