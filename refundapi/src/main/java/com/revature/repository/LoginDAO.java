package com.revature.repository;

import java.util.List;

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

    @Override
    public List<Login> getAllUsers(){
        HibernateUtil.beginTransaction();
        List<Login> loginList = HibernateUtil.getSession().createQuery("from Login", Login.class).getResultList();
        HibernateUtil.endTransaction();
        return loginList;
    }

    @Override
    public Login updateUser(Login updatedUser){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().update(updatedUser);
        HibernateUtil.endTransaction();
        return updatedUser;
    }
    
    @Override
    public boolean removeUser(Login userToBeDeleted){
        HibernateUtil.beginTransaction();
        HibernateUtil.getSession().delete(userToBeDeleted);
        HibernateUtil.endTransaction();
        return true;
    }
}
