import java.util.ArrayList;

public class Document implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitDocument(this);
	}
	
	// attribute들 
	String buffer1 = "";
	String buffer2 = "";
	String list_bf = "";
	String quoted_bf = "";
	String md_data = "";
	String html_data = "";
	
	ArrayList<Node> node_list = new ArrayList<Node>();
	
	//method들 
	public String getLine(String str)
	{
		//str 에서 한문장 읽
		
		return str;
	}
	
	public int check(String str1, String str2)
	{
		int type_num = 0;
		
		
		
		return type_num;
	}
}
