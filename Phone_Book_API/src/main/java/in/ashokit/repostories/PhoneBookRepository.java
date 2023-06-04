package in.ashokit.repostories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entityclasses.PhoneBookEntity;

public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Integer> {

	
}
