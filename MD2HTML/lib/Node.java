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
	// every node overriding > node_type = 1;;setting 
	public Node create(String data)
	{
		this.md_data = data;
		
		return this;
	}
	
	public void setToken()
	{	
		int length = md_data.length();
		int[] token_arr = new int[length];
		
		//init
		for(int i=0; i<token_arr.length;i++)
			token_arr[i]=0;
		
		// style - algorithm
		for(int i = 0; i<token_arr.length; i++)
		{
			if(md_data.charAt(i) == '*' && token_arr[i] == 0)
			{
				token_arr[i] = 2;
				try
				{
					if(md_data.charAt(i+1) == '*')
						token_arr[i+1] = 2;
				}
				catch(Exception e)
				{
					// String index error
				}
				for(int j = i+1; j<token_arr.length;j++)
				{
					if(md_data.charAt(j) == '*' && token_arr[j] == 0)
					{
						token_arr[j] = 22;
						if(md_data.charAt(j+1) == '*')
							token_arr[j+1] = 22;
						break;
					}
				}
			}
		}
		
		for(int i = 0; i<md_data.length(); i++)
		{
			String data = md_data.substring(i, i+1);
			switch (token_arr[i])
			{
			case 0 : 
				PlainText pt = new PlainText();
				this.token_list.add(pt.create(data));
				break;
			case 2 :
				StyleText st = new StyleText();
				this.token_list.add(st.create(data));
			case 22 :
				StyleText stE = new StyleText();
				this.token_list.add(stE.createEnd(data));
			default :
				break;
			}	
		}
	}
	
	
	public String setStartTag()
	{
		switch(this.node_type)
		{
		case 1:
			// if header_type =1 > #, 2 > ##
			return "<h1>";
		case 2:
			return "<pre><code>";
		default :
			return "<br>";
		}
	}
	
	public String setEndTag()
	{
		switch(this.node_type)
		{
		case 1:
			return "</h1>";
		case 2:
			return "</code></pre>";
		default :
			return "</br>";
		}
	}
}







