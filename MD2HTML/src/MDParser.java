
public class MDParser 
{
	//parsing method
	public void parsing(String data, Document doc)
	{
		int node_type = 0;
		
		doc.md_data = data;
		
		// parsing algorithm
		doc.buffer1 = doc.getLine(data);
		
		/*
		while()
		{
			node_type = doc.check();
			doc.setNode(node_type, );
		}
		
		*/
	}

}
