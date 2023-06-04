package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.ashokit.requestdata.ContactData;
import in.ashokit.requestservices.ContactService;

@Controller
public class ContactsController {

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String loadPage(Model model) {

		model.addAttribute("contactData", new ContactData());
		return "PhoneBookUI";
	}

	@PostMapping(value = "/insert")
	public String saveData( @ModelAttribute("contactData") ContactData contactData, Model model) {

		 contactService.upsertContact(contactData);

//		if (upsertContact != null) {
//
//			model.addAttribute("msg", "data saved " + upsertContact.getContactFirstName() );
//		}
 
		return "PhoneBookUI";
	}

	
}
