
public class Header extends Node implements MDElement
{

	public Node create(String data)
	{
		this.md_data = data;
		
		// # �ڿ� �����̽� �� ĭ ���� ��� ���� �ۼ��Ѵٰ� ���� 
		// ==���� �ۼ��� ����� ���� ��ó��
		// --�� ��� ó�� x?
		if(md_data.startsWith("# "))
			this.node_type = 1;
		
		else if(md_data.startsWith("## "))
			this.node_type = 11;
		
		else if(md_data.startsWith("### "))
			this.node_type = 111;
		
		else if(md_data.startsWith("#### "))
			this.node_type = 1111;
		
		else if(md_data.startsWith("##### "))
			this.node_type = 11111;
		
		else if(md_data.startsWith("###### "))
			this.node_type = 111111;
		
		return this;
	}

}
