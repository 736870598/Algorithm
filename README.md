
### 排序算法
    
#### 蛮力法：
  ##### 冒泡排序  O(n^2)
            应用：数据量足够小，比如斗牛游戏的牌面排序，多关键字排序，多用于3-5个数的排序
  ##### 选择排序  O(n^2)
            应用：快速排序的基础，多用于5-8个数的排序
            
#### 分治法：
  ##### 快速排序  O(nlogn)
            （递归调用自己俩次，相当于二叉树前序）
            应用：数据量大并且是线性结构
            短处：有大量重复数据的时候，性能不好
                  单向链式结构处理性能不好（一般来说，链式都不使用）
  ##### 归并排序  O(nlogn)
            （递归调用自己俩次，相当于二叉树后序）
            应用：数据量大并且是链式结构
            短处：需要空间大
            
#### 排序算法在棋牌游戏中的应用：        
  ##### 基数排序   O(n*k)
            补位按位进行排序
            应用：字牌类游戏（多条件排序）只删除不增加的 （麻将类的每次要摸一张就要重新排序，这种不合适）
  ##### 直接插入排序： O(n^2)
            应用：就像平时打扑克的时候马牌时一样的
  ##### 希尔排序：  O(nlogn)
            按步长进行排序，当步长为1时就是一个直接插入排序
            比较在希尔排序中时最主要的操作，而不是交换
            步长的取值：1，4，10，23，57，132，301，701，1750 。。。。。
            （用这样步长序列的希尔排序比插入培训和堆排序都要快，甚至在小数组中比快速排序还要快，
              但是涉及到打了数据时希尔排序还是比快速排序慢）
          应用：麻将
          
#### 减治法：
  ##### 堆排序：   O(nlogn)
  
            应用：当数据源为无序链式结构的时候，进行二分查找
  
            完全二叉树链式结构和线性结构的换算
            如果当前节点时k
                父节点是：(k-1)/2
                左孩子是：2*k+1
                右孩子是：2*k+2
        

### 查找算法

#### 分治法：
  ##### 顺序查找
            如果线性表为无序表，即表中元素的排列是无序的，则不管线性表采用顺序存储还是链式存储，都必须使用顺序查找。
            如果线性表有序，但采用链式存储结构，则也必须使用顺序查找。
  ##### 二分查找
            前题条件：数据已经排序
    
