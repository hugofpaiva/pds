package lab06.v2;

import java.util.List;

public interface ContactsStorageInterface {
	public List<Contact> loadContacts();
	public boolean saveContacts(List<Contact> list);
}
