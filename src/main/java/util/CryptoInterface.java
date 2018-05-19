package util;

public interface CryptoInterface {

    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    byte[] encrypt(byte[] data) throws Exception;
    /**
     * Decrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the decrypted string
     */
    byte[] decrypt(byte[] data) throws Exception;

//    String encrypt(String data) throws Exception;
//    String decrypt(String data) throws Exception;


}
