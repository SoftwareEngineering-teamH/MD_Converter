package MD2HTML;


public class CodeBlockToken extends Token implements MDElement
{
	public Token createlt(String data)
	{
		this.data = data;
		this.token_type = 7;
	
		return this;
	}
	public Token creatert(String data)
	{
		this.data = data;
		this.token_type = 77;
	
		return this;
	}
	public Token createamp(String data)
	{
		this.data = data;
		this.token_type = 777;
	
		return this;
	}
}
