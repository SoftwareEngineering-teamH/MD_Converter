package MD2HTML;


public class Horizontal extends Node implements MDElement
{
	public Node create(String data)
	{
		this.md_data = "";
		this.node_type = 5;
		
		return this;
	}
}
