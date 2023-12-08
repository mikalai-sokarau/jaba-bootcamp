### Description
DiskAnalyzer command line utility allows to analyze disk space usage and find files with specific name or extension:

* Search for the file name with the maximum number of requested letters in the name, display the path to it.
* Search for the top 5 largest files (by size in MB).
* Calculate the average file size in the specified directory and its subdirectories.
* Calculate the number of files and folders, divided by the first letters of the alphabet.

Output is printed to the console and stored to the disk-analyzer/target/diskAnalyzerOutput.txt file.

### Tools
* Java 8+
* Maven 3.6.5

### Instructions

From the `file-utils` directory:
1. `> mvn clean package` to package the project
2. `> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar` to run the application

### Screenshots
`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 1 f`



`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 2`



`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 3`



`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 4`