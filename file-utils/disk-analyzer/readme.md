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
`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 1 f`\
<img width="600" alt="Screenshot 2023-12-08 at 16 15 02" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/0bd4abbb-d241-42bd-82a2-0165449758f0">

`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 2`\
<img width="600" alt="Screenshot 2023-12-08 at 16 22 51" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/39e4f21d-81c0-4a1f-b94a-607ae85b628a">

`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 3`\
<img width="600" alt="Screenshot 2023-12-08 at 16 24 45" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/7af18ab4-bd5a-47f3-8080-f04360f2325a">

`> java -jar disk-analyzer/target/disk-analyzer-0.0.1.jar /Users/Mikalai_Sokarau/Desktop/projects 4`\
<img width="600" alt="Screenshot 2023-12-08 at 16 26 38" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/02e51b0d-49e1-40cc-8b6e-a491f6cb4eec">
