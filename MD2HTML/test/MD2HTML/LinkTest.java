package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkTest {

	@Test
	public void testCreateFirst() {
		Link test_Link1 = new Link();
		Link test_Link2 = new Link();
		test_Link1.data="abc";
		test_Link1.token_type = 4;
		assertEquals(test_Link1.data,test_Link2.createFirst("abc").data);
		assertEquals(test_Link1.token_type,test_Link2.createFirst("abc").token_type);
	}

	@Test
	public void testCreateSecond() {
		Link test_Link1 = new Link();
		Link test_Link2 = new Link();
		test_Link1.data="abc";
		test_Link1.token_type = 44;
		assertEquals(test_Link1.data,test_Link2.createSecond("abc").data);
		assertEquals(test_Link1.token_type,test_Link2.createSecond("abc").token_type);
	}

	@Test
	public void testCreateThird() {
		Link test_Link1 = new Link();
		Link test_Link2 = new Link();
		test_Link1.data="abc";
		test_Link1.token_type = 444;
		assertEquals(test_Link1.data,test_Link2.createThird("abc").data);
		assertEquals(test_Link1.token_type,test_Link2.createThird("abc").token_type);
	}

	@Test
	public void testCreateLast() {
		Link test_Link1 = new Link();
		Link test_Link2 = new Link();
		test_Link1.data="abc";
		test_Link1.token_type = 4444;
		assertEquals(test_Link1.data,test_Link2.createLast("abc").data);
		assertEquals(test_Link1.token_type,test_Link2.createLast("abc").token_type);
	}

}
