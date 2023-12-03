## Task
Implement cache service. Cache entries (objects) – simple custom class with one String field. Your cache service should have 2 methods: get and put.

Your cache service should fit next requirements:
- Max Size = 100000
- Eviction policy
- Time-based on last access (5 seconds)
- Removal listener
- Just add to log of removed entry
- Give statistic to user
- Average time spent for putting new values into cache
- Number of cache evictions
- Support concurrency

This task should be implemented in two ways:
Simple Java (Strategy: LFU)
Guava (Strategy: LRU)