package com.liujie.jwt.service;

import com.liujie.jwt.dao.sqlDao.UserDao;
import com.liujie.jwt.pojo.User;
import com.liujie.jwt.utils.MD5Util;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User userLogin(User user) {
        User recode = userDao.findByUsername(user.getUsername());
        if (recode==null){
            return null;
        }

        if(!MD5Util.verify(user.getPassword(), recode.getPassword())){
            return null;
        }

        return  recode;
    }

    @Transactional
    public User userSave(User user) {
        String password = user.getPassword();
        String saltPassword = MD5Util.generate(password);
        user.setPassword(saltPassword);
        User recode = userDao.save(user);
        return recode;
    }
}
