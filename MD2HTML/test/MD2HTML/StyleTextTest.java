package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class StyleTextTest {

	@Test
	public void testCreate() {
		StyleText test_StyleText1 = new StyleText();
		StyleText test_StyleText2 = new StyleText();
		test_StyleText1.data="abc";
		test_StyleText1.token_type = 2;
		assertEquals(test_StyleText1.data,test_StyleText1.create("abc").data);
		assertEquals(test_StyleText1.token_type,test_StyleText1.create("abc").token_type);
	}

	@Test
	public void testCreateEnd() {
		StyleText test_StyleText1 = new StyleText();
		StyleText test_StyleText2 = new StyleText();
		test_StyleText1.data="abc";
		test_StyleText1.token_type = 22;
		assertEquals(test_StyleText1.data,test_StyleText1.createEnd("abc").data);
		assertEquals(test_StyleText1.token_type,test_StyleText1.createEnd("abc").token_type);
	}

}
