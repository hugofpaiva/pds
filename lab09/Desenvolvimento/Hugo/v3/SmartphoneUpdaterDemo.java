package lab09.v3;

import java.util.ArrayList;

public class SmartphoneUpdaterDemo {

	public static void main(String[] args) {
		ArrayList<Smartphone> smartphoneList = new ArrayList<Smartphone>();

		smartphoneList.add(new Smartphone(Versions.Marshmallow, "Hugo"));
		smartphoneList.add(new Smartphone(Versions.Oreo, "André"));
		smartphoneList.add(new Smartphone(Versions.Beta, "Old Guy"));
		smartphoneList.add(new Smartphone(Versions.Eleven, "Geek Guy"));
		smartphoneList.add(new Smartphone(Versions.Eclair, "Geek Guy"));

		Updater androidUpdater = new MarshmallowUpdater()
				.setSuccessor(new OreoUpdater().setSuccessor(new NougatUpdater().setSuccessor(
						new PieUpdater().setSuccessor(new TenUpdater().setSuccessor(new ElevenUpdater())))));

		for (Smartphone phone : smartphoneList) {
			androidUpdater.update(phone);
		}
	}
}
