package lab06.v2;

public class ex2 {

	public static void main(String[] args) {
		/*
			* TEXT
		*/

		// CRIAR OBJETO RESPONSÁVEL POR GUARDAR EM TXT
		ContactsStorageInterface file_txt = new StorageTXT("database.txt");

		// CRIAR OBJETO RESPONSÁVEL POR ACEDER À BASE DE DADOS EM TXT
		ContactsInterface db_txt = new Database();

		db_txt.openAndLoad(file_txt);

		Contact elsa = new Contact("Elsa", 965411453);
		db_txt.add(elsa);

		System.out.println("A elsa existe?");
		System.out.println(db_txt.exist(elsa));

		db_txt.saveAndClose();

		db_txt.openAndLoad(file_txt);

		elsa = db_txt.getByName("Elsa");

		System.out.println(elsa);

		db_txt.remove(elsa);

		System.out.println("A elsa existe?");
		System.out.println(db_txt.exist(elsa));

		db_txt.saveAndClose();

		/*
			* BINARY
		*/

		// CRIAR OBJETO RESPONSÁVEL POR GUARDAR EM TXT
		ContactsStorageInterface file_binary = new StorageBinary("databasebin");

		// CRIAR OBJETO RESPONSÁVEL POR ACEDER À BASE DE DADOS EM TXT
		ContactsInterface db_binary = new Database();

		db_binary.openAndLoad(file_binary);

		Contact hugo = new Contact("Hugo", 964533453, "hugofpaiva@ua.pt");
		db_binary.add(hugo);

		System.out.println("o Hugo existe?");
		System.out.println(db_binary.exist(hugo));

		db_binary.saveAndClose();

		db_binary.openAndLoad(file_binary);

		hugo = db_binary.getByName("Hugo");

		System.out.println(hugo);

		db_binary.remove(hugo);

		System.out.println("o Hugo existe?");
		System.out.println(db_binary.exist(hugo));

		db_binary.saveAndClose();

	}

}
