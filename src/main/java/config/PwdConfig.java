package config;

import java.io.File;

public class PwdConfig {

    private static String mainPassword="InitialKeyValue0";

    public static String getMainPassword() {
        return mainPassword;
    }

    public static void setMainPassword(String mainPassword) {
        PwdConfig.mainPassword = mainPassword;
    }

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
        private static String cryptoFilePath = System.getProperty("user.dir");
        private static String originFile = cryptoFilePath + File.separator + "origin.json";
        private static String encryptedFile = cryptoFilePath + File.separator + "encrypted";
        private static String decryptedFile = cryptoFilePath + File.separator + "decrypted.json";
    }
}
