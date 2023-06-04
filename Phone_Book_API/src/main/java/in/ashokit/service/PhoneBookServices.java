package in.ashokit.service;


import java.util.List;

import in.ashokit.entityclasses.PhoneBookEntity;

public interface PhoneBookServices {
	
	public String upsertContact(PhoneBookEntity Entity);
	
	public PhoneBookEntity getContactById(Integer contactId);
	
	public List<PhoneBookEntity>getAllContacts();
	
	public String deleteById(Integer contactId);
	
	
	
	

}
