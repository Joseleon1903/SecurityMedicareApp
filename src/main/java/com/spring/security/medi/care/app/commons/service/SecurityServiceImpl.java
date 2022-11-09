package com.spring.security.medi.care.app.commons.service;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;

@Service
public class SecurityServiceImpl implements SecurityService {


    @Override
    public String hash256String(String texto) {
        String hashOutput = "";
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(texto.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            hashOutput= hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return hashOutput;
    }
}
