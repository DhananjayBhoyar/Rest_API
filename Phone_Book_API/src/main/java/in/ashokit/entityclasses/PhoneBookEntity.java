package in.ashokit.entityclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="PHONE_BOOK")
public class PhoneBookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer contactId;
	
	private String contactFirstName;
	
	private String contactLastName;
	
	private Long contactNumber;
	
	private String contactEmail;
	
}
