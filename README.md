## See javac
See [javac](https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/tooldocs/win32/javac.html) for instructions on how to compile java programs.


## Synopsis
You can execute this program with several files. You should follow the instruction as below:
```
$ ant
```
Once you execute ant in the file directory, a HTML file is created which is the result of testing with JUnit and JaCoCo.
In the build folder, md2html.jar file is created.
In the report folder, index.html file is created.
index.html file visualizes test coverage of the code.
In the build folder, you can convert md file to html file by executing md2html.jar.

If you input the command below to the CMD, then output.html file is created.
```
$ java -jar md2html.jar [-option] [-type] [file name] 
```

## Options
* **-read** [_type_] [_filename(markdown)_]   
Read a markdown file and convert into a html file. There are three different types: -plain(default), -slide, and -fancy.

For example, to run this program named CommandInput.java to convert README.md into README.html, use this command:
```
$ java -jar md2html.jar -read -slide README.md 
```

* **-help**  
Print options and usage.
```
$ java -jar md2html.jar -help
```

* **-exit**  
Terminate the this program.
```
$ java -jar md2html.jar -exit
```

