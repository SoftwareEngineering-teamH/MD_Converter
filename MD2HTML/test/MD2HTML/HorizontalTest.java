package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class HorizontalTest 
{
	@Test
	public void test() 
	{
		Horizontal hl = new Horizontal();
		hl.md_data = "";
		hl.node_type = 5;
		
		assertSame(hl.create("test"), hl);
		
	}

}
