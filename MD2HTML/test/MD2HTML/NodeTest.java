package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	@Test
	public void testAccept() {
		
	}

	@Test
	public void testCreateString() 
	{
		Node test_node1 = new Node();
		Node test_node2 = new Node();
		test_node1.md_data = "abc";
		assertEquals(test_node1.md_data,test_node2.create("abc").md_data);
	}
	
	@Test
	public void setStartTagTest()
	{
		Node test_node1 = new Node();
		Node test_node2 = new Node();
		test_node1.node_type = 1;
		assertEquals("<h1>", 1);
	}


}
