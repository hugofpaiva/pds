package LAB7.v1;

import java.util.Date;

public class TeamLeader extends EmployeeDecorator{

	public TeamLeader(EmployeeInterface emp) {
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
		plan();
	}

	public void plan() {
		System.out.println("O trabalho do Team Leader é planear");
	}
}
