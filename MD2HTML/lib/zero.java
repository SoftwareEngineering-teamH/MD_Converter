
public class zero extends Token implements MDElement
{
	public Token create()
	{
		this.data = null;
		this.token_type = 0;
	
		return this;
	}
	
}
