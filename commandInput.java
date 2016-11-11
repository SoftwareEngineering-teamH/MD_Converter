import java.io.*;

public class commandInput {

	public static void main(String[] args) throws IOException
	{
		if(args[0].equals("-exit"))
		{
			System.out.println("bye!");
		}
		else if(args[0].equals("-help"))
		{
			System.out.println("\n\t◈ Help option"); 
			System.out.println("\n\t=========================================================================================================="); 
			 System.out.println("\t※Input format: <Command_type> <operation_type> <file_name>.....<file_name>\n"); 
			 System.out.println("\t\t▶ <Command_type>\texit : You can close the program."
			 		+ "\n\t\t\t\t\tread : You can insert a file to be converted(must be \".md\" file)."
			 		+ "\n\t\t\t\t\t-help : You can use help option.\n"); 
			 System.out.println("\t\t▶ <operation_type>: There are three type of operating option [-slide][-fancy][-plain].\n"); 
			 System.out.println("\t\t▶ <file_name>: File format is mandatory to be a \".md\".\n"
					+ "\t\t\t\tYou can insert multiple files.\n"); 
			 System.out.println("\t=========================================================================================================="); 
		}
		else if(args[0].equals("read"))
		{
			if(args[1].equals("-slide"))
			{
				System.out.println("\n◎ "+(args.length-2)+" read was executed.\n");
				try {
					File[] file = new File[(args.length)-2];
						for(int i = 0; i<(args.length)-2; i++)
						{
							if(!args[i+2].endsWith(".md"))
							{
								System.out.println("\n [ERROR: File Format error]: File <"+ args[i+2]+"> is not \".md\" file format.\n");
							}
							else
							{
								file[i] = new File(args[i+2]);
								if (!file[i].isFile())
								{
									System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[i+2]+">is out of existence.");
								}
								else
								{
									BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[i+2].replace(".md","_slide") +".html"));
								
									if (null != bufferedWriter)
									System.out.println("\n ★[Successfully converted]: File <"+ args[i+2]+">was converted to File <"+args[i+2].replace(".md","_slide") +".html"+">★\n\n"); 
									bufferedWriter.close();
								}
							}
						}
				}catch(FileNotFoundException e){
					System.out.println(" [ERROR: File Not Founded]: No exist file.");
					e.printStackTrace();
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Array index out of bound.");
				}
			}
			else if(args[1].equals("-fancy"))
			{
				System.out.println("\n◎ "+(args.length-2)+" read was executed.\n");
				try {
					File[] file = new File[(args.length)-2];
						for(int i = 0; i<(args.length)-2; i++)
						{
							if(!args[i+2].endsWith(".md"))
							{
								System.out.println("\n [ERROR: File Format error]: File <"+ args[i+2]+"> is not \".md\" file format.\n");
							}
							else
							{
								file[i] = new File(args[i+2]);
								if (!file[i].isFile())
								{
									System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[i+2]+">is out of existence.");
								}
								else
								{
									BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[i+2].replace(".md","_fancy") +".html"));
								
									if (null != bufferedWriter)
									System.out.println("\n ★[Successfully converted]: File <"+ args[i+2]+">was converted to File <"+args[i+2].replace(".md","_fancy") +".html"+">★\n\n"); 
									bufferedWriter.close();
								}
							}
						}
				}catch(FileNotFoundException e){
					System.out.println(" [ERROR: File Not Founded]: No exist file.");
					e.printStackTrace();
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Array index out of bound.");
				}
			}
			else if(args[1].equals("-plain"))
			{
				System.out.println("\n◎ "+(args.length-2)+" read was executed.\n");
				try {
					File[] file = new File[(args.length)-2];
						for(int i = 0; i<(args.length)-2; i++)
						{
							if(!args[i+2].endsWith(".md"))
							{
								System.out.println("\n [ERROR: File Format error]: File <"+ args[i+2]+"> is not \".md\" file format.\n");
							}
							else
							{
								file[i] = new File(args[i+2]);
								if (!file[i].isFile())
								{
									System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[i+2]+">is out of existence.");
								}
								else
								{
									BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[i+2].replace(".md","_plain") +".html"));
								
									if (null != bufferedWriter)
									System.out.println("\n ★[Successfully converted]: File <"+ args[i+2]+">was converted to File <"+args[i+2].replace(".md","_plain") +".html"+">★\n\n"); 
									bufferedWriter.close();
								}
							}
						}
				}catch(FileNotFoundException e){
					System.out.println(" [ERROR: File Not Founded]: No exist file.");
					e.printStackTrace();
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Array index out of bound.");
				}
			}
			else
			{
				System.out.println("[Type error]: 존재하지 않는 작업 타입입니다.");
			}
		}
		else{
			System.out.println("[Command error]: 존재하지 않는 작업 명령어입니다.");
		}
	}
}
