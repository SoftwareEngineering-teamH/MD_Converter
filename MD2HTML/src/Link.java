package MD2HTML;


public class Link extends Token implements MDElement
{
	public Token createFirst(String data)
	{
		this.data = data;
		this.token_type = 4;
	
		return this;
	}
	
	public Token createSecond(String data)
	{
		this.data = data;
		this.token_type = 44;
	
		return this;
	}

	public Token createThird(String data)
	{
		this.data = data;
		this.token_type = 444;
	
		return this;
	}

	public Token createLast(String data)
	{
		this.data = data;
		this.token_type = 4444;
	
		return this;
	}

}
