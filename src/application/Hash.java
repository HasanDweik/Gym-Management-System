package application;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static String hash_password(String password) throws NoSuchAlgorithmException {
		String hashed="";

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.reset();
		byte[] hash = digest.digest(password.getBytes());
		hashed = bytesToStringHex(hash);
		return hashed;
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String bytesToStringHex(byte[] bytes) {
		char[] hexChars = new char [bytes.length*2];
		for(int i = 0; i<bytes.length;i++) {
			int v = bytes[i] & 0xFF;
			hexChars[i*2] = hexArray[v >>> 4];
			hexChars[i*2+1]=hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

}
