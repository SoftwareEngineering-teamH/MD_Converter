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
      
      doc1.md_data="* 123\n456\n* 78 **ab ** *a *";
      parser.parsing("* 123\n456\n* 78 **ab ** *a *",doc2);
      assertEquals(doc1.md_data,doc2.md_data);
      
      doc1.md_data="1. a\na\n2. c\n\n* aa\n---------\n\n1. e\n* 123\n\n* 12";
      parser.parsing("1. a\na\n2. c\n\n* aa\n---------\n\n1. e\n* 123\n\n* 12",doc2);
      assertEquals(doc1.md_data,doc2.md_data);

      doc1.md_data="> \n12\n> \n> \n------\n>\n\n\n1. a";
      parser.parsing("> \n12\n> \n> \n------\n>\n\n\n1. a",doc2);
      assertEquals(doc1.md_data,doc2.md_data);
      
      doc1.md_data="> \nab\n> \n> \n------\n>\n\n\n1. a";
      parser.parsing("> \nab\n> \n> \n------\n>\n\n\n1. a",doc2);
      assertEquals(doc1.md_data,doc2.md_data);
      
      doc1.md_data="1. a\nbc\n2. d";
      parser.parsing("1. a\nbc\n2. d",doc2);
      assertEquals(doc1.md_data,doc2.md_data);
      
      doc1.md_data="> a\n--------\n\n> b\nc\n> d";
      parser.parsing("> a\n--------\n\n> b\nc\n> d",doc2);
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
       
       doc1.md_data="    1. 1234\n\n.\nb. 2dge2";
       parser.parsing("    1. 1234\n\n.\nb. 2dge2", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="    1. 1234\n\n.\nb. 2dge2";
       parser.parsing("    1. 1234\n\n.\nb. 2dge2", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="1234\n--\n.\nb. 2dge2";
       parser.parsing("1234\n--\n.\nb. 2dge2", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="![abc](bcd)\n";
       parser.parsing("![abc](bcd)\n", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       doc1.md_data="![abc](bcd \"t\")\n";
       parser.parsing("![abc](bcd \"t\")\n", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="*abac* **abc**_abc_ __gjg__*\n";
       parser.parsing("*abac* **abc**_abc_ __gjg__*\n", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="[id](http://hi/ \"title\")\n";
       parser.parsing("[id](http://hi/ \"title\")\n", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="[id](http://hi/)\n";
       parser.parsing("[id](http://hi/)\n", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
     
       doc1.md_data="& a; a& b; a&b; & && &&& a&b a& b a &b &a; &amp; &a m;";
       parser.parsing("& a; a& b; a&b; & && &&& a&b a& b a &b &a; &amp; &a m;", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="\\' \\{ \\} \\[ \\] \\( \\) \\ \\n \\tt \\* \\\\";
       parser.parsing("\\' \\{ \\} \\[ \\] \\( \\) \\ \\n \\tt \\* \\\\", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
       
       doc1.md_data="    asdfasdfasdfasdf&&>< &amp;";
       parser.parsing("    asdfasdfasdfasdf&&>< &amp;", doc2);
       assertEquals(doc1.md_data,doc2.md_data);
   }

   
   @Test
   public void testCheckItem() {
      Document doc1 = new Document(); 
      Document doc2 = new Document(); 
      MDParser parser = new MDParser();
      
      doc1.md_data="12a. sd\n.s";
      parser.parsing("12a. sd\n.s",doc2);
      assertEquals(doc1.md_data,doc2.md_data);
   }

}