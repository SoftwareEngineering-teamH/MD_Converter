package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuotedBlockTest {

	@Test
	public void testCreateString() {
		QuotedBlock test_QuotedBlock1 = new QuotedBlock();
		QuotedBlock test_QuotedBlock2 = new QuotedBlock();
		test_QuotedBlock1.md_data="abc";
		test_QuotedBlock1.node_type = 3;
		assertEquals(test_QuotedBlock1.md_data,test_QuotedBlock2.create("> abc").md_data);
		assertEquals(test_QuotedBlock1.node_type,test_QuotedBlock2.create("> abc").node_type);
	}

}
