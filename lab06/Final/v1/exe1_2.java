package LAB6;

public class exe1_2 {
	public static void main(String[] args) {
		
		// INICIO DO CODIGO ANTIGO
		Database db = new Database();
		Employee ey1 = new Employee("Andre", 1, 5000);
		Employee ey2 = new Employee("Hugo", 2, 4999);
		Employee ey3 = new Employee("Daniel", 3, 4998);
		db.addEmployee(ey1);
		db.addEmployee(ey2);
		db.addEmployee(ey3);
		db.deleteEmployee(ey3.getEmpNum());
		
		Registos reg = new Registos();
		Empregado emp1 = new Empregado("Leandro", "Silva", 1, 4997); // NÃO PODE SER ADICIONADO POSTERIORMENTE PORQUE O CODIGO JÁ ESTÁ A SER UTILIZADOR POR OUTRO UTILIZADOR
		Empregado emp2 = new Empregado("Bruno", "Bastos", 4, 4996);
		Empregado emp3 = new Empregado("Chico", "Silva", 5, 4995);
		reg.insere(emp1);
		reg.insere(emp2);
		reg.insere(emp3);
		reg.remove(emp3.codigo()); // ELIMINA EMPREGADO CUJO CODIGO=5
		// FIM DO CODIGO ANTIGO
		
		
		
		Repo repo = new Repo();
		repo.addRepo(db.getAllEmployees());
		repo.addRepo(reg.listaDeEmpregados());
		Colaborador col1 = new Colaborador("Tiago", "Gonçalves", 5, 4994); // PODE SER ADICIONADO PORQUE O EMPREGADO CUJO CÓDIGO=5 JÁ FOI ELIMINADO
		Colaborador col2 = new Colaborador("Teletubby", "TB", 6, 4993);
		Colaborador col3 = new Colaborador("Power", "Ranger", 7, 4992);
		repo.add(col1);
		repo.add(col2);
		repo.add(col3);
		
		if(repo.check(1)) {
			// ELIMINA O EMPREGADO ANDRÉ
			System.out.println(repo.remove(1));
		}
		
		repo.print();
		
	}

}
