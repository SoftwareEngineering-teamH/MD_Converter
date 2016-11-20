import java.io.*;

public class main 
{
	public static void main(String[] args) throws IOException
	{
		String data = ""; 
		String type = "";
		// cli part >> (CLI class??)
		// data, type 받
		
		// Document Object 만듦 
		Document doc = new Document();
		
		// MDParser Object 만듦 
		MDParser pars = new MDParser();
		
		// Parsing() >> Document Object 에 node_list 저장
		pars.parsing(data, doc);
		
		// Document Object.accept((type)Visitor) 
		switch (type)
		{
		case "plain" : 
			doc.accept(new PlainVisitor());
			break;
		case "slide" : 
			doc.accept(new SlideVisitor());
			break;
		default	:  
			doc.accept(new FancyVisitor());
			break;
		}
		
		// Document Object.htmlData >> file output 
		
		//end.
		
	}
}


