/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package url_shortner;

import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Dell
 */
public class URL_Shortner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
        
            String json ="{\"longUrl\":\"https://www.facebook.com\"}";
            
            URL url = new URL("https://en-za.wordpress.org/download/#download-install");
            HttpsURLConnection urlcon =(HttpsURLConnection) url.openConnection();
            urlcon.setDoOutput(true);
            urlcon.setRequestMethod("POST");
            urlcon.setRequestProperty("content-Type", "Application/json");
            OutputStream os =urlcon.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            BufferedReader BR  = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
            String shortUrl =json;
            while((shortUrl = BR.readLine())!= null)
            {
            urlcon.connect();
            }
                            
            System.out.println("{\"longUrl\":\"https://www.facebook.com\"}");
            
        }catch(MalformedURLException ax)
        {
        System.out.println(ax);
        }catch(IOException az)
        {
            System.out.println(az);
        }
        
    }
    
}
