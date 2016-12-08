package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class ItemListTest {

	@Test
	public void testCreateStringInt() {
		ItemList test_ItemList_1 = new ItemList();
		test_ItemList_1.md_data="abc";
		test_ItemList_1.node_type = 1;
		assertEquals(test_ItemList_1.create("abc",1),test_ItemList_1);
		
		ItemList test_ItemList_2 = new ItemList();
		test_ItemList_2.md_data="abc";
		test_ItemList_2.node_type = 2;
		assertEquals(test_ItemList_2.create("abc",2),test_ItemList_2);
		
		ItemList test_ItemList_3 = new ItemList();
		test_ItemList_3.md_data="abc";
		test_ItemList_3.node_type = 3;
		assertEquals(test_ItemList_3.create("abc",1),test_ItemList_3);
		
		ItemList test_ItemList_4 = new ItemList();
		test_ItemList_4.md_data="abc";
		test_ItemList_4.node_type = 4;
		assertEquals(test_ItemList_4.create("abc",1),test_ItemList_4);
		
		ItemList test_ItemList_5 = new ItemList();
		test_ItemList_5.md_data="abc";
		test_ItemList_5.node_type = 5;
		assertEquals(test_ItemList_5.create("abc",1),test_ItemList_5);
		
		ItemList test_ItemList_6 = new ItemList();
		test_ItemList_6.md_data="abc";
		test_ItemList_6.node_type = 1;
		assertEquals(test_ItemList_6.create("abc",1),test_ItemList_6);
	}

}
