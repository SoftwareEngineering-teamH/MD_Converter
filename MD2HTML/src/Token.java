import java.util.ArrayList;

public class Token implements MDElement
{
	public void accept(MDElementVisitor visitor)
	{
		visitor.visitToken(this);
	}
	
	//attribute
	String data = "";
	int token_type = 0;
	
	//ArrayList<Integer> check_buffer = new ArrayList<Integer>();
	
	//method
	public void checkToken()
	{
		// token_type 에 숫자로 넣어 주면 되는건가....?
		
	}
	
}
