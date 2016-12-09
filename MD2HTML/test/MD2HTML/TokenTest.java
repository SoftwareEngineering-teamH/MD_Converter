package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class TokenTest {

	@Test
	public void testAccept() {
		
	}

	@Test
	public void testCreate() {
		Token test_Token1 = new Token();
		Token test_Token2 = new Token();
		test_Token1.data="abc";
		assertEquals(test_Token1.data,test_Token2.create("abc").data);
	}

}
