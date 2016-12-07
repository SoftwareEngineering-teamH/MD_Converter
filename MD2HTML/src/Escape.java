package MD2HTML;


public class Escape extends Token implements MDElement
{
	public Token createbacks(String data)
	{
		this.data = data;
		this.token_type = 3;
	
		return this;
	}
	public Token createlt(String data)
	{
		this.data = data;
		this.token_type = 33;
	
		return this;
	}
	public Token createamp(String data)
	{
		this.data = data;
		this.token_type = 333;
	
		return this;
	}
}
