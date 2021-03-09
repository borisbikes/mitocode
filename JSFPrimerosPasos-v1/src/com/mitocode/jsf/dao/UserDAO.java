package com.mitocode.jsf.dao;


import org.hibernate.Query;
import org.hibernate.Session;

import com.mitocode.jsf.model.User;
import com.mitocode.jsf.util.HibernateUtil;

public class UserDAO {
	private Session session;
	
	public User getUser(User user) throws Exception{
		User us = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "Select e FROM User e"; /*WHERE usName = '" +  user.getUsName()
					+ "' AND usPassword = '" + user.getUsPassword() + "'";*/
			
			Query query = (Query) session.createQuery(hql);
			
			if(!query.list().isEmpty()) {
				us = (User) ((org.hibernate.Query) query).list().get(0);
			}
		}catch (Exception e) {
			throw e;
		}
		return us;
	}

}
