package com.liujie.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        //1. 创建EntityManagerFactory
        String persistenceUnitName = "jpa";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);

        //2. 创建EntityManager
        EntityManager entityManager = factory.createEntityManager();

        //3.开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //4. 持久化操作
        User user = new User();
        user.setName("tom");
        user.setEmail("222@qq.com");

        //添加user到数据库，相当于hibernate的save();
        entityManager.persist(user);

        //5. 提交事务
        transaction.commit();

        //6. 关闭EntityManager
        entityManager.close();

        //7. 关闭EntityManagerFactory
        factory.close();

    }

}
