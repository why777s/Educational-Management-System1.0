package other;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by why777s on 2017/5/18.
 */


public class MD5 {
    // 获得MD5加密后的字符串
    public String getMD5(String str) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String new_str=base64en.encode(md5.digest(str.getBytes("utf-8")));
        System.out.println(new_str);
        return new_str;
    }

    //test
    public static void main(String[] args) {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            String str = "admin02";
            String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
            System.out.println(newstr);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
