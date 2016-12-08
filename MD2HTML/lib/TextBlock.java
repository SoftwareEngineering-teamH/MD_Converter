package MD2HTML;


public class TextBlock extends Node implements MDElement
{
	public Node create(String data)
	{
		this.md_data = data;
		this.node_type = 6;
		
		return this;
	}
}
