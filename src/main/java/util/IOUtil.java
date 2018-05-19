package util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil {

    public static void PRINT(String string) {
        System.out.println(string);
    }

    public static void writeFile(String fileName, byte[] data) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            fos.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] readFile(String fileName) {
        InputStream fis = null;
        byte[] result = null;
        if (!new File(fileName).isFile()) {
            IOUtil.PRINT("wrong file");
            return result;
        }
        try {
            fis = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int cursor;
            byte[] data = new byte[2048];
            while ((cursor = fis.read(data, 0, data.length)) != -1) {
                baos.write(data, 0, cursor);
            }
            baos.flush();
            result = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
