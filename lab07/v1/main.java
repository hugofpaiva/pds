import java.util.Date;

public class main {

	public static void main(String[] args) {
		EmployeeInterface empregado = new Employee("Empregado A");
        empregado.start(new Date());
        empregado.work();
        empregado.terminate(new Date());

        TeamMember teamMember = new TeamMember(new Employee("André"));
        teamMember.start(new Date());
        teamMember.work();
        teamMember.terminate(new Date());

        TeamLeader teamLeader = new TeamLeader(new Employee("Morais"));
        teamLeader.start(new Date());
        teamLeader.work();
        teamLeader.terminate(new Date());

        Manager manager = new Manager(empregado);
        manager.start(new Date());
        manager.work();
        manager.terminate(new Date());

        Manager mn2 = new Manager(new TeamLeader(new TeamMember(new Employee("André Morais"))));
        mn2.start(new Date());
        mn2.work();
        mn2.terminate(new Date());
	}

}
