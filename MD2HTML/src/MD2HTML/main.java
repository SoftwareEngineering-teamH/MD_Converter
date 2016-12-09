package MD2HTML;

import java.io.*;
import java.util.Scanner;
//import org.w3c.tidy.Tidy;

public class main 
{
	public static void main(String[] args) throws IOException
	{
		String data = ""; 
		String type = "";
		
		try
		{
			if(args[0].equals("-exit"))
			{
				System.out.println("bye!");
			}
			else if(args[0].equals("-help"))
	        {
				System.out.println("\n\t Help option"); 
				System.out.println("\n\t=========================================================================================================="); 
				System.out.println("\t nput format: <Command_type> <operation_type> <file_name>.....<file_name>\n"); 
				System.out.println("\t\t <Command_type>\texit : You can close the program."
						+ "\n\t\t\t\t\tread : You can insert a file to be converted(must be \".md\" file)."
						+ "\n\t\t\t\t\t-help : You can use help option.\n"); 
				System.out.println("\t\t  <operation_type>: There are three type of operating option [-slide][-fancy][-plain].\n"); 
				System.out.println("\t\t  <file_name>: File format is mandatory to be a \".md\".\n"
						+ "\t\t\t\tYou can insert multiple files.\n"); 
				System.out.println("\t=========================================================================================================="); 
	        }
			else if(args[0].equals("-read"))
			{
				if(args[1].equals("-slide"))
				{
					try
						{
							File file = new File(args[2]);
							if(!args[2].endsWith(".md"))
							{
								System.out.println("\n [ERROR: File Format error]: File <"+ args[2]+"> is not \".md\" file format.\n");
							}
							else
							{
								file = new File(args[2]);
								if (!file.isFile())
								{
									System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[2]+">is out of existence.");
								}
								else
								{
									Scanner sc = new Scanner(file);
									while(sc.hasNext()) 
									{
										data += sc.nextLine();
										data += "\n";
									}
	                              
									type += "slide";
	                              
									System.out.println("\n [Successfully converted]: File <"+ args[2]+">was converted to File <"+args[2].replace(".md","_slide") +".html"+">\n\n"); 
								}
							}
						}
					catch(FileNotFoundException e)
					{
						System.out.println(" [ERROR: File Not Founded]: No exist file.");
						e.printStackTrace();
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Array index out of bound.");
					}
	            }
	            else if(args[1].equals("-fancy"))
	            {
	            	System.out.println("\n  "+(args[2])+" read was executed.\n");
	            	try
	            	{
	            		File file = new File(args[2]);
	            		if(!args[2].endsWith(".md"))
	            		{
	            			System.out.println("\n [ERROR: File Format error]: File <"+ args[2]+"> is not \".md\" file format.\n");
	            		}
	            		else
	            		{
	            			file = new File(args[2]);
	            			if (!file.isFile())
	            			{
	            				System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[2]+">is out of existence.");
	            			}
	            			else
	            			{
	            				Scanner sc = new Scanner(file);
	            				while(sc.hasNext()) 
	            				{
	            					data += sc.nextLine();
	            					data += "\n";
	            				}
	            				type += "fancy";
	                                
	            				System.out.println("\n  [Successfully converted]: File <"+ args[2]+">was converted to File <"+args[2].replace(".md","_fancy") +".html"+">\n\n"); 
	            			}
	            		}
	               }
	               catch(FileNotFoundException e)
	               {
	            	   System.out.println(" [ERROR: File Not Founded]: No exist file.");
	            	   e.printStackTrace();
	               }
	               catch(ArrayIndexOutOfBoundsException e)
	               {
	            	   System.out.println("Array index out of bound.");
	               }
	            }
	            else if(args[1].equals("-plain"))
	            {
	            	System.out.println("\n  "+(args[2])+" read was executed.\n");
	            	try 
	            	{
	            		File file = new File(args[2]);
	                    for(int i = 0; i<(args.length)-2; i++)
	                    {
	                    	if(!args[2].endsWith(".md"))
	                        {
	                    		System.out.println("\n [ERROR: File Format error]: File <"+ args[2]+"> is not \".md\" file format.\n");
	                        }
	                        else
	                        {
	                        	file = new File(args[2]);
	                        	if (!file.isFile())
	                        	{
	                        		System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[2]+">is out of existence.");
	                        	}
	                        	else
	                        	{   
	                        		Scanner sc = new Scanner(file);
	                        		while(sc.hasNext()) 
	                        		{
	                        			data += sc.nextLine();
	                        			data += "\n";
	                        		}
	                        		type += "plain";
	                               
	                        		System.out.println("\n [Successfully converted]: File <"+ args[2]+">was converted to File <"+args[2].replace(".md","_plain") +".html"+">\n\n");
	                           }
	                        }
	                     }
	            	}
	            	catch(FileNotFoundException e)
	            	{
	            		System.out.println(" [ERROR: File Not Founded]: No exist file.");
	            		e.printStackTrace();
	            	}
	            	catch(ArrayIndexOutOfBoundsException e)
	            	{
	            		System.out.println("Array index out of bound.");
	            	}
	            }
	            else
	            {
	            	try 
	            	{
	            		File file = new File(args[1]);
	                    for(int i = 0; i<(args.length)-1; i++)
	                    {
	                    	if(!args[1].endsWith(".md"))
	                        {
	                    		System.out.println("\n [ERROR: File Format error]: File <"+ args[1]+"> is not \".md\" file format.\n");
	                        }
	                        else
	                        {
	                        	file = new File(args[1]);
	                        	if (!file.isFile())
	                        	{
	                        		System.out.println(" [ERROR: File Not Founded]: "+"<"+ args[1]+">is out of existence.");
	                        	}
	                        	else
	                        	{
	                        		Scanner sc = new Scanner(file);
	                        		while(sc.hasNext()) 
	                        		{
	                        			data += sc.nextLine();
	                                    data += "\n";
	                        		}
	                        		type += "plain";
	                               
	                        		System.out.println("\n [Successfully converted]: File <"+ args[2]+">was converted to File <"+args[2].replace(".md","_plain") +".html"+">\n\n");
	                           }
	                        }
	                     }
	            	}
	            	catch(FileNotFoundException e)
	            	{
	            		System.out.println(" [ERROR: File Not Founded]: No exist file.");
	            		e.printStackTrace();
	            	}
	            	catch(ArrayIndexOutOfBoundsException e)
	            	{
	            		System.out.println("Array index out of bound.");
	            	}
	           	}
	         }
	         else
	         {
	            System.out.println("[Command error]: No existed command");
	         }
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("[Command error]: No command was inserted");
		}
		
		// Document Object make.
		Document doc = new Document();
		
		// MDParser Object make.
		MDParser pars = new MDParser();
		
		// Parsing() >> In Document Object  node_list save
		pars.parsing(data, doc);
		
		// Document Object.accept((type)Visitor) 
		switch (type)
		{
		case "plain" : 
			doc.accept(new PlainVisitor());
			break;
		case "slide" : 
			doc.accept(new SlideVisitor());
			break;
		default	:  
			doc.accept(new FancyVisitor());
			break;
		}
	    
		// html error test
		
		/*
		Tidy tidy = new Tidy();
   		InputStream stream = new ByteArrayInputStream(doc.html_data.getBytes());
   		tidy.parse(stream, System.out);
   		
   		if (tidy.getParseErrors() != 0 )
   			System.out.println("error exist");
   		else if (tidy.getParseErrors() == 0)
   			System.out.println("No error");
		*/
		
		// Document Object.htmlData >> file output
		
   		
		//doc.html_data test 
		System.out.println(doc.html_data);
		
		//end

	}
}

