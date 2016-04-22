import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class XTS {
	
	
	public static void main(String[] args) throws Exception {
		
		String FileName = "encryptedtext.txt";
        String FileName2 = "decryptedtext.txt";

        byte[] i = new byte[16];
		byte[] key = new byte[16];
		for (int j = 0 ; j< 16; j++){
			i[j]=7;
			key[j]=17;
		}
		
        byte[] byteText = "Your Plain Text Here".getBytes();
        Files.write(Paths.get(FileName), enkripsi(byteText,key));
        
        byte[] cipherText = Files.readAllBytes(Paths.get(FileName));
        Files.write(Paths.get(FileName2), dekripsi(cipherText,key));
 
    }
	//return dalam bentuk array of byte enkripsi
	public static byte[] enkripsi(byte[] i, byte[] key) throws Exception{
		SecretKey SecKey = new SecretKeySpec(key, 0, key.length, "AES") ;
		Cipher AesCipher = Cipher.getInstance("AES");
		AesCipher.init(Cipher.ENCRYPT_MODE, SecKey);
        byte[] byteCipherText = AesCipher.doFinal(i);
        return byteCipherText;
	
	}
	//return dalam bentuk array of byte dekripsi
	public static byte[] dekripsi(byte[] i, byte[] key) throws Exception{
		SecretKey SecKey = new SecretKeySpec(key, 0, key.length, "AES") ;
		Cipher AesCipher = Cipher.getInstance("AES");
		AesCipher.init(Cipher.DECRYPT_MODE, SecKey);
        byte[] byteCipherText = AesCipher.doFinal(i);
        return byteCipherText;	
	}
}
	

	

