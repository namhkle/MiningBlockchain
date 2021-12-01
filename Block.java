/**
 * Implementing the process of block chain mining and proof of work
 *
 * @author Nam Le
 * @version August 02 2020
 */

import java.util.*;
import java.security.MessageDigest;

public class Block {
    public int blockNo = 0;
    private String data;
    public String hash;
    public int nonce = 0;
    public String previousHash;
    private long timeStamp;
    public Block next;

    public Block(String data) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = hash();
    }

    public String hash() {
        String calculatedHash = Sha256(previousHash + Long.toString(timeStamp)
                + Integer.toString(nonce) + data);
        return calculatedHash;
    }

    public static String Sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to input, 
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Block Hash: " + hash +
                "\nBlock No: " + blockNo +
                "\nBlock Data: " + data +
                "\nNonce: " + nonce;
    }
}

