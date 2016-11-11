# CommandInput.java
CommandInput.java is a java program to convert a markdown file into a html file.
Before you run this file, you should compile this java file.

See [javac](https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/tooldocs/win32/javac.html) for instructions on how to compile java programs.


## Synopsis
```
$ java CommandInput [-options]
```


## Options
* **-read**  [_filename(markdown)_]  [_type_]  
Read a markdown file and convert into a html file. There are three different types: plain(default), slide, and fancy.

For example, to run this program named CommandInput.java to convert README.md into README.html, use this command:
```
$ java CommandInput -read README.md slide
```

* **-help**  
Print options and usage.
```
$ java CommandInput -help
```

* **-exit**  
Terminate the this program.
```
$ java CommandInput -exit
```

