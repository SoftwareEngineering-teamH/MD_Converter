package MD2HTML;


public class Token implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		
	}
	
	//attribute
	String data = "";
	int token_type = 0;
	
	//method
	// This method overriding >  token_type  setting
	public Token create(String data)
	{
		this.data = data;
		
		return this;
	}
	
}
