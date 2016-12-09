# commandInput.java
CommandInput.java is a java program to convert a markdown file into a html file.
Before you run this file, you should compile this java file.

See [javac](https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/tooldocs/win32/javac.html) for instructions on how to compile java programs.


## Synopsis
You can execute this program with several files. You should follow the instruction as below:
```
$ ant
```
ant 하면, jar 파일이 만들어 지고, Jacoco테스트 결과가 report 폴더 아래에 index.html파일로 저장된다.
```
If you do not insert any [-type option], inserting file lists after [-command] like below, the program would convert files to plain type automatically.
```
$ java commandInput [-command] [file1] [file2] ...
```
You should obey this two rules.


## Options
* **-read** [_type_] [_filename(markdown)_]   
Read a markdown file and convert into a html file. There are three different types: -plain(default), -slide, and -fancy.

For example, to run this program named CommandInput.java to convert README.md into README.html, use this command:
```
$ java commandInput -read -slide README.md 
```

* **-help**  
Print options and usage.
```
$ java commandInput -help
```

* **-exit**  
Terminate the this program.
```
$ java commandInput -exit
```

