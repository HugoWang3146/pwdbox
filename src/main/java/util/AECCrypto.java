package util;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AECCrypto {
    private static final String ALGORITHM = "AES";

    private String keyValueStr = "InitialKeyValue0";

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    public String encrypt(String data) throws Exception{
        Cipher cipher = AECCrypto.generateCipher(Cipher.ENCRYPT_MODE, this.keyValueStr);
        byte[] encryptedByteArr=cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedByteArr);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the decrypted string
     */
    public String decrypt(String data) throws Exception{
        Cipher cipher = AECCrypto.generateCipher(Cipher.ENCRYPT_MODE, this.keyValueStr);
        byte[] decodedByteArr=Base64.getDecoder().decode(data);
        byte[] decryptedByteArr=cipher.doFinal(decodedByteArr);
        return new String(decryptedByteArr);
    }

    /**
     * Generate a new cipher.
     */
    private static Cipher generateCipher(int mode, String keyValueStr) throws Exception{
        Key key = AECCrypto.generateKey(keyValueStr.getBytes());
        Cipher cipher = Cipher.getInstance(AECCrypto.ALGORITHM);
        cipher.init(mode, key);
        return cipher;
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey(byte[] byteArr) {
        return new SecretKeySpec(byteArr, AECCrypto.ALGORITHM);
    }

}
