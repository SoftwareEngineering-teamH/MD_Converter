
public class StyleText extends Token implements MDElement
{
	public Token create(String data)
	{
		this.data = data;
		this.token_type = 2;
	
		return this;
	}
	
	public Token createEnd(String data)
	{
		this.data = data;
		this.token_type = 22;
		
		return this;
	}
}
