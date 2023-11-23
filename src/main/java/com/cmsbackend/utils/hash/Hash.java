package com.cmsbackend.utils.hash;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class Hash {
    private static String  secretKey = "mySecretKey";

    public static String encoder(String origin){
        String encodedKey = Base64.encodeBase64String(secretKey.getBytes());
        // 加密密码
        String hashedPassword = DigestUtils.sha256Hex(origin + encodedKey);
        return hashedPassword;
    }

    public static  boolean match(String orgin,String hash)
    {
        String encodedKey = Base64.encodeBase64String(secretKey.getBytes());
        boolean passwordsMatch = hash.equals(DigestUtils.sha256Hex(orgin + encodedKey));
        return passwordsMatch;
    }
}
