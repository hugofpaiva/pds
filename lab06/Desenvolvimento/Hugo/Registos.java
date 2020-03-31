class Registos {
    // Data elements
private ArrayList<Empregado> empregados; // Stores the employees 
public Registos() {
    empregados=new ArrayList<>();
    }

    public void insere(Empregado emp) { 
       empregados.add(emp);
    }

    public void remove(int codigo) {
        for(Empregado x : empregados){
            if(x.codigo == codigo)
                empregados.remove(x);
        }
    }

    public boolean isEmpregado(int codigo) {
        for(Empregado x : empregados){
            if(x.codigo == codigo)
                return true;
        }
    }

    public List<Empregado> listaDeEmpregados() {
        return empregados
    }
}