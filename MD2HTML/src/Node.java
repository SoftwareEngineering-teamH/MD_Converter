import java.util.ArrayList;

public class Node implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitNode(this);
	}
	
	//attribute
	String data = "";
	int node_type = 0;
	
	ArrayList<Token> token_list = new ArrayList<Token>();
	
	//method
	// virtual 로 해서 node 마다 다르게 만들어 줘야 할 것 같...
	public Node create(String data)
	{
		this.data = data;
		
		return this;
	}
	
	public void setToken()
	{
		int token_type = 0;
		
		for(int i = 0; i<data.length(); i++)
		{
			//token 구별해주기....
			
			//구별 해주면 토큰 리스트에 토큰 넣기...
			// if ( data.substring(i,i+1) == "*" )
			
			// Token 
			
			// Node 처럼 Token 안에 create 만들어서 할까....
			
			//this.token_list.add();
		}
		
		
	}
	
}