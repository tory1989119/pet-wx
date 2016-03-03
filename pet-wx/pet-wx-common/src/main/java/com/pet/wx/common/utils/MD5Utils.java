package com.pet.wx.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * md5签名
     * 
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getMD5String(String source) throws UnsupportedEncodingException {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuffer result = new StringBuffer();
            try {
                for (byte b : md.digest(source.getBytes("UTF-8"))) {
                    result.append(Integer.toHexString((b & 0xf0) >>> 4));
                    result.append(Integer.toHexString(b & 0x0f));
                }
            } catch (UnsupportedEncodingException e) {
                for (byte b : md.digest(source.getBytes())) {
                    result.append(Integer.toHexString((b & 0xf0) >>> 4));
                    result.append(Integer.toHexString(b & 0x0f));
                }
            }
            return result.toString();
        } catch (NoSuchAlgorithmException ex) {
        }
        return null;
    }
}
