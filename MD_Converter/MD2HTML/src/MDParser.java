
public class MDParser 
{
	//parsing method
	public void parsing(String data, Document doc)
	{
		int node_type = 0;
		
		doc.md_data = data;
		
		// parsing algorithm
		doc.buffer1 = doc.getLine(data);
		
		// file 다 읽을 때 까지..
		while(data != "")
		{
			//buffer2 랑 좀 수정 해줘야함......알고리즘....
			
			node_type = doc.check(doc.buffer1, doc.buffer2);
		
			// nested list , quoted처리 하는게 핵 어려울 듯........
			// 미완
			
			doc.node_list.add(doc.setNode(node_type, doc.buffer1));
			
			doc.buffer1 = doc.buffer2;
			
		}
			
		// setToken 
		for(int i =0; i<doc.node_list.size();i++)
		{
			doc.node_list.get(i).setToken();
		}
	}
}
