package MD2HTML;


public class Header extends Node implements MDElement
{
	public Node create(String data, int node_type)
	{
		this.md_data = data;
		
		this.node_type = node_type;
		
		if(md_data.startsWith("# "))
		{
			this.md_data = this.md_data.substring(2,this.md_data.length());
			this.node_type = 111;
		}
		else if(md_data.startsWith("## "))
		{
			this.md_data = this.md_data.substring(3,md_data.length());
			this.node_type = 1111;
		}
		else if(md_data.startsWith("### "))
		{
			this.md_data = this.md_data.substring(4,md_data.length());
			this.node_type = 11111;
		}
		else if(md_data.startsWith("#### "))
		{
			this.md_data = this.md_data.substring(5,md_data.length());
			this.node_type = 111111;
		}
		else if(md_data.startsWith("##### "))
		{
			this.md_data = this.md_data.substring(6,md_data.length());
			this.node_type = 1111111;
		}
		else if(md_data.startsWith("###### "))
		{
			this.md_data = this.md_data.substring(7,md_data.length());
			this.node_type = 11111111;
		}
		return this;
	}

}
