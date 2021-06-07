## Java中多线程学习

#### 1. 线程基础、线程之间的共享和协作

1. 基础概念
2. 认识JAVA里的线程
3. 线程间的共享和协作

#### 2. 线程的并发工具类
1. Fork-Join
2. CountDownLatch
3. CyclicBarrier
4. Semaphore
5. Exchange
6. Callable、Future和FutureTask

#### 3. 原子操作CAS
1. 什么是原子操作？如何实现原子操作
2. CAS实现原子操作的三大问题
3. JDK中的相关原子操作类的使用

#### 4. 显示锁和AQS
1. 显示锁
2. CLH队列锁
3. AbstractQueuedSynchronizer

#### 5. 并发容器
1. ConcurrentHashMap
2. ConcurrentSkipList
3. ConcurrentLinkedQueue
4. 写时复制容器
5. 阻塞队列BlockingQueue

#### 6. 线程池
1. 为什么要用线程池
2. ThreadPoolExecutor的类关系
3. 线程池的创建各个参数含义
4. 线程池的工作机制

#### 7. 并发安全
1. 什么是线程安全性
2. 死锁
3. 其他安全问题
4. 并发下的性能
5. 线程安全的单例模式

## 常见面试题
1. HashMap和HashTable有什么区别？
2. ConcurrentHashMap和HashTable同样是线程安全，他们在线程同步上有什么不同？
3. HashMap&ConcurrentHashMap的区别？
4. 为什么ConcurrentHashMap比HashTable效率要高？
5. ConcurrentHashMap锁机制分析（JKD1.7 VS JDK1.8）？
6. ConcurrentHashMap在JDK1.8中，为什么要使用synchronized来代替重入锁ReentrantLock？
7. ConcurrentHashMap简单介绍？ConcurrentHashMap并发度是什么？




