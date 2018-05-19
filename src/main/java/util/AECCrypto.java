package util;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AECCrypto implements CryptoInterface {
    private static final String ALGORITHM = "AES";

    private String keyValueStr = "InitialKeyValue0";


    @Override
    public byte[] encrypt(byte[] data) throws Exception{
        Cipher cipher = AECCrypto.generateCipher(Cipher.ENCRYPT_MODE, this.keyValueStr);
        byte[] encryptedByteArr=cipher.doFinal(data);
        return encryptedByteArr;
    }


    @Override
    public byte[] decrypt(byte[] data) throws Exception{
        Cipher cipher = AECCrypto.generateCipher(Cipher.DECRYPT_MODE, this.keyValueStr);
        byte[] decryptedByteArr=cipher.doFinal(data);
        return decryptedByteArr;
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
