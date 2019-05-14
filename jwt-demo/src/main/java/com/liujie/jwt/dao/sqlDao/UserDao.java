package com.liujie.jwt.dao.sqlDao;

import com.liujie.jwt.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<User,Integer>,JpaSpecificationExecutor {
    User findByUsername(String username);
}
