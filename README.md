# Algorithm


### 排序算法
    
    蛮力法：
        冒泡排序
            应用：数据量足够小，比如斗牛游戏的牌面排序，多关键字排序，多用于3-5个数的排序
        选择排序
            应用：快速排序的基础，多用于5-8个数的排序
            
    分治法：
        快速排序（递归调用自己俩次，相当于二叉树前序）
            应用：数据量大并且是线性结构
            短处：有大量重复数据的时候，性能不好
                  单向链式结构处理性能不好（一般来说，链式都不使用）
        归并排序（递归调用自己俩次，相当于二叉树后序）
            应用：数据量大并且是链式结构
            短处：需要空间大
        

### 查找算法

    分治法：
        顺序查找
            如果线性表为无序表，即表中元素的排列是无序的，则不管线性表采用顺序存储还是链式存储，都必须使用顺序查找。
            如果线性表有序，但采用链式存储结构，则也必须使用顺序查找。
        二分查找
            前题条件：数据已经排序
    
