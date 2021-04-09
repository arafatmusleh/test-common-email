import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.apache.commons.mail.EmailException;

public class EmailConcreteTest {

	private static final String[] VALID_EMAIL_ARRAY = {
		"arafat@gmail.com", "muath@gmail.com"
	};
	private static final String[] EMPTY_EMAIL_ARRAY = {};
	private EmailConcrete email;
	private static final String VALID_EMAIL = "arafat@gmail.com";
	private static final String VALID_NON_EMPTY_STRING = "sfbdfb";
	private static final String EMPTY_STRING = "";
	@Before
	public void setUp() throws Exception {
		 email = new EmailConcrete();
	}
	
	@Rule
	  public final ExpectedException exception = ExpectedException.none();
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testAddBccValid() throws Exception {
		email.addBcc(VALID_EMAIL_ARRAY);
		assertEquals(2,email.getBccAddresses().size());
	}
	@Test
	public void testAddBccEmpty() throws Exception {
		exception.expect(EmailException.class);
		email.addBcc(EMPTY_EMAIL_ARRAY);
	}

	@Test
	public void testAddCcValid() throws Exception {
		email.addCc(VALID_EMAIL);
		assertEquals(1,email.getCcAddresses().size());
	}
	@Test
	public void testAddCcEmpty() throws Exception {
		exception.expect(Exception.class);
		email.addCc(EMPTY_STRING);
	}
}
