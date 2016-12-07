package MD2HTML;


public class QuotedBlock extends Node implements MDElement
{
	public Node create(String data)
	{
		this.md_data = data;
		this.md_data = this.md_data.substring(2,this.md_data.length());
		this.node_type = 3;
		
		return this;
	}
}
