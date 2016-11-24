import java.io.*;
import java.util.Scanner;

public class main 
{
	public static void main(String[] args) throws IOException
	{
		String data = ""; 
		String type = "";
		
		// CLI part >> (CLI class??)
		File file = new File(args[1]);
        Scanner sc = new Scanner(file);
        while(sc.hasNext()) 
           data += sc.next();
		
		// data, type 받기 
		
		// Document Object 만듦 
		Document doc = new Document();
		
		// MDParser Object 만듦 
		MDParser pars = new MDParser();
		
		////////////////
		//parsing test
		/*
		data = "123456\n";
		data += "====\n";
		data += "7890\n";
		*/
		// Parsing() >> Document Object 에 node_list 저장
		pars.parsing(data, doc);
		
		System.out.println(doc.node_list.get(0).md_data);
		//System.out.println(doc.node_list.get(1).md_data);
		
		/*
		///////////////////////////////////////////////////////////////////
		//Generate test
		type = "plain";
		String str = "a*b*c ![Alt id](/path)*abc*a";
		int[] tk_type = new int[] {1,2,1,22,1,1,5,5,1,1,1,1,1,1,55,555,1,1,1,1,1,5555,2,1,1,1,22,1,0};
		
		Header hd = new Header();
		doc.node_list.add(hd.create(str));
		doc.node_list.get(0).node_type = 1;
		for (int i = 0; i<28; i++)
		{
			Token tk = new Token();
			tk.create(str.substring(i, i+1));
			tk.token_type = tk_type[i];
			doc.node_list.get(0).token_list.add(tk);
		}
		System.out.println(doc.node_list.get(0).md_data);
		
		//////////////////////////////////////////////////////////////////
		*/
		
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
		
		// html error test
		/*
		Tidy tidy = new Tidy();
   		InputStream stream = new ByteArrayInputStream(htmlData.getBytes());
   		tidy.parse(stream, System.out);
   		return (tidy.getParseErrors() == 0);  
		 */
		
		
		// Document Object.htmlData >> file output
		
		
		//doc.html_data test 
		System.out.println(doc.html_data);
		
		//end
	}
}


