
public class Header extends Node implements MDElement
{

	public Node create(String data)
	{
		this.md_data = data;
		
		// # 뒤에 스페이스 한 칸 띄우고 헤더 내용 작성한다고 가정 
		// ==으로 작성된 헤더는 아직 미처리
		// --은 헤더 처리 x?
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
