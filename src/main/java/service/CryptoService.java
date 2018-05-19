package service;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import config.Config;
import util.CryptoInterface;
import util.IOUtil;

public class CryptoService {
    private CryptoInterface crypto;

    public CryptoService(CryptoInterface crypto) {
        this.crypto = crypto;
    }

    public void encryptFile(String fileName) {
        try {
            byte[] content = IOUtil.readFile(fileName);
            byte[] encryptedContent = crypto.encrypt(content);
            IOUtil.PRINT(encryptedContent.toString());
            IOUtil.writeFile(Config.getEncryptedFile(), encryptedContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decryptFile(String fileName) {
        try {
            byte[] content = IOUtil.readFile(fileName);
            byte[] decryptedContent = crypto.decrypt(content);
            IOUtil.PRINT(decryptedContent.toString());

            IOUtil.writeFile(Config.getDecryptedFile(), decryptedContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
