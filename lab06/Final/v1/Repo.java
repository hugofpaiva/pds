import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Repo {
	private ArrayList<Colaborador> colaboradores; // NOVA LISTA COM EMPREGADOS
	private Vector<Employee> employees; // LISTA DOS EMPREGADOS DA SWEET
	private ArrayList<Empregado> empregados; // LISTA DOS EMPREGADOS DA PETISCOS
	

	public Repo() {
		this.colaboradores=new ArrayList<>();
	}
	
	public void addRepo(Employee[] employees) {
		// ADICIONA OS EMPREGADOS DA SWEET QUE AINDA NÃO ESTIVEREM NA BASE DE DADOS
		this.employees=new Vector<>();
		for(int i=0; i<employees.length; i++) {
			if(!check((int)employees[i].getEmpNum())) {
				this.employees.add(employees[i]);
			}
		}
	}
	
	public void addRepo(List<Empregado> empregados) {
		// ADICIONA OS EMPREGADOS DA PETISCO QUE AINDA NÃO ESTIVEREM NA BASE DE DADOS
		this.empregados=new ArrayList<>();
		for(int i=0; i<empregados.size(); i++) {
			if(!check((int)empregados.get(i).codigo())) {
				this.empregados.add(empregados.get(i));
			}
		}
	}
	
	public boolean add(Colaborador c) {
		// COMEÇA POR VERIFICAR SE JÁ EXISTE ALGUM TRABALHADOR COM O MESMO CÓDIGO
		if(check(c.getCodigo())) {
			return false;
		}else {
			if(colaboradores.add(c)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean remove(int codigo) {
		/*
			* PROCURA/REMOVE EM TODAS AS LISTAS
			* colaboradores - nova lista
			* empregados - lista dos empregados da Petiscos
			* employees - lista dos empregados da Sweet
		*/

		for(int i=0; i<colaboradores.size(); i++) {
			if(colaboradores.get(i).getCodigo()==codigo) {
				colaboradores.remove(colaboradores.get(i));
				return true;
			}
		}
		
		for(int i=0; i<empregados.size(); i++) {
			if(empregados.get(i).codigo()==codigo) {
				empregados.remove(empregados.get(i));
				return true;
			}
		}
		
		for(int i=0; i<employees.size(); i++) {
			if(employees.get(i).getEmpNum()==codigo) {
				employees.remove(employees.get(i));
				return true;
			}
		}
		
		return false;
	}
	
	public boolean check(int codigo) {
		/*
			* PROCURA EM TODAS AS LISTAS
			* colaboradores - nova lista
			* empregados - lista dos empregados da Petiscos
			* employees - lista dos empregados da Sweet
		*/

		if(this.colaboradores!=null && this.colaboradores.size()>0) {
			for(int i=0; i<colaboradores.size(); i++) {
				if(colaboradores.get(i).getCodigo()==codigo) {
					return true;
				}
			}
		}
		
		if(this.empregados!=null && this.empregados.size()>0) {
			for(int i=0; i<empregados.size(); i++) {
				if(empregados.get(i).codigo()==codigo) {
					return true;
				}
			}
		}
		
		if(this.employees!=null && this.employees.size()>0) {
			for(int i=0; i<employees.size(); i++) {
				if(employees.get(i).getEmpNum()==codigo) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void print() {
		/*
			* FAZ PRINT DE TODAS AS LISTAS
			* colaboradores - nova lista
			* empregados - lista dos empregados da Petiscos
			* employees - lista dos empregados da Sweet
		*/

		if(this.colaboradores!=null && this.colaboradores.size()>0) {
			for(Colaborador x : this.colaboradores) {
				System.out.println(x.getCodigo() + ": " + x.getNome() + " " + x.getApelido() + "; Ganha " + x.getSalario());
			}
		}
		
		if(this.employees!=null && this.employees.size()>0) {
			for(Employee x : this.employees) {
				System.out.println(x.getEmpNum() + ": " + x.getName() + "; Ganha " + x.getSalary());
			}
		}
		
		if(this.empregados!=null && this.empregados.size()>0) {
			for(Empregado x : this.empregados) {
				System.out.println(x.codigo() + ": " + x.nome() + " " + x.apelido() + "; Ganha " + x.salario());
			}
		}
	}
}
