package LAB6.v2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactsStorageBinary implements ContactsStorageInterface{
	private String filename;
	public ContactsStorageBinary(String filename) {
		this.filename=filename;
	}

	@Override
	public List<Contact> loadContacts() {
		try{
            List<Contact> contacts = new ArrayList<>();
            //Go through all contents of file
            File binaryFile = new File(this.filename);
            FileReader fileReader = new FileReader(binaryFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {

                String currentLine[] = line.split(",");
                for(int i = 0 ; i < currentLine.length ; i++){
                    //Add current contact
                    Contact contact = new Contact(currentLine[i],Integer.parseInt(currentLine[++i]));
                    contacts.add(contact); //Add the new contact
                }        
            }

            bufferedReader.close();
            fileReader.close();

            return contacts;
        }catch(Exception e){
            System.out.println("ERROR! "+e.toString());
        }
		
		return null;
	}

	@Override
	public boolean saveContacts(List<Contact> list) {
		try{
			File binaryFile = new File(this.filename);
            FileWriter fileWriter = new FileWriter(binaryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            //Write contacts from list
            int counter = 0;
            for(Contact currentContact : list){
            	counter++;
               bufferedWriter.write(currentContact.getNome()+","+currentContact.getNumero());
               if(counter<list.size()) {
            	   bufferedWriter.newLine();
               }
            }

            bufferedWriter.close();
            fileWriter.close();

            return true;
        }catch(Exception e){
            return false;
        }
	}

}
