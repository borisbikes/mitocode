package com.webproject.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.webproject.entity.User;
import com.webproject.util.HibernateUtil;

public class UserDAO {
	
	public User findUser( User user) throws Exception{
		User us = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query<User> query = session.createQuery("from User u where u.name=:name and u.password=:pass",
					User.class).setMaxResults(1);
					query.setParameter("name", user.getName());
					query.setParameter("pass", user.getPassword());
					us = query.uniqueResult();
					//return person;
			
		}catch (Exception e) {
			throw e;
		}
		return us;
	}
	
	@SuppressWarnings("unused")
	private User saveUser(User user) throws Exception {
		Session session = null;
		User us = null;
		try {
			us = findUser(user);
			if(us==null) {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
			
				us=new User();
				us.setName(user.getName());
				session.save(user);
			}
		}catch(Exception e) {
			throw e;
		}finally {
			session.close();
		}
		return us;
	}
}
