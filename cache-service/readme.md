### Description
Cache service implementations using 2 strategies:\
`LFU` written using plain Java\
`LRU` written using Guava library

### Used tools
* Java 17
* Maven 3.9.5
* Google Guava 32.1.3-jre
* JUnit 4.11
* JaCoCo 0.8.11

### Instruction
From the `cache-service` directory:
1. `> mvn clean package` to package a project
2. `> java -jar java-lfu/target/java-lfu-0.0.1.jar`* to run Java LFU service
3. `> java -jar guava-lru/target/guava-lru-0.0.1.jar`* to run Guava LRU service\
\* can be launched with optional parameters, e.g. `> java -jar java-lfu/target/java-lfu-0.0.1.jar 10 60000 10000`\
where `10` is the maximum number of items in cache, `60000` is the eviction time in ms, `10000` is the eviction period in ms.

Service accepts the following commands in the terminal:\
`put` \<number\> or <key, value> (put \<number\> entries into cache or put <key, value> into cache)\
`get` \<key\> (get value for \<key\>)\
`stats` (print cache statistics)\
`help` (show available commands)
`exit` (exit the application)\


### Screenshots
`> help`\
<img width="400" alt="Screenshot 2023-12-03 at 20 34 41" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/6ca8f6d2-4a40-42e5-837e-8f7adcd784b7">


### Java LFU:
`> put 10` put 10 items in cache:\
<img width="400" alt="Screenshot 2023-12-03 at 17 02 25" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/d3d58b49-739f-4cee-a707-8302ea81dacf">

after 5 seconds items are automatically evicted:\
<img width="400" alt="Screenshot 2023-12-03 at 17 02 43" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/9017b975-c15a-474f-8617-461d7a17b2bf">

if one of the items was requested, it's eviction period starts from the beginning:\
<img width="400" alt="Screenshot 2023-12-03 at 17 23 40" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/8af13f0f-4ad8-4d47-96b3-9d54b417f106">

`> java -jar java-lfu/target/java-lfu-0.0.1.jar 5 60000 10000` to check LFU eviction strategy:
1. add 5 items to the cache.
2. get 1,2,3,5 items, 4th item is the least recently used now.
3. put a new item.
4. since the 4th item is the least recently used, it is evicted.

<img width="400" alt="Screenshot 2023-12-03 at 19 35 58" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/3a9c0743-cc89-437e-9360-dc3c6b200c69">

`> stats` to check statistics\
<img width="400" alt="Screenshot 2023-12-03 at 19 41 12" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/7da62fe9-c7ba-45d6-bb81-fe18d981b876">

### Guava LRU:
`> java -jar guava-lru/target/guava-lru-0.0.1.jar 5 60000` to check LFU eviction strategy:
1. add 5 items to the cache.
2. get 1st item several times, now it's the most frequently accessed item.
3. get items 2,3,4,5 one time, now the 1st is the least recently accessed item.
4. add an item to the cache, the **1st** item is removed as the least recently used at the moment.
5. add an item to the cache, the **2nd** item is removed as the least recently used at the moment.

<img width="400" alt="Screenshot 2023-12-03 at 20 07 33" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/c96ffdc3-dbce-4f9e-bae8-48b3a3c6635d">

`> stats` to check statistics\
<img width="400" alt="Screenshot 2023-12-03 at 20 11 20" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/bd3a2971-0528-4ccd-b723-904d91da84ea">

### Test coverage
`> mvn clean test` command will run tests and collect coverage.\
Test coverage can be found at `(java-lfu|guava-lru)/target/coverage/index.html`.

Java LFU:\
<img width="400" alt="Screenshot 2023-12-02 at 21 56 15" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/14dcc70c-fadd-491a-af5b-5523c9dd4f3f">

Guava LRU:\
<img width="400" alt="Screenshot 2023-12-02 at 21 56 24" src="https://github.com/mikalai-sokarau/java-sandbox/assets/33463819/2ff947c4-649a-4c6f-85f6-0e5f83cf50f2">
