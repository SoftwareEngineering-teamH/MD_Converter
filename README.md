## See javac
See [javac](https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/tooldocs/win32/javac.html) for instructions on how to compile java programs.


## Synopsis
You can execute this program with several files. You should follow the instruction as below:
```
$ ant
```
build.xml 파일 디렉토리에서 ant를 실행하면 jar file과 Junit과 jacoco를 이용하여 테스트한 결과를 html로 생성한다.
빌드 폴더 안에, md2html.jar 파일이 생긴다.
report 폴더 안에, index.html 파일이 생긴다.
index.html 파일을 보면 코드의 test coverage를 시각화 하여 나타낸다.
build 폴더로 가서, md2html.jar 파일을 실행하여 md 파일을 html 파일로 바꿀 수 잇다.
커맨드 창에서
```
$ java -jar md2html.jar [-option] [-type] [file name] 
```
그러면 output.html 파일이 생긴다~~

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

