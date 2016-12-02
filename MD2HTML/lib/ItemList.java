
public class ItemList extends Node implements MDElement
{
	public Node create(String data)
	{
		this.md_data = data;
		this.node_type = 4;
		
		return this;
	}
}
