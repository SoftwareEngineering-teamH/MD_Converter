package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class DocumentTest {

	@Test
	public void testAccept() {
		
	}

	@Test
	public void testCheckStringString() {
		Document test_Doc1 = new Document();
		Document test_Doc2 = new Document();
		test_Doc1.type_num=4;
		test_Doc2.check("* ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc2.check("- ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc2.check("+ ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.type_num=44;
		test_Doc2.check("1. ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.type_num=3;
		test_Doc2.check("> ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.type_num=2;
		test_Doc2.check("    ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.type_num=1;
		test_Doc2.check("# ", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.type_num=5;
		test_Doc2.check("--", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.type_num=6;
		test_Doc2.check("--abc", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		test_Doc1.isH=1;
		test_Doc2.check("abc", "==");
		assertEquals(test_Doc1.isH, test_Doc2.isH);
		
		test_Doc1.isH=3;
		test_Doc2.check("", "==");
		assertEquals(test_Doc1.isH, test_Doc2.isH);
		
		test_Doc1.isH=3;
		test_Doc2.check("", "--");
		assertEquals(test_Doc1.isH, test_Doc2.isH);
		
		test_Doc1.isH=2;
		test_Doc2.check(" ", "--");
		assertEquals(test_Doc1.isH, test_Doc2.isH);
		
		test_Doc1.type_num=6;
		test_Doc2.check("abc", "abc");
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		
		
	}

	@Test
	public void testCheckStringArray() {
		String[] buffer = new String[10];
		Document test_Doc1 = new Document();
		Document test_Doc2 = new Document();
		buffer[0]="* ";
		test_Doc1.check(buffer);
		test_Doc2.type_num = 4;
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		buffer[0]="+ ";
		test_Doc1.check(buffer);
		test_Doc2.type_num = 4;
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		buffer[0]="- ";
		test_Doc1.check(buffer);
		test_Doc2.type_num = 4;
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
		
		buffer[0]="1. ";
		test_Doc1.check(buffer);
		test_Doc2.type_num = 4;
		assertEquals(test_Doc1.type_num, test_Doc2.type_num);
	}

	@Test
	public void testSetNode() {
		Document test_Doc1 = new Document();
		Document test_Doc2 = new Document();
		test_Doc1.setNode(1, "abc");
	}

}
