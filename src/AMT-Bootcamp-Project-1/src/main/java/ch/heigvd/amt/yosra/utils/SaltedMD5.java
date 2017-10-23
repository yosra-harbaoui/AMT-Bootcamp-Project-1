/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: class to hash passwords
*/

package ch.heigvd.amt.yosra.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SaltedMD5
{
    //for simplicity, the salt is common for all users.
    private static final String SALT = "AMT-BOOTCAMP";
    
    public static String getSecurePassword(String passwordToHash)
    {
        String generatedPassword = null;
        try 
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(SALT.getBytes());
            byte[] bytes = messageDigest.digest(passwordToHash.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            
            for(int i = 0; i < bytes.length ;i++)
            {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = stringBuilder.toString();
        }
        catch (NoSuchAlgorithmException e) 
        {
        }
        
        return generatedPassword;
    }
}