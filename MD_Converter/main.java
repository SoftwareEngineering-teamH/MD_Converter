import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class main {
	public static void main(String[] args) throws IOException
	{
		String test_buff = new String("a*b*c ![Alt id](/path)*abc*a");
		int[] test_check_buff = {1,2,1,22,1,1,5,5,1,1,1,1,1,1,55,555,1,1,1,1,1,5555,2,1,1,1,22,1,0};
		
		CodeGenerator test = new CodeGenerator(3, test_buff, test_check_buff);
		
		test.Convertor();
	}
}
