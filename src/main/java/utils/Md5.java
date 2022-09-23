package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public static String getMD5(String s){
        byte[] d= null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            d = md5.digest(s.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String str = new BigInteger(1, d).toString(16);
        return str;

    }
}
