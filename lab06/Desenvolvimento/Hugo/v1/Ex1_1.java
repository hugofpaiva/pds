package lab06;

class Ex1_1 {
    private static Database db1 = new Database();
    private static Registos db2 = new Registos();

    public static void main(String[] args){
        db1.addEmployee(new Employee("Hugo", 5, 14124124));
        db1.addEmployee(new Employee("André", 6, 600));
        db1.addEmployee(new Employee("Joao", 7, 700));
        
        db2.insere(new Empregado("Hugo", "Almeida", 5, 14124124));
        db2.insere(new Empregado("André", "Morais", 6, 600));
        db2.insere(new Empregado("Joao", "Félix", 7, 700));
        
        db1.deleteEmployee(5);
        db2.remove(7);
        
        System.out.println(db2.isEmpregado(6));
        
        for(Employee x: db1.getAllEmployees()) {
        	System.out.println(x.getName());
        }
        
        for(Empregado x: db2.listaDeEmpregados()) {
        	System.out.println(x.nome());
        }
        

        
        

    }

}