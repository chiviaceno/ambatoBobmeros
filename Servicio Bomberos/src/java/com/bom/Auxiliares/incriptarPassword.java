
package com.bom.Auxiliares;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class incriptarPassword {
    public static String sha512(String incriptar){
        StringBuilder sb = new StringBuilder();
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(incriptar.getBytes());
            byte[] b = md.digest();
            
            for(int j = 0; j< b.length; j++){
                sb.append(Integer.toString((b[j] & 0xff)+0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
        }
        return sb.toString();
    }
}
