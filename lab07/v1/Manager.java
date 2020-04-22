import java.util.Date;

public class Manager extends EmployeeDecorator{

	public Manager(EmployeeInterface emp) {
		super(emp);
	}

	@Override
	public void start(Date d) {
		super.start(d);
	}

	@Override
	public void terminate(Date d) {
		super.terminate(d);
	}

	@Override
	public void work() {
		super.work();
		manage();
	}
	
	public void manage() {
		System.out.println("O trabalho do Manager é gerir");
	}
}
