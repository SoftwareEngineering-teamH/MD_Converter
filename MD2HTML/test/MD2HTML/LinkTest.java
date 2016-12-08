package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkTest {

	@Test
	public void testCreateFirst() {
		Link test_Link = new Link();
		test_Link.data="abc";
		test_Link.token_type = 4;
		assertEquals(test_Link.create("abc"),test_Link);
	}

	@Test
	public void testCreateSecond() {
		Link test_Link = new Link();
		test_Link.data="abc";
		test_Link.token_type = 44;
		assertEquals(test_Link.create("abc"),test_Link);
	}

	@Test
	public void testCreateThird() {
		Link test_Link = new Link();
		test_Link.data="abc";
		test_Link.token_type = 444;
		assertEquals(test_Link.create("abc"),test_Link);
	}

	@Test
	public void testCreateLast() {
		Link test_Link = new Link();
		test_Link.data="abc";
		test_Link.token_type = 4444;
		assertEquals(test_Link.create("abc"),test_Link);
	}

}
