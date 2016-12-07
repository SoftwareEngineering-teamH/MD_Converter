package MD2HTML;


public interface MDElement 
{
	void accept(MDElementVisitor visitor);
}
