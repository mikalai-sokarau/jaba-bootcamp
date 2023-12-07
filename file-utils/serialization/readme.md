### Description
Serialization app shows the ability to serialize / deserialize a hierarchy of objects.
All numerical fields are excluded from serialization.

App creates several instances of various classes and shows the serialization and deserialization operations.

### Used tools
* Java 8+
* Maven 3.9.5

### Instruction
From the `file-utils` directory:
1. `> mvn clean package` to package a project
2. `> java -jar serialization/target/serialization-0.0.1.jar (serialize|deserealize)` to run the app

### Screenshots
`> mvn clean package`\
<img width="400" alt="Screenshot 2023-12-07 at 18 54 55" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/2e4be054-8704-4a0a-9316-2b12dc5fc079">

`java -jar serialization/target/serialization-0.0.1.jar serialize`\
<img width="400" alt="Screenshot 2023-12-07 at 18 55 53" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/7c2520af-17d1-4982-89d6-72fd292116c5">

`java -jar serialization/target/serialization-0.0.1.jar deserialize`\
<img width="400" alt="Screenshot 2023-12-07 at 18 57 21" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/29c4c168-78c2-48e0-bf40-cb34952a341d">

