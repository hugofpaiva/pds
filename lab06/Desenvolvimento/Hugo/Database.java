class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        if(employees.add(employee)){
            return true
        }else{
            return false
        }     
    }

    public void deleteEmployee(long emp_num) {
        for (Empregado x : employees) {
            if (x.codigo == emp_num)
                employees.remove(x);
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }
    
}