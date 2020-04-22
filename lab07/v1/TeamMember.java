package LAB7.v1;

import java.util.Date;

public class TeamMember extends EmployeeDecorator{

	public TeamMember(EmployeeInterface emp) {
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
		colaborate();
	}
	
	public void colaborate() {
		System.out.println("O trabalho do Team Member é colaborar");
	}

}
