package LAB6.v2;

public class exe2 {

	public static void main(String[] args) {
		ContactsBook facebook = new ContactsBook();

        String filename = "./src/ficheiroDeTesto.txt";
        ContactsStorageInterface storage = new ContactsStorageText(filename);
        facebook.openAndLoad(storage);
        
        System.out.println(facebook.getByName("Mariana").getNumero()); // DEVE MOSTRAR 356425643

        facebook.add(new Contact("Power Ranger", 123456789));
        facebook.saveAndClose(storage);
        
        
        ContactsBook twitter = new ContactsBook();
        twitter.add(new Contact("Mafalda", 123456789));
        twitter.add(new Contact("Miguel", 525735743));
        twitter.add(new Contact("Joaquim", 192837465));
        twitter.add(new Contact("Barbara", 574910285));
        filename="./src/ficheiroDeBin";
        storage = new ContactsStorageBinary(filename);
        twitter.saveAndClose(storage);
        
        ContactsBook twitterClone = new ContactsBook();
        twitterClone.openAndLoad(storage);
        System.out.println(twitterClone.getByName("Barbara").getNumero()); // DEVE MOSTRAR 574910285
	}

}
