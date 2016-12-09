package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeaderTest {

	@Test
	public void testCreateStringInt() {
		Header test_Header_1 = new Header();
		Header test_Header_2 = new Header();
		
		test_Header_1.md_data="abc";
		test_Header_1.node_type = 111;
		assertEquals(test_Header_1.md_data,test_Header_2.create("# abc",111).md_data);
		assertEquals(test_Header_1.node_type,test_Header_2.create("# abc",111).node_type);
		
		test_Header_1.md_data="abc";
		test_Header_1.node_type = 1111;
		assertEquals(test_Header_1.md_data,test_Header_2.create("## abc",111).md_data);
		assertEquals(test_Header_1.node_type,test_Header_2.create("## abc",111).node_type);
		
		test_Header_1.md_data="abc";
		test_Header_1.node_type = 11111;
		assertEquals(test_Header_1.md_data,test_Header_2.create("### abc",111).md_data);
		assertEquals(test_Header_1.node_type,test_Header_2.create("### abc",111).node_type);
		
		test_Header_1.md_data="abc";
		test_Header_1.node_type = 111111;
		assertEquals(test_Header_1.md_data,test_Header_2.create("#### abc",111).md_data);
		assertEquals(test_Header_1.node_type,test_Header_2.create("#### abc",111).node_type);
		
		test_Header_1.md_data="abc";
		test_Header_1.node_type = 1111111;
		assertEquals(test_Header_1.md_data,test_Header_2.create("##### abc",111).md_data);
		assertEquals(test_Header_1.node_type,test_Header_2.create("##### abc",111).node_type);
		
		test_Header_1.md_data="abc";
		test_Header_1.node_type = 11111111;
		assertEquals(test_Header_1.md_data,test_Header_2.create("###### abc",111).md_data);
		assertEquals(test_Header_1.node_type,test_Header_2.create("###### abc",111).node_type);
	}

}
