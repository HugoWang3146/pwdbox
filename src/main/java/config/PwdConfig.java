package config;

import java.io.File;

public class PwdConfig {

    public static String getCryptoFilePath() {
        return NestedConfig.cryptoFilePath;
    }

    public static String getOriginFile() {
        return NestedConfig.originFile;
    }

    public static String getEncryptedFile() {
        return NestedConfig.encryptedFile;
    }

    public static String getDecryptedFile() {
        return NestedConfig.decryptedFile;
    }

    private static class NestedConfig {
        //        private static String cryptoFilePath = System.getProperty("usr.dir");
        private static String cryptoFilePath = "D:\\";
        private static String originFile = cryptoFilePath + File.separator + "template.json";
        private static String encryptedFile = cryptoFilePath + File.separator + "encrypted";
        private static String decryptedFile = cryptoFilePath + File.separator + "decrypted.json";
    }
}
