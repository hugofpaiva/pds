package lab06.v2;

import java.util.ArrayList;
import java.util.List;

public class Database implements ContactsInterface {
	private ContactsStorageInterface db = null;
	List<Contact> contactos = new ArrayList<Contact>();

	public void openAndLoad(ContactsStorageInterface store) {
		contactos = store.loadContacts();
		db = store;
	}

	// NO CASO DE EXISTIR CONTEUDO NA LISTA DE CONTACTOS, GUARDA A LISTA NA STORAGE DEFAULT
	public void saveAndClose() {
		if (db == null) {
			System.err.println("No database!");
			System.exit(0);
		} else {
			db.saveContacts(contactos);
			contactos.clear();
		}

	}

	// NO CASO DE EXISTIR CONTEUDO NA LISTA DE CONTACTOS, GUARDA A LISTA NA STORAGE ESCOLHIDA POR PARÂMETRO
	public void saveAndClose(ContactsStorageInterface store) {
		for (Contact x : contactos) {
			System.out.println(x);
		}

		store.saveContacts(contactos);
		contactos.clear();

	}

	public boolean exist(Contact contact) {
		for (Contact x : contactos) {
			if (x.equals(contact))
				return true;
		}
		return false;
	}

	public Contact getByName(String name) {
		for (Contact x : contactos) {
			if (x.getName().equals(name))
				return x;
		}
		return null;

	}

	public boolean add(Contact contact) {
		if (contactos.add(contact))
			return true;
		return false;

	}

	public boolean remove(Contact contact) {
		if (contactos.remove(contact)) {
			return true;
		}

		return false;

	}

}
