package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class EscapeTest {

	@Test
	public void testCreatebacks() {
		Escape test_Escape1 = new Escape();
		Escape test_Escape2 = new Escape();
		test_Escape1.data="abc";
		test_Escape1.token_type = 3;
		assertEquals(test_Escape1.data,test_Escape2.createbacks("abc").data);
		assertEquals(test_Escape1.token_type,test_Escape2.createbacks("abc").token_type);
	}

	@Test
	public void testCreatelt() {
		Escape test_Escape1 = new Escape();
		Escape test_Escape2 = new Escape();
		test_Escape1.data="abc";
		test_Escape1.token_type = 33;
		assertEquals(test_Escape1.data,test_Escape2.createlt("abc").data);
		assertEquals(test_Escape1.token_type,test_Escape2.createlt("abc").token_type);
	}

	@Test
	public void testCreateamp() {
		Escape test_Escape1 = new Escape();
		Escape test_Escape2 = new Escape();
		test_Escape1.data="abc";
		test_Escape1.token_type = 333;
		assertEquals(test_Escape1.data,test_Escape2.createamp("abc").data);
		assertEquals(test_Escape1.token_type,test_Escape2.createamp("abc").token_type);
	}

}
