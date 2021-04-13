package com.rm.ums.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Manish.Mourya
 *
 */
public class EncryptionUtils
{
	private static final Logger log = LoggerFactory.getLogger(EncryptionUtils.class);
	private static final String KEY = "23MMAANUIRSYHA88";
	private static final Key SECRETKEY = new SecretKeySpec(KEY.getBytes(), "AES");
  
	/**
	 * @param n
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
	    keyGenerator.init(n);
	    SecretKey key = keyGenerator.generateKey();
	    return key;
	}
	
	/**
	 * @param password
	 * @param salt
	 * @return
	 */
	public static SecretKey getKeyFromPassword(String password, String salt) {
		    
		    try {
				SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
				KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
				SecretKey secret = new SecretKeySpec(factory.generateSecret(spec)
				    .getEncoded(), "AES");
				return secret;
			} catch (Exception e) {
				log.error("ERROR WHILE Getting Key From Password",e);
				return null;
			}
	}
	
	/**
	 * @return
	 */
	public static IvParameterSpec generateIv() {
	    byte[] iv = new byte[16];
	    new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	
	/**
	 * @param input
	 * @return
	 */
	public static String encrypt(String input) {
		    try {
		    	Cipher cipher = Cipher.getInstance("AES");
	            // encrypt the text
	            cipher.init(Cipher.ENCRYPT_MODE, SECRETKEY);
	            byte[] cipherText = cipher.doFinal(input.getBytes());
	           	return Base64.getEncoder()
				    .encodeToString(cipherText);
			} catch (Exception e) {
				log.error("ERROR WHILE encrypting string",e);
				return null;
			}
		}
	
	/**
	 * @param cipherText
	 * @return
	 */
	public static String decrypt(String cipherText) {
		    
		    try {
		    	Cipher cipher = Cipher.getInstance("AES");
	            cipher.init(Cipher.DECRYPT_MODE, SECRETKEY);
	            byte[] plainText = cipher.doFinal(Base64.getDecoder()
					    .decode(cipherText));
				return new String(plainText);
			} catch (Exception e) {
				log.error("ERROR WHILE decrypting string",e);
				return null;
			}
		}
	
}


