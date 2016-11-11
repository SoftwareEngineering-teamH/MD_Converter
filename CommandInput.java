import java.util.Scanner;
import java.io.*;

public class CommandInput {

   public static void main(String[] args) throws IOException
{
      
      if(args[0].equals("exit"))
      {
         System.out.println("bye!");
      }
      else if(args[0].equals("read"))
      { 	
    	  try{
	    	  switch(args[2])
	    	  {
	    	  case "slide": 
	    		  try {
	              File file = new File(args[1]);
	              Scanner sc = new Scanner(file);
	              while(sc.hasNext()) {
	                 System.out.println(sc.next()); 
	              }
	              BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("slide.html"));
	               
	               if (null != bufferedWriter){
	                   System.out.println("slide.html 파일이 성공적으로 생성되었습니다."); 
	               }
	               bufferedWriter.close();
	               System.out.println("result: slide!");
	               sc.close();
	    		  } catch(FileNotFoundException e){
	    			  e.printStackTrace();
	    		  }
	    		  break;
	    	  case "fancy":
	    		  try {
	                  File file = new File(args[1]);
	                  Scanner sc = new Scanner(file);
	                  while(sc.hasNext()) {
	                	  System.out.println(sc.next()); 
	                  }
	                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("fancy.html"));
	                     
	                  if (null != bufferedWriter)
	                  {
	                	  System.out.println("fancy.html 파일이 성공적으로 생성되었습니다."); 
	                  }
	                  bufferedWriter.close();
	                  System.out.println("result: fancy!");
	                  sc.close();
	              } catch(FileNotFoundException e){
	                  e.printStackTrace();
	              }
	    		  break;
	    	  case "plain":
	    		  try {
	                  File file = new File(args[1]);
	                  Scanner sc = new Scanner(file);
	                  while(sc.hasNext()) {
	                	  System.out.println(sc.next()); 
	                  }
	                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("plain.html"));
	                      
	                  if (null != bufferedWriter)
	                  {
	                	  System.out.println("plain.html 파일이 성공적으로 생성되었습니다."); 
	                  }
	                  bufferedWriter.close();
	                  System.out.println("result: plain!");
	                  sc.close();
	              } catch(FileNotFoundException e){
	                  e.printStackTrace();
	              }
	    		  break;
	    	  default:
	    		System.out.println("Type error! Please enter correct type (plain, slide, fancy)");	  
	    	  }
    	  } catch(ArrayIndexOutOfBoundsException e){	// if user didn't enter any type
    		  try {
                  File file = new File(args[1]);
                  Scanner sc = new Scanner(file);
                  while(sc.hasNext()) {
                	  System.out.println(sc.next()); 
                  }
                  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("plain.html"));
                      
                  if (null != bufferedWriter)
                  {
                	  System.out.println("plain.html 파일이 성공적으로 생성되었습니다."); 
                  }
                  bufferedWriter.close();
                  System.out.println("result: plain!");
                  sc.close();
              } catch(FileNotFoundException fe){
                  fe.printStackTrace();
              }
    	  }
      }
      else if(args[0].equals("help"))
      {
         System.out.println("\n\t◈ Help option"); 
         System.out.println("\n\t=========================================================================================================="); 
          System.out.println("\t※Input format: <Command_type> <file_name> <operation_type>\n"); 
          System.out.println("\t\t▶ <Command_type>\texit : You can close the program."
                + "\n\t\t\t\t\tread : You can insert a file to be converted."
                + "\n\t\t\t\t\thelp : You can use help option.\n"); 
          System.out.println("\t\t▶ <file_name>: File format is mandatory to be a \".md\".\n"); 
          System.out.println("\t\t▶ <operation_type>: There are three type of operating option [slide][fancy][plain]."); 
          System.out.println("\t=========================================================================================================="); 
      }
      else{
         System.out.println("command error!");
      }
       }

}