package LAB9.v1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
	private String name;
	private int salario;
	private Date data;
	public Person(String n, int salario, Date d) { 
		name = n;
		this.salario=salario;
		this.data=d;
	}
	public String getName() { 
		return name;
	}
	
	@Override
    public String toString() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        return "Pessoa [name=" + name + ", salario=" + salario + ", data=" + formatter.format(data) + "]";
    }
}
