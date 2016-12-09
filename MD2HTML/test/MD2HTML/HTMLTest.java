package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class HTMLTest {

	@Test
	public void testCreate() {
		HTML test_HTML1 = new HTML();
		HTML test_HTML2 = new HTML();
		test_HTML1.data="abc";
		test_HTML1.token_type = 6;
		assertEquals(test_HTML1.data,test_HTML2.create("abc").data);
		assertEquals(test_HTML1.token_type,test_HTML2.create("abc").token_type);
	}

}
