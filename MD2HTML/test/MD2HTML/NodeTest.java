package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testAccept() {
		
	}

	@Test
	public void testCreateString() {
		Node test_node1 = new Node();
		Node test_node2 = new Node();
		test_node1.md_data = "abc";
		assertEquals(test_node1,test_node2.create("abc"));
	}

	@Test
	public void testSetToken() {
		Node test_node1 = new Node();
		Node test_node2 = new Node();

	}

	@Test
	public void testSetStartTag() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEndTag() {
		fail("Not yet implemented");
	}

}