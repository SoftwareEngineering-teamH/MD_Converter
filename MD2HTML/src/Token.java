
public class Token implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		//visitor.visitToken(this);
	}
	
	//attribute
	String data = "";
	int token_type = 0;
	
	//method
	// 얘도 overriding 해줘서 token_type 정해주기 
	public Token create(String data)
	{
		this.data = data;
		
		return this;
	}
	
}