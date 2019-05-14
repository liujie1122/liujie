package com.liujie.jwt;

import com.alibaba.fastjson.JSON;
import com.liujie.jwt.utils.UserInfo;
import com.liujie.jwt.utils.jwt.jwt.JwtUtils;
import com.liujie.jwt.utils.jwt.RsaUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.PrivateKey;
import java.security.PublicKey;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtUtilsTest {

    private static final String pubKeyPath = "C:\\ssh\\rsa.pub";

    private static final String priKeyPath = "C:\\ssh\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 15);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
//        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTUzMzI4MjQ3N30.EPo35Vyg1IwZAtXvAx2TCWuOPnRwPclRNAM4ody5CHk8RF55wdfKKJxjeGh4H3zgruRed9mEOQzWy79iF1nGAnvbkraGlD6iM-9zDW8M1G9if4MX579Mv1x57lFewzEo-zKnPdFJgGlAPtNWDPv4iKvbKOk1-U7NUtRmMsF1Wcg";
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU1NTgyMTI0NH0.j6lJrGZnZ8Gr-CMjmkOFIrpZmpCEaD9tGypQ6nFkznsjr5f-oHldSHWQeOB_cT2qA7RwjnMn7MSbtGWCg5w6qXQE5upOyBc2Fi45fG3fErOa4NeGFIAevPmAwUd-qtspLjsdp7lFKorVGDBdeUsRurNfEoT7XAgsVVCWmHVK3VQ";
        // 解析token
        System.out.println("publicKey==="+ JSON.toJSONString(publicKey));
        UserInfo user = JwtUtils.getUserInfo(publicKey,token);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getName());
    }
}
