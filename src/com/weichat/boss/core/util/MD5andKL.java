package com.weichat.boss.core.util;

import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;


public class MD5andKL {
	// MD5加码。32位
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}
	
	public static String md5222(String inStr){
		String privateKey = "loveyajuan";
        String tempStr =DigestUtils.md5Hex(privateKey).toUpperCase();
        String tempStr2 =DigestUtils.md5Hex("123123"+tempStr);
        tempStr2 =DigestUtils.md5Hex(tempStr2+tempStr);
        return tempStr2;
	}
	

	public static void main(String[] args) {
		 String privateKey = "loveyajuan";
         String tempStr =DigestUtils.md5Hex(privateKey).toUpperCase();
         System.out.println(tempStr);
         String tempStr2 =DigestUtils.md5Hex("123123"+tempStr);
         tempStr2 =DigestUtils.md5Hex("05bc854d4b5ffc01509d9d29b08f45a5"+"32873ABD5A2AB1922B850501A29ABE48");
         System.out.println(tempStr2);
         
        System.out.println( md5222("123123"));
	}
}
