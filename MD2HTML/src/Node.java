import java.util.ArrayList;

public class Node implements MDElement
{
	//Node type
	static final private int Header = 1;
	static final private int CodeBlock = 2;
	static final private int QuotedBlock = 3;
	static final private int ItemList = 4;
	static final private int Horizontal = 5;
	static final private int TEXT = 6;
	
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
		
		// initialize
		for(int i=0;i<token_arr.length;i++)
		{
				token_arr[i] = 0;
		}
		
		for(int i=0;i<token_arr.length;i++)
		{
			int flag = 0;

			try
			{
				// strong tag
				if(md_data.charAt(i)=='*' && md_data.charAt(i+1)=='*' && token_arr[i] == 0 && i+1 < token_arr.length)
				{
					flag = 1;
					for(int j=i+2;j<token_arr.length;j++){
						if(md_data.charAt(j)=='*' && md_data.charAt(j+1)=='*' && token_arr[j] == 0 && flag == 1){
							token_arr[i] = 2;
							token_arr[i+1] = 2;		
							token_arr[j] = 22;
							token_arr[j+1] = 22;
							break;
						}
					}
				}
			} catch(Exception e)
			{ 
				// String index error
			}
			
			// em tag
			if(md_data.charAt(i) == '*' && token_arr[i] == 0 && i < token_arr.length)
			{
				flag = 1;
				for(int j=i+1; j < token_arr.length; j++)
				{
					if(md_data.charAt(j)=='*' && token_arr[j] == 0 && flag == 1 && j < token_arr.length)
					{
						token_arr[i] = 2;
						token_arr[j] = 22;
						break;
					}
				}
			}	
			
			// link token
			if(md_data.charAt(i) == '[' && token_arr[i] == 0 && i < token_arr.length)
			{
				for(int j=i+1; j<token_arr.length; j++)
				{
					if(md_data.charAt(j) == ']' && token_arr[j] == 0 && j < token_arr.length)
					{
						for(int k = j+1; k < token_arr.length; k++)
						{
							if(md_data.charAt(k) == '(' && token_arr[k] == 0 && k < token_arr.length)
							{
								for(int l = k+1; l < token_arr.length; l++)
								{
									if(md_data.charAt(l) == ')' && token_arr[l] == 0 && l < token_arr.length)
									{
										token_arr[i] = 4;
										token_arr[j] = 44;
										token_arr[k] = 444;
										token_arr[l] = 4444;
									}
								}
							}
						}
					}
				}
			}
				
			// image token
			if(md_data.charAt(i) == '!' && token_arr[i] == 0 && i < token_arr.length)
			{
				for(int j=i+1; j<token_arr.length; j++)
				{
					if(md_data.charAt(j) == '[' && token_arr[j] == 0 && j < token_arr.length)
					{
						for(int k = j+1; k < token_arr.length; k++)
						{
							if(md_data.charAt(k) == ']' && token_arr[k] == 0 && k < token_arr.length)
							{
								for(int l = k+1; l < token_arr.length; l++)
								{
									if(md_data.charAt(l) == '(' && token_arr[l] == 0 && l < token_arr.length)
									{
										for(int m = l+1; m < token_arr.length; m++)
										{
											if(md_data.charAt(m) == ')' && token_arr[m] == 0 && l < token_arr.length)
											{
												token_arr[i] = 5;
												token_arr[j] = 5;
												token_arr[k] = 55;
												token_arr[l] = 555;
												token_arr[m] = 5555;
											}
										}
									}
								}
							}
						}
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
				break;
			case 22 :
				StyleText stE = new StyleText();
				this.token_list.add(stE.createEnd(data));
				break;
			case 4:
				Link linkFirst = new Link();
				this.token_list.add(linkFirst.createFirst(data));
				break;
			case 44:
				Link linkSec = new Link();
				this.token_list.add(linkSec.createSecond(data));
				break;
			case 444:
				Link linkThird = new Link();
				this.token_list.add(linkThird.createThird(data));
				break;
			case 4444:
				Link linkLast = new Link();
				this.token_list.add(linkLast.createLast(data));
				break;
			case 5:
				Image imgFirst = new Image();
				this.token_list.add(imgFirst.createFirst(data));
				break;
			case 55:
				Image imgSec = new Image();
				this.token_list.add(imgSec.createSecond(data));
				break;
			case 555:
				Image imgThird = new Image();
				this.token_list.add(imgThird.createThird(data));
				break;
			case 5555:
				Image imgLast = new Image();
				this.token_list.add(imgLast.createLast(data));
				break;
			default :
				break;
			}	
		}
	}
	
	
	public String setStartTag()
	{
		switch(this.node_type)
		{
		case Header:
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
		case CodeBlock:
			return "<pre><code>";
		case QuotedBlock:
			return "";
		case ItemList:
			return "<ul>";
		case 44:
			return "<ol>";
		case Horizontal :
			return "";
		default :
			return "<br>";
		}
	}
	
	public String setEndTag()
	{
		switch(this.node_type)
		{
		case Header:
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
		case CodeBlock:
			return "</code></pre>";
		case QuotedBlock:
			return "";
		case ItemList:
			return "</ul>";
		case 44:
			return "</ol>";
		case Horizontal:
			return "";
		default :
			return "</br>";
		}
	}
}







