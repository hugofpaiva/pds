public abstract class Employee {
	protected String name;

	public abstract String getName();

}

// Singleton class
class NullEmp extends Employee {
	static private NullEmp instance = new NullEmp();


	static public NullEmp getInstance() {
		return instance;
	}

	@Override
	public String getName() {
		return "Nonexistent employee!";
	}

}
