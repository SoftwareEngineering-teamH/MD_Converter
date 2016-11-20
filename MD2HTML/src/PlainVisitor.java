
public class PlainVisitor implements MDElementVisitor
{
	public void visitDocument(Document doc)
	{
		for(int i = 0; i<doc.node_list.size(); i++)
		{
			doc.node_list.get(i).accept(new PlainVisitor());
		}
	}
	public void visitNode(Node node)
	{
		String html ="";
		
		//convert algorithm
		
		// token 에 접근 할 때
		node.token_list.get(0).accept(new PlainVisitor());
		
		//return ...
		
	}

	public void visitToken(Token token)
	{
		
	}
}
