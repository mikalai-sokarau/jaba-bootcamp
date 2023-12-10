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
  * 1 (FileStreams)
  * 2 (FileStreams with buffer 100 kb)
  * 3 (FileChannel)
  * 4 (NIO 2 File API)
* inputFile - path to the file to move
* outputFile - path to the directory to move the file to

### Screenshots
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 1kb`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 100kb`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 10mb`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 1 1gb`
<img width="600" alt="Screenshot 2023-12-10 at 19 16 09" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/66059a9d-fe04-4b9e-bc00-14fab6eea3f3">
<img width="600" alt="Screenshot 2023-12-10 at 19 18 35" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/2dfa7208-6205-470c-9ea3-6ae64bc476d6">

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 2 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 2 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
<img width="600" alt="Screenshot 2023-12-10 at 19 45 14" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/c5ac0f92-2b0b-4def-a1cb-a1719b2dd335">

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 3 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
<img width="600" alt="Screenshot 2023-12-10 at 19 49 23" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/891e5eb4-5fdd-4a08-953e-7c44a83074a9">

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 4 fast-file-mover/target/move-from/1gb.txt fast-file-mover/target/move-to/1gb_moved.txt`\
<img width="600" alt="Screenshot 2023-12-10 at 19 51 15" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/81c45721-8d73-48d5-93bc-89c9445ac3b8">

`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/1kb.txt fast-file-mover/target/move-to/1kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/100kb.txt fast-file-mover/target/move-to/100kb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/10mb.txt fast-file-mover/target/move-to/10mb_moved.txt`\
`> java -jar fast-file-mover/target/fast-file-mover-0.0.1.jar 5 fast-file-mover/target/move-from/1gb.txt fast-file-mover/target/move-to/1gb_moved.txt`\
<img width="600" alt="Screenshot 2023-12-10 at 20 00 59" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/3416e593-41d1-4a2d-93e2-e8fcf25f8d23">


### Results
Data in the table is presented in the format: `average time / total time`.
|   |1kb|100kb|10mb|1gb|
|---|---|---|---|---|
|FileStreams|2ms/231ms|205ms/20574ms|~6min*/~10h*|~10h*/~42d*|
|FileStreams with buffer 100 kb|0ms/17ms|2ms/276ms|246ms/24681ms|~5min*/~8h*|
|FileChannel|0ms/26ms|0ms/29ms|5ms/544ms|335ms/33507ms|
|NIO 2 File API|0ms/23ms|0ms/31ms|5ms/585ms|349ms/34916ms|
* I didn't have the courage to run it, the numbers are approximate based on the files of smaller sizes.
