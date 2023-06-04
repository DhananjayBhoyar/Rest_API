package in.ashokit.requestservicesImpl;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.requestdata.ContactData;
import in.ashokit.requestservices.ContactService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ContactserviceImpl implements ContactService{

	private static final String URL = "http://localhost:3030/insert";

	@Override
	public ContactData upsertContact(ContactData contactData) {
		
	
		WebClient client=WebClient.create();
		ContactData Obj = client.post()
		      .uri(URL)
		      .bodyValue(contactData)
		      .retrieve()
		  
		      .bodyToMono(ContactData.class)
		      .block();
		
		return Obj;
		
//		WebClient client = WebClient.create();
//		Mono<ContactData> mono= client
//				.post()
//				.uri(URL)
//				.retrieve()
//				.bodyToMono(ContactData.class);
//		mono.subscribe(System.out::println);
		
//		WebClient webClient=WebClient.create("http://localhost:3030");
		
//		ContactData Obj = webClient.post()
//				.uri("/insert")
//				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
//				.body(Mono.just(contactData), ContactData.class)
//				.retrieve()
//				.bodyToMono(ContactData.class);
		
//		WebClient webClient=WebClient.create();

//		ContactData Obj = webClient
//		  .bindToServer()
//		    .baseUrl("http://localhost:8080")
//		    .build()
//		    .post()
//		    .uri("/resource")
//		  .exchange()
//		    .expectStatus().isCreated()
//		    .expectHeader().valueEquals("Content-Type", "application/json")
//		    .expectBody().jsonPath("field").isEqualTo("value");

				
		
	
		
	}

	@Override
	public ContactData getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactData> getAllContacts() {
		
		WebClient webClient = WebClient.create("http://localhost:3030");

        // Send an HTTP GET request to the endpoint and retrieve the data as a Flux
        Flux<String> responseData = webClient
                .get()
                .uri("/your-endpoint")
                
                .retrieve()
                .bodyToFlux(String.class);
        
        responseData.doOnNext(System.out::println).blockLast();
		return null;
        
		
	
	}

	@Override
	public String deleteById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
