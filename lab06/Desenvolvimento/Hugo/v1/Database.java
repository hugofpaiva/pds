package lab06;

import java.util.*;

class Database { // Data elements

	private Vector<Employee> employees;// Stores the employees

	public Database() {
		employees = new Vector<>();
	}

	public boolean addEmployee(Employee employee) {
		if (employees.add(employee)) {
			return true;
		}
		return false;

	}

	public void deleteEmployee(long emp_num) {
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getEmpNum() == emp_num) {
				employees.remove(employees.get(i));
			}
		}
	}

	public Employee[] getAllEmployees() {
		return employees.toArray(new Employee[employees.size()]);
	}

}