package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextBlockTest {

	@Test
	public void testCreateString() {
		TextBlock test_TextBlock1 = new TextBlock();
		TextBlock test_TextBlock2 = new TextBlock();
		test_TextBlock1.md_data="abc";
		test_TextBlock1.node_type = 6;
		assertEquals(test_TextBlock1.md_data,test_TextBlock2.create("abc").md_data);
		assertEquals(test_TextBlock1.node_type,test_TextBlock2.create("abc").node_type);
	}

}
