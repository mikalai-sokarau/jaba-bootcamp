### Description
Serialization app shows the ability to serialize / deserialize a hierarchy of objects.
All numerical fields are excluded from serialization.

App creates several instances of various classes and shows the serialization and deserialization operations.

### Used tools
* Java 8+
* Maven 3.9.5

### Instruction
From the `file-utils` directory:
1. `> mvn clean package` to package the project
2. `> java -jar serializer/target/serializer-0.0.1.jar (serialize|deserealize)` to run the app

### Screenshots
`> mvn clean package`\
<img width="400" alt="Screenshot 2023-12-08 at 10 02 06" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/76104c65-3fad-48d5-a0ce-6a114130232a">

`java -jar serializer/target/serializer-0.0.1.jar serialize`\
<img width="400" alt="Screenshot 2023-12-08 at 09 59 59" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/3af326bb-98e2-413b-8341-2580a4833d45">

`java -jar serializer/target/serializer-0.0.1.jar deserialize`\
<img width="400" alt="Screenshot 2023-12-08 at 10 00 11" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/13159a2e-976f-4cfc-b9a1-3e3ef30650c5">
