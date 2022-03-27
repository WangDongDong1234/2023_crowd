package com.atguigu.crowd.security.customize;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return myEncode((String) charSequence);
    }



    @Override
    public boolean matches(CharSequence charSequence, String s) {
        //1.对明文密码进行加密
        String  formPassword= myEncode((String)charSequence);
        //2.声明数据库的密码
        String dataBasepassword = s;
        //3.返回对比结果
        return Objects.equals(formPassword,dataBasepassword);
    }

    private String myEncode(String charSequence) {
        try {
            // 1.获取MessageDigest对象
            String algorithm = "md5";

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 2.获取明文字符串对应的字节数组
            byte[] input = charSequence.getBytes();

            // 3.执行加密
            byte[] output = messageDigest.digest(input);

            // 4.创建BigInteger对象
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, output);

            // 5.按照16进制将bigInteger的值转换为字符串
            int radix = 16;
            String encoded = bigInteger.toString(radix).toUpperCase();

            return encoded;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
