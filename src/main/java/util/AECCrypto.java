package util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import config.PwdConfig;


public class AECCrypto implements CryptoInterface {
    private static final String ALGORITHM = "AES";

    private String keyValueStr;

    public AECCrypto() {
        this.keyValueStr = Optional.ofNullable(PwdConfig.getMainPassword()).orElse("InitialKeyValue0");
    }

    @Override
    public byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = AECCrypto.generateCipher(Cipher.ENCRYPT_MODE, this.keyValueStr);
        byte[] encryptedByteArr = cipher.doFinal(data);
        return encryptedByteArr;
    }


    @Override
    public byte[] decrypt(byte[] data) throws Exception {
        Cipher cipher = AECCrypto.generateCipher(Cipher.DECRYPT_MODE, this.keyValueStr);
        byte[] decryptedByteArr = cipher.doFinal(data);
        return decryptedByteArr;
    }

    /**
     * Generate a new cipher.
     */
    private static Cipher generateCipher(int mode, String keyValueStr) throws Exception {
        Key key = AECCrypto.generateKey(keyValueStr.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance(AECCrypto.ALGORITHM);
        cipher.init(mode, key);
        return cipher;
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey(byte[] key) {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16); // use only first 128 bit
        return new SecretKeySpec(key, AECCrypto.ALGORITHM);
    }
}
