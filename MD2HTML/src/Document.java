import java.util.ArrayList;

public class Document implements MDElement
{
	//Node type
	static private int Header = 1;
	static private int CodeBlock = 2;
	static private int QuotedBlock = 3;
	static private int ItemList = 4;
	static private int Horizontal = 5;
	static private int TEXT = 6;
	
	//accept 
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitDocument(this);
	}
	
	// attribute
	String buffer1 = "";
	String buffer2 = "";
	String md_data = "";
	String html_data = "";
	
	ArrayList<Node> node_list = new ArrayList<Node>();
	
	//method
	public int check(String buffer1, String buffer2)
	{
		int type_num = 0;
		
		if(buffer2.startsWith("==") || buffer2.startsWith("==") || buffer1.startsWith("#") || buffer1.startsWith("##") || buffer1.startsWith("###"))
		{
			// if second sentence has ==, then first node is Header
			type_num = Header;
		}
		else if(buffer1.startsWith("=="))
		{
			//TEXT
			type_num = 0;
		}
		else if(buffer1.startsWith("* ") || buffer1.startsWith("+ ") || buffer1.startsWith("- "))
		{
			type_num = ItemList;
		}
		else if(buffer1.startsWith("1."))
		{
			type_num = 44;
		}
		else if(buffer1.startsWith(">"))
		{
			type_num = QuotedBlock;
		}
		else if(buffer1.startsWith("	"))
		{
			// if sentence starts with tab(or 4 space), it is code block.
			type_num = CodeBlock;
		}
		//how to check the repeated astalisk and hypen three more time?
		else if(buffer1.startsWith("---"))
		{
			type_num = Horizontal;
		}
		else
		{
			type_num = TEXT;
		}
		
		return type_num;
	}
	public int check(String[] buffer){
		int type_num = 0;
		
		
		return type_num;
	}

	
	public Node setNode(int type, String data)
	{
		switch(type)
		{
		case 1 : 
			Header hd = new Header();
			return hd.create(data);
		case 2 : 
			CodeBlock cb  = new CodeBlock();
			return cb.create(data);
		case 3 :
			QuotedBlock qb = new QuotedBlock();
			return qb.create(data);
		case 4 :
			ItemList ul = new ItemList();
			return ul.create(data, 4);
		case 44 :
			ItemList ol = new ItemList();
			return ol.create(data, 44);
		case 5 :
			Horizontal hz = new Horizontal();
			return hz.create(data);
		default :
			TextBlock tt = new TextBlock();
			return tt.create(data);
		}
	}

}



