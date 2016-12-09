package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderTest {

	@Test
	public void testCreateStringInt() {
		Header test_Header_1 = new Header();
		Header test_Header_11 = new Header();
		test_Header_1.create("#abc", 111);
		assertEquals(test_Header_11.create("# abc",111),test_Header_1);

		
		
		Header test_Header_2 = new Header();
		Header test_Header_22 = new Header();
		test_Header_2.md_data="abc";
		test_Header_2.node_type = 1111;
		assertEquals(test_Header_2.create("## abc").md_data,test_Header_2.md_data);
		
		Header test_Header_3 = new Header();
		test_Header_3.md_data="### ";
		test_Header_3.node_type = 11111;
		assertEquals(test_Header_3.create("abc"),test_Header_3);
		
		Header test_Header_4 = new Header();
		test_Header_4.md_data="#### ";
		test_Header_4.node_type = 111111;
		assertEquals(test_Header_4.create("abc"),test_Header_4);
		
		Header test_Header_5 = new Header();
		test_Header_5.md_data="##### ";
		test_Header_5.node_type = 1111111;
		assertEquals(test_Header_5.create("abc"),test_Header_5);
		
		Header test_Header_6 = new Header();
		test_Header_6.md_data="###### ";
		test_Header_6.node_type = 11111111;
		assertEquals(test_Header_6.create("abc"),test_Header_6);
	}

}
