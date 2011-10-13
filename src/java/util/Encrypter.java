package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author guilherme
 */
public class Encrypter {
    public static String hashify(String str) throws NoSuchAlgorithmException{
        byte[] hash = computeHash(str);
        if(hash==null) return null;
        return byteArrayToHexString(hash);
    }
    private static byte[] computeHash(String str) throws NoSuchAlgorithmException {
        //try{
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            return md.digest();
        //}
//        catch(NoSuchAlgorithmException e){
//            e.printStackTrace();
//            return null;
//        }
    }
    private static String byteArrayToHexString(byte[] ba){
        String s = "";
        for(byte b:ba){
            s+= (b & 0xff) < 16 ? "0" : Integer.toHexString(b&0xff);
        }
        return s;
    }
}
