
public class MDParser 
{
	//parsing method
	public void parsing(String data, String type, Document doc)
	{
		doc.md_data = data;
		
		// parsing algorithm
		doc.buffer1 = doc.getLine(data);
		
	}

}
