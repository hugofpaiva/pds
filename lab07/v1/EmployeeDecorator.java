package LAB7.v1;

import java.util.Date;

public abstract class EmployeeDecorator implements EmployeeInterface{
	EmployeeInterface e;
	
	public EmployeeDecorator(EmployeeInterface emp) {
        this.e = emp;
    }

    public void start(Date date) {
        this.e.start(date);
    }

    public void terminate(Date date) {
        this.e.terminate(date);
    }

    public void work() {
        this.e.work();
    }
}
