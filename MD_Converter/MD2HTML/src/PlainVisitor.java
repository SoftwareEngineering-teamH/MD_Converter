
public class PlainVisitor implements MDElementVisitor
{
	public void visitDocument(Document doc)
	{
		for(int i = 0; i<doc.node_list.size(); i++)
		{
			doc.node_list.get(i).accept(new PlainVisitor());
			doc.html_data += doc.node_list.get(i).html_data;
		}
	}
	
	public void visitNode(Node node)
	{
		// token_list
		for(int i=0;i<node.token_list.size(); i++)
		{
			//node.token_list.get(i).token_type
			// convert 부분
			// 미완 
		}
		
		//node.html_data += 
		//node type에 따라 앞뒤에 <> </>붙여주기...
	}
	
	/*
	public void visitToken(Token token)
	{
		// 여기서 토큰 하나하나 컨버트.....?
		
	}
	*/
}