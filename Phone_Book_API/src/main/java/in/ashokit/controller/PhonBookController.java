package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entityclasses.PhoneBookEntity;
import in.ashokit.service.PhoneBookServices;

@RestController
public class PhonBookController {

	@Autowired
	private PhoneBookServices bookServices;
	
	@PostMapping(value="/insert",consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity<String> insertContact(@RequestBody PhoneBookEntity bookEntity){
    
    	String status = bookServices.upsertContact(bookEntity);
		return new ResponseEntity<> (status,HttpStatus.CREATED);
    	
    }
	
	
//	public ResponseEntity<Boolean>insertContact(@RequestBody PhoneBookEntity bookEntity){
//		
//		boolean status = bookServices.upsertContact(bookEntity);
//    	return new ResponseEntity<> (status,HttpStatus.CREATED);
//		
//		
//		
//	}
	
	
	
	
	@GetMapping("/insert/{contactId}")
	public ResponseEntity<PhoneBookEntity> getContact(@PathVariable Integer contactId){
		
		PhoneBookEntity status = bookServices.getContactById(contactId);
		
		return new ResponseEntity<PhoneBookEntity>(status,HttpStatus.OK);
		
	}
	
	@GetMapping("/fetch")
		public ResponseEntity<List<PhoneBookEntity>> getAll(){
		
		List<PhoneBookEntity> allContacts = bookServices.getAllContacts();
		
		return new ResponseEntity<>(allContacts,HttpStatus.OK);
		
	}
	
//	@PutMapping("/insert")
//    public ResponseEntity<boolean> upsertContact(@RequestBody PhoneBookEntity bookEntity){
//    
//    	boolean status = bookServices.upsertContact(bookEntity);
//		return new ResponseEntity<> (status,HttpStatus.OK);
//    	
//    }
	
	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<String> getDeleteById(@PathVariable Integer contactId){
		
		String status = bookServices.deleteById(contactId);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
}
