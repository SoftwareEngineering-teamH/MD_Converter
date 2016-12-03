
public class MDParser 
{
	//parsing method
	public void parsing(String data, Document doc)
	{
		int node_type = 0;
		
		doc.md_data = data;
		
		// file is divided into string array by one sentence.
		String[] str_arr = doc.md_data.split("\n");	
		int str_arr_idx = 0;

		//for detect header or text
		doc.buffer1 = str_arr[str_arr_idx];

		str_arr_idx++;
		// read file until the end
		while(str_arr_idx < str_arr.length)
		{	
			doc.buffer2 = str_arr[str_arr_idx];
			//using buffer1 and buffer2, make to know what type is
			node_type = doc.check(doc.buffer1, doc.buffer2);
			
			if(node_type == 4)
			{	
				doc.buffer1 = "<li>" + doc.buffer1.substring(2,doc.buffer1.length()) + "</li>";
				
				while(!doc.buffer2.equals(""))
				{
					if(doc.buffer2.startsWith("* "))
						doc.buffer2 = "<li>" + doc.buffer2.substring(2,doc.buffer2.length()) + "</li>";
					else
						doc.buffer2 += "<br>";
					
					if(doc.check(doc.buffer2, doc.buffer2) == 44)
						break;
					
					doc.buffer1 += doc.buffer2;
					str_arr_idx++;
					
					if(str_arr_idx == str_arr.length)
						break;
					
					doc.buffer2 = str_arr[str_arr_idx];
				}
			}
			else if(node_type == 44)
			{	
				doc.buffer1 = "<li>" + doc.buffer1.substring(2,doc.buffer1.length()) + "</li>";
				
				while(!doc.buffer2.equals(""))
				{
					if(doc.buffer2.startsWith("1."))
						doc.buffer2 = "<li>" + doc.buffer2.substring(2,doc.buffer2.length()) + "</li>";
					else
							doc.buffer2 += "<br>";
					
					if(doc.check(doc.buffer2, doc.buffer2) == 4)
						break;
					
					doc.buffer1 += doc.buffer2;
					str_arr_idx++;
					if(str_arr_idx == str_arr.length)
						break;
					doc.buffer2 = str_arr[str_arr_idx];
				}
			}
			
			if (node_type != 0)
				doc.node_list.add(doc.setNode(node_type, doc.buffer1));
			
			doc.buffer1 = doc.buffer2;

			str_arr_idx++;
			
			if(str_arr_idx == str_arr.length)
			{
				node_type = doc.check(doc.buffer2, doc.buffer2);
				doc.node_list.add(doc.setNode(node_type, doc.buffer2));
			}
			
		}
		
		if(str_arr_idx == 1)
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
