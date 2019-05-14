package com.liujie.jwt.base;

import com.liujie.jwt.utils.jwt.RsaUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

@Data
@Component
//@AllArgsConstructor
//@NoArgsConstructor
//@ConfigurationProperties(prefix = "liujie.jwt")
public class JwtProperties {
    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);
    @Value("${liujie.jwt.secret}")
    private String secret; // 密钥
    @Value("${liujie.jwt.pubKeyPath}")
    private String pubKeyPath;// 公钥地址
    @Value("${liujie.jwt.priKeyPath}")
    private String priKeyPath;// 私钥地址
    @Value("${liujie.jwt.expire}")
    private int expire;// token过期时间
    private PublicKey publicKey; // 公钥
    private PrivateKey privateKey; // 私钥

    /**
     * @PostContruct：在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init(){
        logger.info("初始化公钥私钥");
        try {
            File pubKey = new File(pubKeyPath);
            File priKey = new File(priKeyPath);
            if (!pubKey.exists() || !priKey.exists()) {
                // 生成公钥和私钥
                RsaUtils.generateKey(pubKeyPath, priKeyPath, secret);
            }
            // 获取公钥和私钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
            this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
        } catch (Exception e) {
            logger.error("初始化公钥和私钥失败！", e);
            throw new RuntimeException();
        }
    }

}