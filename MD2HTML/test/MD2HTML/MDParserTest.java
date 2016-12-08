package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class MDParserTest {

	@Test
	public void testParsing() {
		Document doc1 = new Document(); 
		Document doc2 = new Document(); 
		MDParser parser = new MDParser();
		
		doc1.md_data="1";
		parser.parsing("1",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="* 123\n456\n* 78";
		parser.parsing("* 123\n456\n* 78",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="1. 가\n나\n2. 다\n\n* aa\n---------\n\n1. 라\n* 123\n\n* 12";
		parser.parsing("1. 가\n나\n2. 다\n\n* aa\n---------\n\n1. 라\n* 123\n\n* 12",doc2);
		assertEquals(doc1.md_data,doc2.md_data);

		doc1.md_data="> \n가나\n> \n> \n------\n>\n\n\n1. 가";
		parser.parsing("> \n가나\n> \n> \n------\n>\n\n\n1. 가",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="> \n가나\n> \n> \n------\n>\n\n\n1. 가";
		parser.parsing("> \n가나\n> \n> \n------\n>\n\n\n1. 가",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="1. 가\n나다\n2. 라";
		parser.parsing("1. 가\n나다\n2. 라",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="> 영\n--------\n\n> 일\n이\n> 삼";
		parser.parsing("> 영\n--------\n\n> 일\n이\n> 삼",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="111\n======";
		parser.parsing("111\n======",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="111\n======\n11111";
		parser.parsing("111\n======\n11111",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
	}

	@Test
	public void testCheckItem() {
		Document doc1 = new Document(); 
		Document doc2 = new Document(); 
		MDParser parser = new MDParser();
		
		doc1.md_data="12가. 나다\n.나";
		parser.parsing("12가. 나다\n.나",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
	}

}
