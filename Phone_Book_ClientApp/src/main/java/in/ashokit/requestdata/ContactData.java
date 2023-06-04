package in.ashokit.requestdata;

import lombok.Data;

@Data
public class ContactData {
	
	private String contactFirstName;
	
	private String contactLastName;
	
	private Long contactNumber;
	
	private String contactEmail;
}
