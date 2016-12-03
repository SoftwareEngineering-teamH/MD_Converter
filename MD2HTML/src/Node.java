import java.util.ArrayList;

public class Node implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitNode(this);
	}
	
	//attribute
	String md_data = "";
	String[] md_data_arr;
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
	public Node create(String[] data)
	{
		this.md_data_arr = data;
		
		return this;
	}
	
	public void setToken()
	{	
		int length = md_data.length();
		int[] token_arr = new int[length];
		int[] stack_style = new int[length];
		//init
		for(int i=0; i<token_arr.length;i++)
			token_arr[i]=0;
		
		//init stack_style
		for(int i=0; i<stack_style.length;i++)
			stack_style[i]=stack_style.length;
		
		int j = 0;
		int em_count = 0;
		int strong_count=0;
		int three_over = 1;
		
		boolean style_strong_flag = false;
		boolean style_em_flag = true;
		
		//boolean buf_zero_style = false;
		
		// style - algorithm
		for(int i = 0; i<token_arr.length; i++)
		{
			//style
			if(md_data.charAt(i) == '*' && token_arr[i] == 0 )
			{
				//if(i ==0)buf_zero_style = true;
				
				if(i+1<token_arr.length && md_data.charAt(i) == '*' && md_data.charAt(i+1) == '*')
				{
					style_strong_flag = true;
					style_em_flag=false;
					three_over++;
					if(three_over>=3)
					{
						token_arr[i-1] = token_arr[i] = token_arr[i+1] =0;
					}
					
				}
				else if(i-1 >= 0 && md_data.charAt(i) == '*' && md_data.charAt(i-1) != '*')
				{
					style_strong_flag = false;
					style_em_flag=true;
					three_over = 0;
				}
				if(style_strong_flag == true && style_em_flag==false)
					strong_count++;
				if(style_strong_flag == false && style_em_flag==true)
					em_count++;
					//count=j+1;
				//this stack is to know which index have *
				stack_style[j] = i;
				
				if(em_count == 1 && style_em_flag == true && style_strong_flag ==false)
				{
				token_arr[i] = 2;
				//count = 0;
				}
				
				else if(em_count == 2 && style_em_flag == true && style_strong_flag ==false)
				{
					token_arr[i] = 22;
					em_count=0;
					stack_style[j] = stack_style[j-1]=stack_style.length;;
					j= j-2;
				}
				
				//strong
				else if(strong_count == 1 && style_strong_flag == true && style_em_flag ==false)
				{
					token_arr[i] = 2;
					
				}
				
				else if(strong_count == 2 && style_strong_flag == true && style_em_flag ==false)
				{
					token_arr[i] = 2;
					//count = 0;
				}
				else if(strong_count == 3 && style_strong_flag == true && style_em_flag ==false)
				{
					token_arr[i] = 22;
					//count = 0;
				}
				else if(strong_count == 4 && style_strong_flag == true && style_em_flag ==false)
				{
					token_arr[i] = 22;
					strong_count = 0;
					//count = 0;
					style_strong_flag = false;
					style_em_flag = true;
					stack_style[j] = stack_style[j-1] = stack_style[j-2] =stack_style[j-3] =stack_style.length;;
					j= j-4;
				}
				j++;
				//style_strong_flag = false;
				/*try
				{
					if(md_data.charAt(i+1) == '*')
						token_arr[i+1] = 2;
				}
				catch(Exception e)
				{
					// String index error
				}
					
				for(int j = i+2; j<token_arr.length;j++)
				{//jump more one block to detect 
					if(md_data.charAt(j) == '*' && token_arr[j] == 0)
					{
						token_arr[j] = 22;
						if(md_data.charAt(j+1) == '*')
							token_arr[j+1] = 22;
						break;
					}
				}*/
			}
		}
		
		//�� ���� *¦�� ���� �ʴ� �͵��� ��� 0���� �ٲ��ֱ�. 
		for(int k=0;k<stack_style.length;k++)
		{
			if(stack_style[k] != stack_style.length)token_arr[stack_style[k]] = 0;
			else break;
		}
		//if(buf_zero_style == true)token_arr[0] = 0;
		
		
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
				break;
			case 22 :
				StyleText stE = new StyleText();
				this.token_list.add(stE.createEnd(data));
				break;
			default :
				break;
			}	
		}
		//for 0 token to last
		zero z = new zero();
		this.token_list.add(z.create());
	}
	
	
	public String setStartTag()
	{
		switch(this.node_type)
		{
		case 1:
			// if header_type =1 > #, 11 > ##
			return "<h1>";
		case 11:
			return "<h2>";
		case 111:
			return "<h3>";
		case 1111:
			return "<h4>";
		case 11111:
			return "<h5>";
		case 111111:
			return "<h6>";
		case 2:
			return "<pre><code>";
		// ItemList�� ���� ��Ȯ�� ó������ ���� ���� (ordered/unordered ������ �� ����)
		case 4:
			return "<ul>";
		case 44:
			return "<ol>";
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
		case 11:
			return "</h2>";
		case 111:
			return "</h3>";
		case 1111:
			return "</h4>";
		case 11111:
			return "</h5>";
		case 111111:
			return "</h6>";
		case 2:
			return "</code></pre>";
		case 4:
			return "</ul>";
		case 44:
			return "</ol>";
		default :
			return "</br>";
		}
	}
}







