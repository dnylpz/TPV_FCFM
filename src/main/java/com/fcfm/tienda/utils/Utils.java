package com.fcfm.tienda.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jose.espinoza.lopez on 8/26/2015.
 */
public class Utils {
    final protected static char[] hexArray = "0123456789abcdef".toCharArray();

    public static String hashPassword(String pass) {
        String passHex;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passbytes = pass.getBytes("UTF-8");
            byte[] digested = md.digest(passbytes);
            passHex = byteToHex(digested);

            return passHex;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String byteToHex(byte[] bytes){
           char [] hexChars = new char[bytes.length * 2];
        for (int j = 0; j< bytes.length; j++ ){
            int v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v >>> 4];
            hexChars[j*2+1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
