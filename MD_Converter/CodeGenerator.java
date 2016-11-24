//import visitors.Visitor;
import java.io.*;
import java.util.ArrayList;

public class CodeGenerator {

	int nodeType;
	String buffer = new String();
	int Token_buffer[];
	
	//Node type
	static int Header = 1;
	static int CodeBlock = 2;
	static int QuotedBlock = 3;
	static int ItemList = 4;
	static int TEXT = 5;
	
	//Token type
	static int Plain = 1;
	static int Style = 2;
	static int Escape = 3;
	static int Link = 4;
	static int Image = 5;
	static int HTML = 6;
	//parameter Node node
	/*public CodeGenerator(Node node){
		this.nodeType = node.nodeType;
		this.buffer = node.buffer;
		this.Token_buffer = node.check_buffer;
	}*/
	public CodeGenerator(int nodeType, String buffer, int[] check_buffer){
		this.nodeType = nodeType;
		this.buffer = buffer;
		this.Token_buffer = check_buffer;
	}
	
	@SuppressWarnings("null")
	public void Convertor() throws IOException{
		String filename = "HTML.txt";
		String content = new String();
		String tmp_id = null;
		String tmp_str = new String();
		String image_Path = new String();
		char[]tmp = buffer.toCharArray();
		ArrayList<Character>plain = new ArrayList<Character>();
		//char[] plain = new char[buffer.length()];
		boolean style_flag = false;
		boolean plain_flag = false;
		boolean link_flag = false;
		boolean img_flag = false;

		switch(nodeType){
		//header
		case 1 :
			//header type 1
			//if(header_type == 1)
			content = "<h1>";
			
			tmp_str = translate(link_flag, img_flag,plain,content,tmp_id,image_Path);

			//if(header_type == 1)
				//writeOutput(filename,"<\\h1>");		
			content = tmp_str.concat("</h1>");
			
			writeOutput(filename, content);
			
			break;
			//codeBlock
		case 2 :
			content = "<pre><code>";
			
			tmp_str = translate(link_flag, img_flag,plain,content,tmp_id,image_Path);

			//if(header_type == 1)
				//writeOutput(filename,"<\\h1>");		
			content = tmp_str.concat("</code></pre>");
			
			writeOutput(filename, content);
			
			break;
			//quotedBlock
		case 3 :
			content = "> ";
			tmp_str = translate(link_flag, img_flag,plain,content,tmp_id,image_Path);
			writeOutput(filename, tmp_str);
			break;
			//ItemList
		case 4 :
			
			break;	
			
			//TEXT
		case 5 :
			content = "<br>";		
			tmp_str = translate(link_flag, img_flag,plain,content,tmp_id,image_Path);	
			content = tmp_str.concat("</br>");			
			writeOutput(filename, content);
			break;
		}
		
		
	}
	public String translate(boolean link_flag, boolean img_flag,ArrayList<Character>plain,
			String content,String tmp_id,String image_Path){
		for(int i=0; Token_buffer[i] != 0 ;i++){
			
			//for link or img 링크과 이미지코드 변환할 때 루프를 돌게하기위해서
			if(link_flag == true || img_flag == true){
				
				char c  = this.buffer.charAt(i);
				plain.add(c);
			}else{
				//plain일때
				if(Token_buffer[i] == 1 ) {
					
					char c = this.buffer.charAt(i);
					plain.add(c);

				}else if(Token_buffer[i] != 1 ){
					//1이 끝나면 string으로 만들어서 이어붙이기
					
					String str = getStringRepresentation(plain);
					content=content.concat(str);
					plain = new ArrayList<Character>();
					//plain = null;
					
				}
				//Style일때
				if(Token_buffer[i] == 2 && Token_buffer[i+1] == 2){
					content = content.concat("<strong>");
					i++;
				}else if(Token_buffer[i] == 2 && Token_buffer[i+1] != 2){
					content = content.concat("<em>");
				}else if(Token_buffer[i] == 22 && Token_buffer[i+1] == 22 ){
					content = content.concat("</strong>");
					i++;
				}else if(Token_buffer[i] == 22 && Token_buffer[i+1] != 22){
					content = content.concat("</em>");
				}
				
			}
			//escape
			if(Token_buffer[i] == 3){
				
			}
			
			//link
			if(Token_buffer[i] == 4){
				link_flag = true;
				
				
			}else if(Token_buffer[i] == 44){
				link_flag = false;
				plain.remove(plain.size()-1);
				String id = getStringRepresentation(plain);
				tmp_id = id;
				plain = new ArrayList<Character>();
			}
			else if(Token_buffer[i] == 444) {
				link_flag = true;
			}else if(Token_buffer[i] == 4444){
				//1이 끝나면 string으로 만들어서 이어붙이기
				link_flag = false;
				String link = getStringRepresentation(plain);
				plain = new ArrayList<Character>();
				String s[] = link.split(" ");
				String str = "<a herf=\"" + s[0] + "\" title=" + s[1] + ">" + tmp_id+"</a>"; 
				content=content.concat(str);
			}
			//image
			if(Token_buffer[i] == 5){
				img_flag = true;
			}else if(Token_buffer[i] == 55){
				img_flag = false;
				plain.remove(plain.size()-1);
				String Alt = getStringRepresentation(plain);
				String s[] = Alt.split(" ");
				tmp_id = s[1];
				plain = new ArrayList<Character>();
			}else if(Token_buffer[i] == 555){
				img_flag = true;
			}else if(Token_buffer[i] == 5555){
				img_flag = false;
				String img = getStringRepresentation(plain);
				//String img = new String(plain);
				plain = new ArrayList<Character>();
				String a = " ";
				if(img.contains(a)==true){
					String s[] = img.split(" ");
					image_Path = s[0];
					String str = "<img src=\"" + image_Path + "\" title=" + s[1] + "alt="+tmp_id + ">"; 
					content=content.concat(str);
				}else{
					String str = "<img src=\"" + img + "alt="+tmp_id + ">"; 
					content=content.concat(str);
				}
				
				
			}
			//html code
			if(Token_buffer[i] == 6){
				
			}
	
		}
		
		String str = getStringRepresentation(plain);
		//String str = new String(plain);
		content=content.concat(str);
		plain = new ArrayList<Character>();
		
		return content;
	}
	
	//char Arraylist --> string
	public String getStringRepresentation(ArrayList<Character> list)
	{    
	    StringBuilder builder = new StringBuilder(list.size());
	    for(Character ch: list)
	    {
	        builder.append(ch);
	    }
	    return builder.toString();
	}
	//txt에 쓰기
	public void writeOutput(String fileName, String content) throws IOException{
		 // TODO Auto-generated method stub
        //String content = "파일쓰기 생성 내용";
       // String fileName = "C:/aaa.txt";
        File file = new File(fileName);
      //파일 크기가 0일때 새로 생성
        if(fileName.length()==0)
        {
               try
               {
                      FileWriter file_writer = new FileWriter(file);
                      BufferedWriter buff_writer = new BufferedWriter(file_writer);
                      PrintWriter print_writer = new PrintWriter(buff_writer,true);
                      print_writer.println(content);
                     
                      if(print_writer.checkError())
                      {
                            System.out.println("print_writer error!!");
                      }
                     
                      file.createNewFile();
                     
                      System.out.println("파일 생성 성공~ㅋ");
               }
               catch (Exception e) {
                      // TODO: handle exception
                      System.out.println("IO Exceiption!");
                      e.printStackTrace();
               }
        }
        else   //이어쓰기
        {
               BufferedWriter buff_writer = new BufferedWriter(new FileWriter(file, true));
               PrintWriter print_writer = new PrintWriter(buff_writer,true);
               print_writer.println(content);
              
               if(print_writer.checkError())
               {
                      System.out.println("print_writer error!!");
               }
               System.out.println("이어쓰기 성공?!ㅋ");
        }


	}
}
	
/*	public void accept(Visitor v){
		v.visit(this);
	}
	
}*/
