package fakerlibrary;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	private static final Logger log = Logger.getLogger(FakerDataGenerator.class.getName());
	@Test
	void testGenerateData() {
		
		Faker faker=new Faker();
		
		String fullname=faker.name().fullName();
		String firstname=faker.name().firstName();
		String lastname=faker.name().lastName();
		
		String username=faker.name().username();
		String password=faker.internet().password();
		
		String phoneno=faker.phoneNumber().cellPhone();
		
		String email=faker.internet().safeEmailAddress();
		
		
		log.info("Full Name:" + fullname);
		log.info("First Name:"+ firstname);
		log.info("Last Name:" + lastname);
		log.info("User Name:" + username);
		log.info("Password:" + password);
		log.info("Phone:" + phoneno);
		log.info("Email:" + email);
		
	}

}
