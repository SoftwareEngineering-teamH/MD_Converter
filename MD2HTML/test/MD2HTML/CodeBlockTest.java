package MD2HTML;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodeBlockTest 
{	
	@Test
	public void test_create() 
	{
		CodeBlock test_CodeBlock1 = new CodeBlock();
		CodeBlock test_CodeBlock2 = new CodeBlock();
		test_CodeBlock1.md_data="abc";
		test_CodeBlock1.node_type = 2;
		assertEquals(test_CodeBlock1.md_data,test_CodeBlock2.create("abc").md_data);
		assertEquals(test_CodeBlock1.node_type,test_CodeBlock2.create("abc").node_type);
	}

}
