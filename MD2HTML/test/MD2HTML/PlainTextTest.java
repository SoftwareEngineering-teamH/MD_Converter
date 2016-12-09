package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlainTextTest {

	@Test
	public void testCreate() {
		PlainText test_PlainText1 = new PlainText();
		PlainText test_PlainText2 = new PlainText();
		test_PlainText1.data="abc";
		test_PlainText1.token_type = 1;
		assertEquals(test_PlainText1.data,test_PlainText2.create("abc").data);
		assertEquals(test_PlainText1.token_type,test_PlainText2.create("abc").token_type);
	}

}
