public class Facade {
	private Company comp = new Company();
	private Parking park = new Parking("Parque da Teresa", comp);
	private Insurance insurance = new Insurance("Allianz");
	private SocialSecurity ss = new SocialSecurity();
	
	public void admitEmployee(Person p, double salary) {
		Employee e = new Employee(p, salary);
		comp.admitEmployee(e);
		comp.createCard(e);
		park.allow(e);
		insurance.regist(e);
		ss.regist(e);
		
	}
	

	public Parking getPark() {
		return park;
	}

	public void setPark(Parking park) {
		this.park = park;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public SocialSecurity getSs() {
		return ss;
	}

	public void setSs(SocialSecurity ss) {
		this.ss = ss;
	}

	public Company getComp() {
		return comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

}
