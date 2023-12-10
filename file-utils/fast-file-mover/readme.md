### Description
FastFileMover utility moves a file from one directory to another.
There are four implementations of the utility using different approaches:
1. FileStreams
2. FileStreams with buffer 100 kb
3. FileChannel
4. NIO 2 File API

After moving a file a performance report is printed to the console. Each file is moved 100 times.
The report contains the following information:
1. Total time spent on moving the file
2. Average time spent on moving the file
3. Number of iterations

### Tools
1. Java 8+
2. Maven 3.6.5

### Instructions
`> mvn clean package` to build the project
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 (1kb|100kb|10mb|1gb)` to create a file of the required size.
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar methodNumber inputFile outputFile` to move a file from one directory to another, where:
* methodNumber - number of the method to use for moving the file
  1. FileStreams
  2. FileStreams with buffer 100 kb
  3. FileChannel
  4. NIO 2 File API
* inputFile - path to the file to move
* outputFile - path to the directory to move the file to

### Screenshots
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 1kb`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 100kb`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 10mb`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 1gb`\

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 2 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 2 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 2 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 2 fast-file-mover/target/move-from/1gb.txt fast-file-mover/target/move-to/1gb_moved.txt`\

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/1gb.txt fast-file-mover/target/move-to/1gb_moved.txt`\

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/1gb.txt fast-file-mover/target/move-to/1gb_moved.txt`\

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/1gb.txt fast-file-mover/target/move-to/1gb_moved.txt`\

### Results