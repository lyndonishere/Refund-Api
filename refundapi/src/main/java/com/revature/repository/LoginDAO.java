package com.revature.repository;

import com.revature.entities.Login;
import com.revature.utils.HibernateUtil;


public class LoginDAO implements LoginDAOInterface {

    @Override
    public Login addUser(Login newUser) {
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().save(newUser);
        HibernateUtil.endTransaction();
        return newUser;
    }
    
}
