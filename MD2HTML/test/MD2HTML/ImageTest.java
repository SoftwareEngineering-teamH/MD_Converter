package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageTest {

	@Test
	public void testCreateFirst() {
		Image test_Image1 = new Image();
		Image test_Image2 = new Image();
		test_Image1.data="abc";
		test_Image1.token_type = 5;
		assertEquals(test_Image1.data,test_Image2.createFirst("abc").data);
		assertEquals(test_Image1.token_type,test_Image2.createFirst("abc").token_type);
	}

	@Test
	public void testCreateSecond() {
		Image test_Image1 = new Image();
		Image test_Image2 = new Image();
		test_Image1.data="abc";
		test_Image1.token_type = 55;
		assertEquals(test_Image1.data,test_Image2.createSecond("abc").data);
		assertEquals(test_Image1.token_type,test_Image2.createSecond("abc").token_type);
	}

	@Test
	public void testCreateThird() {
		Image test_Image1 = new Image();
		Image test_Image2 = new Image();
		test_Image1.data="abc";
		test_Image1.token_type = 555;
		assertEquals(test_Image1.data,test_Image2.createThird("abc").data);
		assertEquals(test_Image1.token_type,test_Image2.createThird("abc").token_type);
	}

	@Test
	public void testCreateLast() {
		Image test_Image1 = new Image();
		Image test_Image2 = new Image();
		test_Image1.data="abc";
		test_Image1.token_type = 5555;
		assertEquals(test_Image1.data,test_Image2.createLast("abc").data);
		assertEquals(test_Image1.token_type,test_Image2.createLast("abc").token_type);	}

}
