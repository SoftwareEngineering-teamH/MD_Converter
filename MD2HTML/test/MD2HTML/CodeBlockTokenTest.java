package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeBlockTokenTest
{

	@Test
	public void testCreatelt() 
	{
		CodeBlockToken cb = new CodeBlockToken();
		cb.data = "test";
		cb.token_type = 7;

		assertSame(cb,cb.createlt("test"));
	}

	@Test
	public void testCreatert() 
	{
		CodeBlockToken cb = new CodeBlockToken();
		cb.data = "test";
		cb.token_type = 77;

		assertSame(cb,cb.creatert("test"));
	}

	@Test
	public void testCreateamp()
	{
		CodeBlockToken cb = new CodeBlockToken();
		cb.data = "test";
		cb.token_type = 777;

		assertSame(cb,cb.createamp("test"));
	}

}
