package com.csdn.util.dense;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Administrator on 2016/8/23.
 */
public class Aes256Encryptor {

    private static final String keys = "@@qwe9999000**&&0_+%9a!~^*#kL3:A";
    private static final String iv = "*ad7125809$%*al_";
    private static final byte[] key = getKey();
    private static final String transform = "AES256/ECB/PKCS7";
    private static final String algorithm = "AES";
    private static final SecretKeySpec keySpec = new SecretKeySpec(key, algorithm);


    public static byte[] getKey() {
        byte[] key1 = null;
        try {
            key1 = keys.getBytes("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key1;
    }


    public static String decrypt(String pHexText, String pIv) {
        String result = "";
        try {
            Cipher cipher = Cipher.getInstance(transform);
            byte[] encryptedBytes = pHexText.getBytes("utf-8");
            //byte[] encryptedBytes = Hex.decode(pHexText);

            byte[] iv = createIV(pIv);

            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            System.arraycopy(decryptedBytes, 0, encryptedBytes, 0, encryptedBytes.length);

            result = new String(encryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.trim();

    }

    public static String encrypt(String pData, String pIv) {
        String result = "";
        try {
            Cipher cipher = Cipher.getInstance(transform);
            byte[] iv = createIV(pIv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
            byte[] output = cipher.doFinal(paddingData(pData));
            byte[] encryptedContent = new byte[output.length];
            System.arraycopy(output, 0, encryptedContent, 0, encryptedContent.length);
            result = new String(encryptedContent, "UTF-8").toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static byte[] paddingData(String pData) {
        byte[] bytes = pData.getBytes();
        int length = bytes.length / 16;
        if (length * 16 < bytes.length) {
            length++;
        }
        byte[] result = new byte[length * 16];
        System.arraycopy(bytes, 0, result, 0, bytes.length);
        for (int i = bytes.length; i < result.length; i++) {
            result[i] = 0x00;

        }
        return result;
    }

    private static byte[] createIV(String pIv) throws UnsupportedEncodingException {

        byte[] bytes = pIv.getBytes("US-ASCII");

        int length = bytes.length / 16;

        if (length * 16 < bytes.length) {

            length++;

        }

        byte[] result = new byte[16];

        System.arraycopy(bytes, 0, result, 0, bytes.length > 16 ? 16 : bytes.length);

        for (int i = bytes.length; i < result.length; i++) {

            result[i] = 0x00;

        }
        return result;

    }
}
