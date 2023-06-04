package in.ashokit.requestservices;

import java.util.List;

import in.ashokit.requestdata.ContactData;



public interface ContactService {

	public ContactData upsertContact(ContactData contactData );

	public ContactData getContactById(Integer contactId);

	public List<ContactData> getAllContacts();

	public String deleteById(Integer contactId);
}
