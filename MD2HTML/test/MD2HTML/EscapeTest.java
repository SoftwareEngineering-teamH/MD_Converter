package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscapeTest {

	@Test
	public void testCreatebacks() {
		Escape test_Escape = new Escape();
		test_Escape.data="abc";
		test_Escape.token_type = 3;
		assertEquals(test_Escape.create("abc"),test_Escape);
	}

	@Test
	public void testCreatelt() {
		Escape test_Escape = new Escape();
		test_Escape.data="abc";
		test_Escape.token_type = 33;
		assertEquals(test_Escape.create("abc"),test_Escape);
	}

	@Test
	public void testCreateamp() {
		Escape test_Escape = new Escape();
		test_Escape.data="abc";
		test_Escape.token_type = 333;
		assertEquals(test_Escape.create("abc"),test_Escape);
	}

}
