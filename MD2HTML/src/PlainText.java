
public class PlainText extends Token implements MDElement
{
	public Token create(String data)
	{
		this.data = data;
		this.token_type = 1;
	
		return this;
	}
	
}
