package in.ashokit.serviceslmpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entityclasses.PhoneBookEntity;
import in.ashokit.repostories.PhoneBookRepository;
import in.ashokit.service.PhoneBookServices;

@Service
public class PhoneBookServiceImpl implements PhoneBookServices {

	@Autowired
	private PhoneBookRepository bookRepo;

	@Override
	public String upsertContact(PhoneBookEntity Entity) {

		 bookRepo.save(Entity); // insert or update based on pk

		return "Succes";
	}

	@Override
	public PhoneBookEntity getContactById(Integer contactId) {

		Optional<PhoneBookEntity> findById = bookRepo.findById(contactId);

		if (findById.isPresent()) {

			PhoneBookEntity phoneBookId = findById.get();
			return phoneBookId;
		}

		return null;
	}

	@Override
	public List<PhoneBookEntity> getAllContacts() {

		List<PhoneBookEntity> findAll = bookRepo.findAll();
		return findAll;
	}

	@Override
	public String deleteById(Integer contactId) {

		if (bookRepo.existsById(contactId)) {

			bookRepo.deleteById(contactId);
			return " Delete Success";

		} else {
			return "No Record Found";
		}
	}

}
