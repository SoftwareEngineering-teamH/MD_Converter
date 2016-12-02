import java.io.*;
import java.util.Scanner;
import org.w3c.tidy.Tidy;

public class main 
{
	public static void main(String[] args) throws IOException
	{
		String data = ""; 
		String type = "";
		
		// CLI part >> (CLI class??)
		File file = new File(args[0]);
        Scanner sc = new Scanner(file);
        
        while(sc.hasNext()) 
        {
           data += sc.next();
           data += "\n";
        }
		// data, type get form cli
		
		// Document Object make.
		Document doc = new Document();
		
		// MDParser Object make.
		MDParser pars = new MDParser();
		
		////////////////
		//parsing test
		/*
		data = "123456\n";
		data += "====\n";
		data += "7890\n";
		*/
		
		// Parsing() >> In Document Object  node_list save
		pars.parsing(data, doc);
		
		// test
		//for(int i=0;i<4;i++)
			//System.out.println(doc.node_list.get(i).md_data +"type:" + doc.node_list.get(i).node_type);
		
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
		/////test
		type = "plain";
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
		
		//doc.html_data = "<head> aaa <asdf>";
		
		/*
		Tidy tidy = new Tidy();
   		InputStream stream = new ByteArrayInputStream(doc.html_data.getBytes());
   		tidy.parse(stream, System.out);
   		
   		if (tidy.getParseErrors() != 0 )
   			System.out.println("error exist");
   		else if (tidy.getParseErrors() == 0)
   			System.out.println("No error");
		*/
		
		// Document Object.htmlData >> file output
		
   		
		//doc.html_data test 
		System.out.println(doc.html_data);
		
		//end
	}
}


