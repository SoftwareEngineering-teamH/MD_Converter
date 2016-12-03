
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
		String[] for_list = new String[str_arr.length];
		int for_list_count = 0;
		boolean unorder_itemList = false;
		boolean order_itemList = false;
		//for(int i = 0; i<str_arr.length; i++)
			//System.out.println(i + "th split test" + str_arr[i]);
		
		// parsing algorithm //document의 buffer로 간다.
		
		//for detect itemList
		if(str_arr[str_arr_idx].startsWith("* ")||str_arr[str_arr_idx].startsWith("+ ") ||str_arr[str_arr_idx].startsWith("- ")){
			unorder_itemList = true;
			order_itemList = false;
			for_list[for_list_count] = str_arr[str_arr_idx];
			for_list_count++;
			//버퍼에 넣어야지
		}else if(str_arr[str_arr_idx].startsWith("1. ")){
			unorder_itemList = false;
			order_itemList = true;
			for_list[for_list_count] = str_arr[str_arr_idx];
			for_list_count++;
			//버퍼에 넣어야지
		}else if(unorder_itemList == false && order_itemList == false){
		//for detect header or text
		doc.buffer1 = str_arr[str_arr_idx];
		
		}
		str_arr_idx++;
		// read file until the end
		while(str_arr_idx < str_arr.length)
		{	
			//for item list
			
			if(str_arr[str_arr_idx].equals("")){
				if(unorder_itemList == true || order_itemList ==true){
					int j = 0;
					for(int i =0; for_list[i] != null;i++){
						j = i;
					}
					String[] data_arr = new String[j+1];
					for(int i =0; i<=j;i++){
						data_arr[i] = for_list[i];
					}
					node_type = doc.check(data_arr);
					
					if (node_type != 0)
						doc.node_list.add(doc.setNode(node_type, data_arr));
				
					//엔터가 오면 그동안 쌓인 list들을 node로 만들어주기
					unorder_itemList = false;
					order_itemList = false;
					//버퍼 초기화
					for_list = new String[str_arr.length];
					for_list_count = 0;
				}else{
					doc.buffer2 = str_arr[str_arr_idx];
					//using buffer1 and buffer2, make to know what type is
					node_type = doc.check(doc.buffer1, doc.buffer2);
					
					
					//타입이 0이 될수가 없구나
					if (node_type != 0)
						doc.node_list.add(doc.setNode(node_type, doc.buffer1));
					
					doc.buffer1 = doc.buffer2;
				}
			}else if(str_arr[str_arr_idx].startsWith("* ")||str_arr[str_arr_idx].startsWith("+ ") ||str_arr[str_arr_idx].startsWith("- ")){
				
				if(order_itemList == true){
					//버퍼 노드로 넣어주고 초기화
					for_list = new String[str_arr.length];
					for_list_count = 0;
				}
				
				unorder_itemList = true;
				order_itemList = false;
				for_list[for_list_count] = str_arr[str_arr_idx];
				for_list_count++;
				
			}else if(str_arr[str_arr_idx].startsWith("1. ")){
				
				if(unorder_itemList == true){
					//버퍼 노드로 넣어주고 초기화
					for_list = new String[str_arr.length];
					for_list_count = 0;
				}
				
				unorder_itemList = false;
				order_itemList = true;
				for_list[for_list_count] = str_arr[str_arr_idx];
				for_list_count++;
				
			}else if(unorder_itemList ==true && order_itemList == false && !str_arr[str_arr_idx].startsWith("* ")&& !str_arr[str_arr_idx].startsWith("+ ") && !str_arr[str_arr_idx].startsWith("- ")){
				
				//for orderlist
				for_list[for_list_count] = str_arr[str_arr_idx];
				for_list_count++;
			
				
				
			}else if(!str_arr[str_arr_idx].startsWith("1. ") && unorder_itemList == false && order_itemList == true){
				//for orderlist
				for_list[for_list_count] = str_arr[str_arr_idx];
				for_list_count++;
			
			}else if(unorder_itemList == false && order_itemList == false){
			
			
			doc.buffer2 = str_arr[str_arr_idx];
			//using buffer1 and buffer2, make to know what type is
			node_type = doc.check(doc.buffer1, doc.buffer2);
			
			
			//타입이 0이 될수가 없구나
			if (node_type != 0)
				doc.node_list.add(doc.setNode(node_type, doc.buffer1));
			
			doc.buffer1 = doc.buffer2;
			//final string
			if(str_arr_idx == str_arr.length-1 && !doc.buffer2.startsWith("=="))
				doc.node_list.add(doc.setNode(node_type, doc.buffer2));
			
			
			}
			str_arr_idx++;
		}
		
		
		
		if(str_arr_idx ==1)
		{
			doc.buffer2 = "";
			node_type = doc.check(doc.buffer1, doc.buffer2);
				
			doc.node_list.add(doc.setNode(node_type, doc.buffer1));
		}
		
		//for 0 node
		//doc.node_list.add(doc.setNode(node_type, doc.buffer2));
		
		// setToken 
		for(int i =0; i<doc.node_list.size();i++)
		{
			doc.node_list.get(i).setToken();
		}
	}
}
