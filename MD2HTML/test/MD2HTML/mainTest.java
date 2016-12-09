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
      
      args[0] = "-read";
      args[1] = "-slide";
      args[2] = "a.md";
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
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
      args[0] = "-read";
      args[1] = "-plain";
      args[2] = "test.md";
      Main.main(args);
      
   }

}