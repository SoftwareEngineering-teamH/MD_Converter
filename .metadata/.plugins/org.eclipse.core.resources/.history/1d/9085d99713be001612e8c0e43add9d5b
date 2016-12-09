package MD2HTML;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class mainTest {

   @Test
   public void testMain() throws IOException {
      String[] args = new String[3];
      //exit
      args[0] = "-exit";
      main Main = new main();
      Main.main(args);
      //help
      args[0] = "-help";
      Main.main(args);
      
      //read_slide_md
      args[0] = "-read";
      args[1] = "-slide";
      args[2] = "test.md";
      Main.main(args);
      //read_slide_txt
      args[0] = "-read";
      args[1] = "-slide";
      args[2] = "test.txt";
      Main.main(args);
      //read_slide_error
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "error.md";
      Main.main(args);
      
      //read_fancy_md
      args[0] = "-read";
      args[1] = "-fancy";
      args[2] = "test.md";
      Main.main(args);
      //read_fancy_txt
      args[0] = "-read";
      args[1] = "-fancy";
      args[2] = "test.txt";
      Main.main(args);
      //read_fancy_error
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "error.md";
      Main.main(args);
      
      //read_plain_md
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      //read_plain_md
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "error.md";
      Main.main(args);
      //read_plain_txt
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.txt";
      Main.main(args);
      
      
      //read_plain_error
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "error.md";
      Main.main(args);
      
      //read_default_md
      args[0] = "-read";
      args[1] = "test.md";
      Main.main(args);
      //read_default_error
      args[0] = "-read";
      args[1] = "error.md";
      Main.main(args);
      //args[1] = "-slide";
      //Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "abc *abc* **abc** _abc_ __abc__ *ab*";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "abc *abc* **abc** _abc_ __abc__ *ab***";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "\\\" \\* < a<b & ";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "    < > &amp;";
      Main.main(args);
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "****** **\\[*";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "[id](http://hi.kr/ \"title\") dd";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "[id](http://hi.kr/)";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "![Alt g](path/ \"title\")";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.data1 = "![Alt g](path/)";
      Main.main(args);
      
   }

}