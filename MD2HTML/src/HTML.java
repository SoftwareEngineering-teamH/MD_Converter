
public class HTML extends Token implements MDElement
{
	public Token create(String data)
	{
		this.data = data;
		this.token_type = 6;
		
		return this;
	}
}
