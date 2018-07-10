package com.sunxyaoyu.algorithmlib;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.Cipher;

import Decoder.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * -
 * <p>
 * Created by Sunxy on 2018/7/10.
 */
public class RSA {

    //指定加密算法的名字
    public static String ALGORITHM="RSA";
    //指定key的位数  N的位数  512--65536  默认1024
    public static int KEYSIZE=2048;

    private static Key publicKey;
    private static Key privateKey;

    /**
     * 生成密钥对 公(e,n)   私(d,n)
     */
    public static void generateKeyPair() throws Exception{
        //需要一个安全的随机数源
        SecureRandom sr=new SecureRandom();
        //需要一个KeyPairGenerator对象
        KeyPairGenerator kpg=KeyPairGenerator.getInstance(ALGORITHM);
        //开始产生1和2部中用到的所有数据
        //位数必须是64的倍数，在512--65536之间 默认1024
        kpg.initialize(KEYSIZE,sr);
        //生成密钥对
        KeyPair keyPair=kpg.generateKeyPair();
        //得到公钥
        publicKey=keyPair.getPublic();
        //得到私钥
        privateKey=keyPair.getPrivate();

        //公钥私钥可以保存在本地。。。。。
//        ObjectOutputStream oos1=new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
//        ObjectOutputStream oos2=new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
//        oos1.writeObject(publicKey);
//        oos2.writeObject(privateKey);
//        oos2.close();
//        oos1.close();

    }

    /**
     * 加密
     */
    public static String encrypt(String source, Key publicKey) throws Exception{
        //开始用公钥加密
        Cipher cipher= Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] b=source.getBytes();
        //用base64进行编码    字符和byte转换的一种方式
        byte[] b1=cipher.doFinal(b);
        BASE64Encoder encoder=new BASE64Encoder();
        return encoder.encode(b1);
    }

    /**
     * 解密
     */
    public static String decrypt(String cryptText, Key privateKey) throws Exception{
        //解密
        Cipher cipher=Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        BASE64Decoder decoder=new BASE64Decoder();
        byte[] b1=decoder.decodeBuffer(cryptText);
        byte[] b=cipher.doFinal(b1);
        return new String(b);
    }

    public static void main(String[] args){
        try{
            generateKeyPair();

            //客户端用公钥加密
            String str="客户端用公钥加密";
            String text=encrypt(str, publicKey);
            System.out.println("密文:"+text);

            //到了服务端进行用私钥解密
            String target=decrypt(text, privateKey);
            System.out.println("明文:"+target);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
