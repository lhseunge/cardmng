package com.seung.cardmng.service.impl;

import com.seung.cardmng.service.EncryptService;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Service
public class EncryptServiceImpl implements EncryptService {

    private final AesBytesEncryptor aesBytesEncryptor;

    public EncryptServiceImpl(AesBytesEncryptor aesBytesEncryptor) {
        this.aesBytesEncryptor = aesBytesEncryptor;
    }

    @Override
    public String encrypt(String s) {
        byte[] encrypt = aesBytesEncryptor.encrypt(s.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(encrypt);
    }

    @Override
    public String decrypt(String s) {
        byte[] decryptBytes = stringToByteArray(s);
        byte[] decrypt = aesBytesEncryptor.decrypt(decryptBytes);
        return new String(decrypt, StandardCharsets.UTF_8);
    }

    public String byteArrayToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte abyte :bytes){
            sb.append(abyte);
        }
        return sb.toString();
    }

    public byte[] stringToByteArray(String byteString) {
        String[] split = byteString.split("\\s");
        ByteBuffer buffer = ByteBuffer.allocate(split.length);
        for (String s : split) {
            buffer.put((byte) Integer.parseInt(s));
        }
        return buffer.array();
    }
}
