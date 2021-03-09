package com.webproject.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.webproject.entity.Employee;
import com.webproject.util.HibernateUtil;

public class EmployeeDAO {
	
	private Session session;
    private Transaction transaction = null;

	
	public Employee findEmployee( Employee employee) {
		Employee emp = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query<Employee> query = session.createQuery("from Employee e where e.names=:name and e.lastNames=:lastName and e.sex=:sex",
					Employee.class).setMaxResults(1);
					query.setParameter("name", employee.getNames());
					query.setParameter("lastName", employee.getLastNames());
					query.setParameter("sex", employee.getSex());
					emp = query.uniqueResult();
					//return person;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return emp;
	}
	
	public Employee saveEmployee(Employee employee) {
		
		Employee emp = null;
		try {
			emp = findEmployee(employee);
			if(emp==null) {
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
			
				emp=new Employee();
				emp.setNames(employee.getNames());
				emp.setLastNames(employee.getLastNames());
				emp.setSex(employee.getSex());
				session.save(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		return emp;
	}
	
	public void deleteEmployee(Employee employee) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
			
		}catch(Exception e) {
			if (transaction != null) 
		        transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		
	}
	
	
	public void updateEmployee(Employee employee) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();

		}catch(Exception e) {
			if (transaction != null) 
		        transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		
	}
	
	public List<Employee> getAllEmployees() {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
		    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		    Root<Employee> rootEntry = cq.from(Employee.class);

		    CriteriaQuery<Employee> all = cq.select(rootEntry);

		    TypedQuery<Employee> allQuery = session.createQuery(all);
		    return allQuery.getResultList();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		return null;
	}
}
