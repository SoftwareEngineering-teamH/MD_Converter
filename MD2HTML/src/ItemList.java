package MD2HTML;


public class ItemList extends Node implements MDElement
{
	public Node create(String data, int node_type)
	{
		this.md_data = data;
		
		this.node_type = node_type;
		
		return this;
	}
}
