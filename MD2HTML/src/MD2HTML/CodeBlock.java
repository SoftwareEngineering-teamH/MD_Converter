package MD2HTML;


public class CodeBlock extends Node implements MDElement
{
	public Node create(String data)
	{
		this.md_data = data;
		this.node_type = 2;
		
		return this;
	}
}
