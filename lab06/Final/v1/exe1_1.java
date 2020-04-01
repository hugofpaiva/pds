public class exe1_1 {

	public exe1_1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Database db = new Database();
		Employee ey1 = new Employee("Andre", 1, 5000);
		Employee ey2 = new Employee("Hugo", 2, 4999);
		Employee ey3 = new Employee("Daniel", 3, 4998);
		db.addEmployee(ey1);
		db.addEmployee(ey2);
		db.addEmployee(ey3);
		db.deleteEmployee(ey3.getEmpNum());
		
		Registos reg = new Registos();
		Empregado emp1 = new Empregado("Andre", "Morais", 1, 5000);
		Empregado emp2 = new Empregado("Hugo", "Paiva", 2, 4999);
		Empregado emp3 = new Empregado("Daniel", "Gomes", 3, 4998);
		reg.insere(emp1);
		reg.insere(emp2);
		reg.insere(emp3);
		reg.remove(emp3.codigo());
		
		if(reg.isEmpregado(2)) {
			System.out.println("O empregado 2 existe");
		}else {
			System.out.println("O empregado 2 não existe");
		}
		
		if(reg.isEmpregado(4)) {
			System.out.println("O empregado 4 existe");
		}else {
			System.out.println("O empregado 4 não existe");
		}
	}
}
