package com.yj.letgo.ble;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;

public class AesTools {
	private Cipher mCipher;
	private SecretKeySpec mSkeySpecRequest;
	private SecretKeySpec mSkeySpecResponse;
	private static AesTools mAESUtils_instace;
    static byte[] REQUEST_PRESHARED_KEY = new byte[256];
    static byte[] RESPONSE_PRESHARED_KEY = new byte[256];
    String TAG = "BleStation";
    
	AesTools(){
		try {
			REQUEST_PRESHARED_KEY = Base64.decode("pwf0jsWh6cZdPvLypYSrqXN307T2CLgIZ/VtwBmo8WI=", Base64.DEFAULT);
			RESPONSE_PRESHARED_KEY = Base64.decode("LFxaPOBvx1uVu4AMeM2F4URJEwFryzjEeWk6QDN4BHg=", Base64.DEFAULT);
			mSkeySpecRequest = new SecretKeySpec(REQUEST_PRESHARED_KEY, "AES");
			mSkeySpecResponse = new SecretKeySpec(RESPONSE_PRESHARED_KEY, "AES");
			mCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}
	
    public static AesTools getInstance() {
    	if( mAESUtils_instace == null) {
    		mAESUtils_instace = new AesTools();
    	}
    	return mAESUtils_instace;
    }
	
	public byte[] encryptReq(byte[] data) throws Exception {
		mCipher.init(Cipher.ENCRYPT_MODE, mSkeySpecRequest);
		byte[] encrypted = mCipher.doFinal(data);
		return ByteUtils.byteMerger(mCipher.getIV(), encrypted);
	}
	
	public byte[] decryptReq(byte[] encrypted) throws Exception {
		mCipher.init(Cipher.DECRYPT_MODE, mSkeySpecRequest);
		byte[] decrypted = mCipher.doFinal(encrypted);
		return Arrays.copyOfRange(decrypted, mCipher.getBlockSize(), encrypted.length-2);
	}
	
	
	public byte[] encryptRsp(byte[] data) throws Exception {
		mCipher.init(Cipher.ENCRYPT_MODE, mSkeySpecResponse);
		byte[] encrypted = mCipher.doFinal(data);
		return ByteUtils.byteMerger(mCipher.getIV(), encrypted);
	}
	
	public byte[] decryptRsp(byte[] encrypted) throws Exception {
		mCipher.init(Cipher.DECRYPT_MODE, mSkeySpecResponse);
		byte[] decrypted = mCipher.doFinal(encrypted);
		return Arrays.copyOfRange(decrypted, mCipher.getBlockSize(), encrypted.length-2);
	}
}