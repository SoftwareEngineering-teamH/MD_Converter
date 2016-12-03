
public class ItemList extends Node implements MDElement
{
	public Node create(String[] data)
	{
		this.md_data_arr = data;
		
		// list 문법 뒤에 스페이스 한 칸 띄우고 헤더 내용 작성한다고 가정
		if(md_data_arr[0].startsWith("* ") || md_data_arr[0].startsWith("+ ") || md_data_arr[0].startsWith("- "))
			this.node_type = 4;
		else
			this.node_type = 44;
		
		return this;
	}
}
