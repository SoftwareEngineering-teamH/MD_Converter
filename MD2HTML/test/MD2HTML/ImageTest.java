package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageTest {

	@Test
	public void testCreateFirst() {
		Image test_Image = new Image();
		test_Image.data="abc";
		test_Image.token_type = 5;
		assertEquals(test_Image.create("abc"),test_Image);
	}

	@Test
	public void testCreateSecond() {
		Image test_Image = new Image();
		test_Image.data="abc";
		test_Image.token_type = 55;
		assertEquals(test_Image.create("abc"),test_Image);
	}

	@Test
	public void testCreateThird() {
		Image test_Image = new Image();
		test_Image.data="abc";
		test_Image.token_type = 555;
		assertEquals(test_Image.create("abc"),test_Image);
	}

	@Test
	public void testCreateLast() {
		Image test_Image = new Image();
		test_Image.data="abc";
		test_Image.token_type = 5555;
		assertEquals(test_Image.create("abc"),test_Image);
	}

}
