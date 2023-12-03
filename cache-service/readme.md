### Description
This PR contains cache service implementations using 2 strategies:\
Java LFU\
Guava LRU

### Instruction
From the `cache-service` directory:
1. `> mvn clean package` to package a project
2. `> java -jar java-lfu/target/java-lfu-0.0.1.jar`* to run Java LFU service
3. `> java -jar guava-lru/target/guava-lru-0.0.1.jar`* to run Java LRU service\
\* can be launched with optional parameters, e.g. `> java -jar java-lfu/target/java-lfu-0.0.1.jar 10 60000 10000`\
where `10` is the maximum number of items in cache, `60000` is the eviction time in ms, `10000` is the eviction period in ms.

Service accepts the following commands in the terminal:\
`put` \<number\> or <key, value> (put \<number\> entries into cache or put <key, value> into cache)\
`get` \<key\> (get value for \<key\>)\
`stats` (print cache statistics)\
`exit` (exit the application)\
`help` (show available commands)

### Screenshots
`> help`\
![Screenshot_2023-12-03_at_17.01.38](/uploads/55f88dbf6438c90301ba3cf29aa6a38f/Screenshot_2023-12-03_at_17.01.38.png)

Java LFU:\
`> put 10` put 10 items in cache:\
![Screenshot_2023-12-03_at_17.02.25](/uploads/e242ddd7c0687187cbc99b5992e2a553/Screenshot_2023-12-03_at_17.02.25.png)

after 5 seconds items are automatically evicted:\
![Screenshot_2023-12-03_at_17.02.43](/uploads/d8482a97b1936317297b54820cd3599f/Screenshot_2023-12-03_at_17.02.43.png)

if one of the items was requested, it's eviction period starts from the beginning:\
![Screenshot_2023-12-03_at_17.23.40](/uploads/ff79a59a477a2230126b13a1e8b5d3e3/Screenshot_2023-12-03_at_17.23.40.png)

`> java -jar java-lfu/target/java-lfu-0.0.1.jar 5 60000 10000` to check LFU eviction strategy:
1. add 5 items to the cache.
2. get 1,2,3,5 items, 4th item is the least recently used now.
3. put a new item.
4. since the 4th item is the least recently used, it is evicted.

![Screenshot_2023-12-03_at_19.35.58](/uploads/bde5fdb079bbdcc96de08e9016cd0af2/Screenshot_2023-12-03_at_19.35.58.png)

`> stats` to check statistics
![Screenshot_2023-12-03_at_19.41.12](/uploads/0657ff14c3f14dfc35a9c0baed5c0edc/Screenshot_2023-12-03_at_19.41.12.png)

Guava LRU:\
`> java -jar guava-lru/target/guava-lru-0.0.1.jar 5 60000` to check LFU eviction strategy:
1. add 5 items to the cache.
2. get 1st item several times, now it's the most frequently accessed item.
3. get items 2,3,4,5 one time, now the 1st is the least recently accessed item.
4. add an item to the cache, the **1st** item is removed as the least recently used at the moment.
5. add an item to the cache, the **2nd** item is removed as the least recently used at the moment.

![Screenshot_2023-12-03_at_20.07.33](/uploads/8cbd7d35dec562dee4a0127fd664669b/Screenshot_2023-12-03_at_20.07.33.png)

`> stats` to check statistics
![Screenshot_2023-12-03_at_20.11.20](/uploads/9ad467aa1773d9abcf5fec15bed7abfa/Screenshot_2023-12-03_at_20.11.20.png)

### Test coverage
`> mvn clean test` command will run tests and collect coverage.\
Test coverage can be found at `(java-lfu|guava-lru)/target/coverage/index.html`.

Java LFU:
![Screenshot_2023-12-02_at_21.56.15](/uploads/f50a8946669f098d88d0b7bcb482a3c3/Screenshot_2023-12-02_at_21.56.15.png)
Guava LRU:
![Screenshot_2023-12-02_at_21.56.24](/uploads/39077a4f10ff17f4ee0500d7d39a47ae/Screenshot_2023-12-02_at_21.56.24.png)