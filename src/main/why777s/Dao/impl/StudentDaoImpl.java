package Dao.impl;

import Dao.BaseDaoFunc;
import Entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.Connection;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class StudentDaoImpl extends BaseDaoFunc<Student> {
    public void my_procedure(){
        Session session = getSessionFactory().getCurrentSession();
        session.createStoredProcedureCall("call my_proc");



    }
}
