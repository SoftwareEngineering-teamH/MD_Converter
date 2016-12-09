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
		
		doc1.md_data="1. ��\n��\n2. ��\n\n* aa\n---------\n\n1. ��\n* 123\n\n* 12";
		parser.parsing("1. ��\n��\n2. ��\n\n* aa\n---------\n\n1. ��\n* 123\n\n* 12",doc2);
		assertEquals(doc1.md_data,doc2.md_data);

		doc1.md_data="> \n����\n> \n> \n------\n>\n\n\n1. ��";
		parser.parsing("> \n����\n> \n> \n------\n>\n\n\n1. ��",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="> \n����\n> \n> \n------\n>\n\n\n1. ��";
		parser.parsing("> \n����\n> \n> \n------\n>\n\n\n1. ��",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="1. ��\n����\n2. ��";
		parser.parsing("1. ��\n����\n2. ��",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="> ��\n--------\n\n> ��\n��\n> ��";
		parser.parsing("> ��\n--------\n\n> ��\n��\n> ��",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="111\n======";
		parser.parsing("111\n======",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="111\n======\n11111";
		parser.parsing("111\n======\n11111",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="a. 1234\n1. jhgjhjh\nb. 2dge2";
		parser.parsing("a. 1234\n1. jhgjhjh\nb. 2dge2",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
		doc1.md_data="1. 1234\n\n.\nb. 2dge2";
		parser.parsing("1. 1234\n\n.\nb. 2dge2", doc2);
		assertEquals(doc1.md_data,doc2.md_data);

	}

	@Test
	public void testCheckItem() {
		Document doc1 = new Document(); 
		Document doc2 = new Document(); 
		MDParser parser = new MDParser();
		
		doc1.md_data="12. abc\n";
		parser.parsing("12. abc\n",doc2);
		assertEquals(doc1.md_data,doc2.md_data);
		
	
	}

}
