
public class QuotedBlock extends Node implements MDElement
{
	public Node create(String data)
	{
		this.md_data = data;
		this.node_type = 3;
		
		return this;
	}
}
