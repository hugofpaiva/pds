package LAB8.v2;

import java.util.ArrayList;
import java.util.List;

public class CompanyFacade {
	Insurance seguro = new Insurance();
	Company companhia = new Company();
	Parking parques = new Parking(companhia);
	SocialSecurity social= new SocialSecurity();

	public Insurance Seguro() {
		return seguro;
	}

	public Parking Parques() {
		return parques;
	}

	public SocialSecurity Social() {
		return social;
	}
	
	public Company Companhia() {
		return companhia;
	}

	public void setSeguro(Insurance seguro) {
		this.seguro = seguro;
	}

	public void setParques(Parking parques) {
		this.parques = parques;
	}

	public void setSocial(SocialSecurity social) {
		this.social = social;
	}

	public void admitEmployee(Person p, double salary) {
		Employee e = new Employee(p, salary);
		companhia.admitEmployee(e);
		companhia.addCard(e);
		seguro.regist(e);
		social.regist(e);
		parques.allow(e);
	}
}
