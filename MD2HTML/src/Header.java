
public class Header extends Node implements MDElement
{

	public Node create(String data)
	{
		this.md_data = data;
		this.node_type = 1;
		
		return this;
	}

}
