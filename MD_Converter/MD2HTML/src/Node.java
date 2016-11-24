import java.util.ArrayList;

public class Node implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitNode(this);
	}
	
	//attribute
	String md_data = "";
	String html_data = "";
	int node_type = 0;
	
	ArrayList<Token> token_list = new ArrayList<Token>();
	
	//method
	//node 마다 overriding 해줘서 node_type = 1;;이런식으로 설정 
	public Node create(String data)
	{
		this.md_data = data;
		
		return this;
	}
	
	public void setToken()
	{	
		for(int i = 0; i<md_data.length(); i++)
		{
			String data = md_data.substring(i, i+1);
			// case 더 추가 해야함....ㅠ 
			// 이미지나 링크 같은거 어려운데 어떻게 처리할지 고민해 봐야함......ㅠㅠ 여기 도 어렵...
			// 미완 
			switch (data)
			{
			case "*" : 
				StyleText st = new StyleText();
				this.token_list.add(st.create(data));
				break;
			default :
				PlainText pt = new PlainText();
				this.token_list.add(pt.create(data));
				break;
			}
			
		}
	}
	
}