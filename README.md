# Redis-learning
### redis-string
- 1.set key value
- 2.get key
- 3.del key
- 4.keys * 
- 5.del key/*

### redis-integer
- 1.incr num (++)
- 2.decr num (--)
- 3.incrby num 3 (+3)
- 4.decrby num 3 (-3)
- 5.append num 3 ('num' + 3)

### redis-hashMap
- 1.hset map key value
- 2.hmset map key value key value
- 3.hget map key
- 4.hmget map key key key
- 5.hgetall map (view key & value)
- 6.hdel map key (delete by key)
- 7.del map (delete the map)
- 8.hincr map key (++)
- 9.hincrby map key 3 (+3)
- 10.hexists map key (is exists? 1:true,0:false)
- 11.hlen map (return the map's size)
- 12.hkeys map (return the map's keys)
- 13.hvals map (return the map's values)

### redis-list
- 1.lpush list value value value (push for left)
- 2.rpush list value value value (push for right)
- 3.lrange list start end (view the list)
- 4.lpop list (pop for left)
- 5.rpop list (pop for right)
- 6.llen list (return the list's size)
- 7.lpushx list value (insert for the list index 0)
- 8.rpushx list value (insert for the list index ass)
- 9.lrem list index(0:all,1:one,2:two...) value (for left remove value by index)
- 10.lindex list index (return list[index])
- 11.lset list index value (list[index]=value)
- 12.linsert list before value value (insert value before value)
- 13.linsert list after value value (inser value after value)
- 14.rpoplpush list1 list2 (pop for right list1 push right for list2)

### redis-set
- 1.sadd set value value value
- 2.srem set value value value
- 3.smembers set (view set's values)
- 4.sismember set value (is exists? 1:true,0:false)
- 5.sdiff set1 set2 (view set1 diff values for set2)
- 6.sinter set1 set2 (view set1 & set2 altogether values)
- 7.sunion set1 set2 (merge set1 & set2)
- 8.scard set (return set's size)
- 9.srandmember set (return random value for set)
- 10.sdiffstore set1 set2 set3 (add set2 diff values for set3 to set1)
- 11.sinterstore set1 set2 set3 (add set2 & set2 altogether values to set1)
- 12.sunionstore set1 set2 set3 (add merge set2 & set3 values to set1)

### redis-sorted-set
- 1.zadd sort scores value scores value
- 2.zcard sort (return sort's size)
- 3.zrem sort value value (remove)
- 4.zrang sort start end
- 5.zrang sort start end withscores (view values's scores)
- 6.zrevrange sort start end withscores (view values'scores by desc)
- 7.zremrangebyrank sort start end (remove by index)
- 8.zremrangebyscore sort scores1 scores2 (remove by scores1~scores2)
- 9.zrangebyscore sort scores1 scores2 (view sort by scores1~scores2)
- 10.zrangebyscore sort scores1 scores2 withscores limit start end (view sort by scores1~scores2 for limit start~end)
- 11.zincrby sort scores value (value's score+3)
- 12.zscore sort value (return value's score)
- 13.zcount sort scores1 scores2 (count sort by scores1~scores2)

### redis-keys
- 1.keys * (view all key)
- 2.keys my? (view all my? key)
- 3.exists key (is exists? 1:true,0:false)
- 4.rename key newkey
- 5.expire key num (set timeout num)
- 6.ttl key (view timeout num)
- 7.type key (return key's type)

### redis-databases
- 1.select index (max:16)
- 2.move key database (index)

### redis-Transaction
- 1.multi (open transaction)
- 2.do somthing...
- 3.exec:commit,discard:rollback

### redis-RDB
- 1.概念
    + 1）根据/etc/redis/redis.conf文件配置的持久化方案，进行数据持久化。
- 2.优点
    + 1）保存的是redis的快照文件，方便归档。当系统挂掉可以很快的恢复。
- 3.缺点
    + 1）因为是根据时间进行持久化操作的，若在持久化操作前之前系统挂掉，则数据就丢失了。
- 4.操作
    + 1）在conf的save下，默认 save:time(900) key(1), save:time(300) key(10)，save:time(60) key(10000)。多少秒内，多少key发生变化，就执行一次持久化。
    + 2）快照文件保存在/var/lib/redis/dump.rbd中。

### redis-AOF
- 1.概念
    + 1）将用户的操作保存为appendonly.aof文件，每次redis启动的时候从日志文件中读取。
- 2.优点
    + 1）数据安全性比较高
- 3.缺点
    + 1）性能比RDB差
- 4.操作
    + 1）修改appendonly no为yes，在下面设置持久化方式：appendfsync always 每次修改持久化一次，appendfsync everysec 每秒持久化一次，appendfsync no 不进行持久化。
    + 2）日志文件保存在/var/lib/redis/appendonly.aof中。
