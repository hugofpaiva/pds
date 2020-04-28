package lab08.v3;

public class Card {
	private Employee emp;
	
	public Card (Employee emp) {
		this.emp = emp;
		System.out.println("Card of the employee " + emp.getName() + " created.");
	}
	
	public String getName() {
		return emp.getName();
	}

}
