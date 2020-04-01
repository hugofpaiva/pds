package LAB6.v2;

import java.util.ArrayList;

public class ContactsBook implements ContactsInterface {
	private ArrayList<Contact> book = new ArrayList<>();
	
	public ContactsBook(ArrayList<Contact> oldbook) {
		this.book=new ArrayList<>();
		for(Contact x : oldbook) {
			if(!add(x)){
				System.err.println("O contacto já foi adicionado");
			}
		}
	}
	
	public ContactsBook() {
		this.book=new ArrayList<>();
	}

	@Override
	public void openAndLoad(ContactsStorageInterface store) {
		for(Contact x : store.loadContacts()) {
			if(!add(x)){
				System.err.println("O contacto já foi adicionado");
			}
		}
	}

	@Override
	public void saveAndClose() {
		ContactsStorageInterface store = new ContactsStorageText("ficheiroTexto.txt");
		store.saveContacts(book);
	}

	@Override
	public void saveAndClose(ContactsStorageInterface store) {
		store.saveContacts(book);
	}

	@Override
	public boolean exist(Contact contact) {
		for(Contact x : book) {
			if(x.getNumero() == contact.getNumero()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Contact getByName(String name) {
		for(Contact x : book) {
			if(x.getNome().equals(name)) {
				return x;
			}
		}
		return null;
	}

	@Override
	public boolean add(Contact contact) {
		if(!exist(contact)) {
			book.add(contact);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Contact contact) {
		for(Contact x : book) {
			System.out.println(x.getNome());
			if(x.getNumero() == contact.getNumero()) {
				book.remove(x);
				return true;
			}
		}
		return false;
	}
}
