import java.util.ArrayList;

public class Document implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitDocument(this);
	}
	
	// attribute
	String buffer1 = "";
	String buffer2 = "";
	String list_bf = "";
	String quoted_bf = "";
	String md_data = "";
	String html_data = "";
	
	ArrayList<Node> node_list = new ArrayList<Node>();
	
	//method
	public String getLine(String str)
	{
		//str 에서 한문장 읽고 지우기 
		
		return str;
	}
	
	//nested list, quoted block 구분 하는게 개 어려울 듯....
	
	public int check(String str1, String str2)
	{
		int type_num = 0;
		
		//str1, str2 비교해서 ..? ===== 같은거 잇으면 헤더로 넣고 이런거 작업 해서 node 무슨 타입인지 알려주는 역할..? 없으면 그냥 TextNode로 설정하고 ㅎㅎ 
		
		
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
		default :
			ItemList il = new ItemList();
			return il.create(data);
		}
	}
}





