package com.webproject.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webproject.dao.EmployeeDAO;
import com.webproject.entity.Employee;

@ManagedBean
@SessionScoped
public class EmployeeBean {
	
	private Employee employee = new Employee();
	private EmployeeDAO dao = new EmployeeDAO();
	private List<Employee> lstEmployees;
	
	
	public void add() {
		try {
			dao.saveEmployee(this.employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method catch the employee's information selected into the dataTable  
	 * @param emp
	 * @return
	 */
	public String get(Employee emp) {
			this.employee = emp;
			return "modify";
	}
	
	/**
	 * After loading employee's information with the previous method get(), 
	 * We already can update any field for this employee in the modify.xhtml 
	 */
	public String update() {
		try {
			dao.updateEmployee(this.employee);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
	public void search() {
		
	}
	
	public void getAll(){
		try {
			this.lstEmployees = dao.getAllEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void delete(Employee emp) {
		try {
			dao.deleteEmployee(emp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public List<Employee> getLstEmployees() {
		return lstEmployees;
	}

	public void setLstEmployees(List<Employee> lstEmployees) {
		this.lstEmployees = lstEmployees;
	}
	
	
}
