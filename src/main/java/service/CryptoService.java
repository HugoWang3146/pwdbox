package service;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

import config.PwdConfig;
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
            writeFile(PwdConfig.getEncryptedFile(), encryptedContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void decryptFile(String fileName) {
        try {
            byte[] content = IOUtil.readFile(fileName);
            byte[] decryptedContent = crypto.decrypt(content);
            writeFile(PwdConfig.getDecryptedFile(), decryptedContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String decrypt(String fileName) {
        try {
            byte[] content = IOUtil.readFile(fileName);
            byte[] decryptedContent = crypto.decrypt(content);
            return new String(decryptedContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeFile(String fileName, byte[] data) {
        IOUtil.writeFile(fileName, data);
    }
}
