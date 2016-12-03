
public class MDParser 
{
	//parsing method
	public void parsing(String data, Document doc)
	{
		int node_type = 0;
		
		doc.md_data = data;
		
		//System.out.println("test : " +doc.md_data);
		
		// file is divided into string array by one sentence.
		String[] str_arr = doc.md_data.split("\n");	
		int str_arr_idx = 0;
		
		
		//for(int i = 0; i<str_arr.length; i++)
			//System.out.println(i + "th split test" + str_arr[i]);
		
		// parsing algorithm
		doc.buffer1 = str_arr[str_arr_idx];
		str_arr_idx++;
		////
		// read file until the end
		while(str_arr_idx < str_arr.length)
		{		
			doc.buffer2 = str_arr[str_arr_idx];
			
			node_type = doc.check(doc.buffer1, doc.buffer2);
			
			if (node_type != 0)
				doc.node_list.add(doc.setNode(node_type, doc.buffer1));
			
			doc.buffer1 = doc.buffer2;

			str_arr_idx++;
		}
		
		if(str_arr_idx ==1)
		{
			doc.buffer2 = "";
			node_type = doc.check(doc.buffer1, doc.buffer2);
				
			doc.node_list.add(doc.setNode(node_type, doc.buffer1));
		}

		
		// setToken 
		for(int i =0; i<doc.node_list.size();i++)
		{
			doc.node_list.get(i).setToken();
		}
	}
}