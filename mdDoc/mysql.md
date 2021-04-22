---
typora-root-url: pic
---

# in与exist

https://www.cnblogs.com/wxw16/p/6105624.html?utm_source=itdadao&utm_medium=referral

# max函数

max(字段名)：一组字段中的最大值

效率（不考虑查询条件）：

max(主键/索引字段)  ：不需要select，Select tables optimized away

max(一般字段，不带索引)：全表扫描

# max+group by

https://blog.csdn.net/hd243608836/article/details/88817690

