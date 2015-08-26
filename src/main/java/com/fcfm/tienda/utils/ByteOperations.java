package com.fcfm.tienda.utils;

/**
 * Created by jose.espinoza.lopez on 8/26/2015.
 */
public class ByteOperations {
    final protected static char[] hexArray = "0123456789abcdef".toCharArray();
    public static String ByteToHex(byte[] bytes){
           char [] hexChars = new char[bytes.length * 2];
        for (int j = 0; j< bytes.length; j++ ){
            int v = bytes[j] & 0xFF;
            hexChars[j*2] = hexArray[v >>> 4];
            hexChars[j*2+1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
