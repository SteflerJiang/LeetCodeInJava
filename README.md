LeetCodeInJava
===================
# List
+ #98   Validate Binary Search Tree
+ #100  Same Tree
+ #104  Maximum Depth of Binary Tree
+ #122  Best Time to Buy and Sell Stock II
+ #136  Single Number
+ #150	Evaluate Reverse Polish Notation
+ #169	Majority Element
+ #171  Excel Sheet Column Number
+ #217	Contains Duplicate
+ #226  Invert Binary Tree
+ #237  Delete Node in a Linked List
+ #238  Product of Array Except Self
+ #242  Valid Anagram
+ #258  Add Digits
+ #260  Single Number III
+ #274	H-Index
+ #283  Move Zeroes
+ #292  Nim Game
+ #318	Maximum Product of Word Lengths
+ #338  Counting Bits
+ #343	Integer Break
+ #344  Reverse String
+ #347  Top K Frequent Elements
+ #349  Intersection of Two Arrays
+ #350	Intersection of Two Arrays II
+ #357	Count Numbers with Unique Digits


2016-06-20
今天开始刷LeetCode，先从AC最高的做起来。因为不想放弃java，所以决定用java来完成这些题目。

今晚做了两天题目练练手12

## 98  Validate Binary Search Tree

**Detail**:

- description:
检查一个二叉查找树是不是合法的。

第一反应很简单啊，这是我的第一版代码
``` java
public class Solution {  
    public boolean isValidBST(TreeNode root) {  
        if (root == null) return true;  
        if (root.left == null && root.right == null) return true;  
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);  
    }  
      
    public boolean validate(TreeNode root, int min, int max) {  
        if (root == null) return true;  
        if (root.val <= min || root.val >= max) return false;  
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);  
    }  
}  
```
可是就是跑不通测试，怎么看都不应该错啊。想了好久，又看了网上的讲解。原来不仅要看一个节点跟它的左右子树进行比较，还要看它的儿子和它的父亲之间的关系。
一个很好的方法就是中序遍历，把一棵树按照**左根右**的方式去排列，然后检查一遍是否合格，不过需要花费额外的空间。


网上看的一个不需要额外空间的优化解法，把代码列上来吧
```java
public class Solution {  
    // Keep the previous value in inorder traversal.  
    TreeNode pre = null;  
      
    public boolean isValidBST(TreeNode root) {  
        // Traverse the tree in inorder.  
        if (root != null) {  
            // Inorder traversal: left first.  
            if (!isValidBST(root.left)) return false;  
              
            // Compare it with the previous value in inorder traversal.  
            if (pre != null && root.val <= pre.val) return false;  
              
            // Update the previous value.  
            pre = root;  
              
            // Inorder traversal: right last.  
            return isValidBST(root.right);  
        }  
        return true;  
     }  
}
```

## 100  Same Tree

**Detail**:

- description:
也是递归的方法，首先判断当前节点的val是否相同，如果相同则分别判断左右子节点

## 104  Maximum Depth of Binary Tree

**Detail**:

- description:
没什么说的 直接递归

## 122  Best Time to Buy and Sell Stock II

**Detail**:

- description:
这个题目怎么说呢。。怎么会出现在leecode中，可能大部分人第一遍读下来之后没看懂题目的意思。其实很简单，就是我从一段时间开始到结束，什么时候买，什么时候卖是最赚的而且卖只能在买之后。所用就从左到右遍历一遍数组，如果后一个大于前一个，则表示可以赚钱，于是就相加。

## 136  Single Number

**Detail**:

- description:
异或，相同的数异或为0

运算法则：
```
1. a ⊕ a = 0
2. a ⊕ 0 = a
3. a ⊕ b = b ⊕ a
4. a ⊕b ⊕ c = a ⊕ (b ⊕ c) = (a ⊕ b) ⊕ c;
5. d = a ⊕ b ⊕ c 可以推出 a = d ⊕ b ⊕ c.
6. a ⊕ b ⊕ a = b.
```

## 150  Evaluate Reverse Polish Notation

**Detail**:


> 逆波兰表示法（Reverse Polish notation，RPN，或逆波兰记法），是一种是由波兰数学家扬·武卡谢维奇1920年引入的数学表达式方式，在逆波兰记法中，所有操作符置于操作数的后面，因此也被称为后缀表示法。逆波兰记法不需要括号来标识操作符的优先级。

- description:考察的是怎么把逆波兰表示法给计算出来。用一个栈来压入所有的数，当遇到操作符时，取出栈顶的两个数，计算出结果后再压入栈内，最后的结果就是栈里的唯一的一个数。


## 169  Majority Element

**Detail**:

- description:
这个题目在校招复习的时候看过，找出一个数组中出现次数超过[n/2]的数。
从第一个数开始，与下一个数比较，记录出现次数最多的数和出现次数。如果相同，次数加1，如果不相同，次数减1，如果次数小于等于1，则变更这个出现次数最多的数。



## 171  Excel Sheet Column Number

**Detail**:

- description:
这个其实就是类似于十进制、十六进制，这里是二十六进制，然后利用ascii码与'A'的差值来计算。

## 217 Contains Duplicate

**Detail**:

- description:
检查一个数组中，是否有两个数重复。
1. 排序 O(NlogN) O(1)
2. 一个个比较 O(N^2) O(1)
3. set	O(N) O(N)

## 226 Invert Binary Tree

**Detail**:

- description:
没什么说的 直接递归

## 237 Delete Node in a Linked List

**Detail**:

- description:
这个题之前在《剑指offer》上看到过。惯性思维是删除current节点，巧妙的方法是删除next节点，这样就不用去查找prev节点了。所以呢，把下一个节点的val复制过来，然后删除next节点就OK了。

## 238  Product of Array Except Self

**Detail**:

- description:
这题有点意思啊，好好分析一下。
首先读懂题目的意思，要求把所有的数都乘起来，并且除以自身，就是该位置的值。

一般人的第一反应就是按照上面的思路呗，可是题目给了要求
> Solve it without division and in O(n)

不能用除法之后，只能用乘法操作，那么怎么样利用之前的结果，而不需要每次都做重复的乘法操作呢。
不多说了，直接看代码
```
for (int i = 1; i < nums.length; i++) {
  res[i] = res[i-1] * nums[i-1];
}
```

第一次遍历，让数组中所有的数res[i] = res[0] * res[1] * ... * res[i-1]，等于它左边所有的数的乘积。但是题目的要求是除了自身所有的数，也就是所有左边的和所有右边的都要乘起来。
这时候我们就需要第二次遍历了
```
for (int i = nums.length - 1; i > 0; i--) {
  res[i] = res[i] * res[0];
  res[0] = res[0] * nums[i];
}
```
这里用了一个很巧妙的技巧，就是不断地让第一个数变大，而且是从右往左乘，这样res[i]需要再乘以 res[len-1], res[len-2], ..., res[i+1]，而res[0]就是在这个循环中不断地从右往左乘。

## 242  Valid Anagram

**Detail**:

- description:
我一开始的方法不知道为什么不行，testcase[33/34]每次都卡在这里简直无语了。笨方法就是分别用两个hashmap统计两个字符串中出现的所有字符，最后比较这两个hashmap是否相同。

没办法，我只能去看答案，原来真的简单，根本用不到hashmap，因为总共就只有26个英文字符，所以一个26长的数组就能完全覆盖了。
```
for (char c : s.toCharArray()) {
    count[c - 'a']++;
}
for (char c : t.toCharArray()) {
    count[c - 'a']--;
    if (count[c - 'a'] < 0) return false;
}
```
两个循环，也是用ascii的值去计算字符在数组中的位置。
第二遍如果发现有小于0的，说明t中肯定有多的字符，那么就不是valid anagram啦。不过当然第一步还是要判断两个字符串的长度是否相同。

## 258  Add Digits

**Detail**:

- description:
这个好像可以看wikipedia上关于digital root的解释，给个链接吧
https://en.wikipedia.org/wiki/Digital_root

## 260  Single Number III

**Detail**:

- description:
这个题和#136有点相似，但是是有两个数不是为双的。

 1. 先找出这两个数的异或结果。
 2. 既然有了这两个数的异或结果res，那么res中取第n位为1，就表示在这两个数中，有一个第n位为0，有一个第n位为1。
 3. 这样按照此区分，把所有的数分为两组，一组是第n位为0，一组是第n位为1，这样在两组中只存在一个不是双数的数，再按照#136的方法即可得出结果。

## 274  H-Index

**Detail**:

- description:
找到一个数h，h个数大于等于h，剩下的n-h个数全部小于等于h。

最简单的方法是对数组进行排序，O(NlogN)的时间，然后从后往前遍历，找到最大的一个h。

如果仔细考虑h的特征可以发现，如果`数组的长度为n`，那么h大于n肯定不行，因为这将意味着有大于n个数大于等于h，所以对大于n的数可以一视同仁了。这样我们只需要考虑`所有小于等于n的数`和`一个大于等于n的数`。
代码如下
```java
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
			return 0;
		}
        int length = citations.length;
        int h = 0;
        int[] array = new int[length + 1];

		// 考虑所有小于等于n的数`和`一个大于等于n的数
        for (int i : citations) {
			if (i > length) array[length] += 1;
			else array[i] += 1;
		}

		// 从后向前遍历，找到最大的一个符合条件的数
        for (int i = length; i >= 0; i--) {
        	h = h + array[i];
        	if (h >= i) return i;
        }
        return 0;
    }
}
```



## 283  Move Zeroes

**Detail**:

- description:
一个re标志位用来标记当前数组的位置，非0就将它复制到前面去。
最后再把0补齐即可。

## 292  Nim Game

**Detail**:

- description:
没啥了，每次只能取1-3，这样保证取出的是4的倍数即可。

## 318  Maximum Product of Word Lengths

**Detail**:

- description:
一个单词所有字母组合最多26个，用26位的二进制数来表示一个单词中所用到的所有字母，左移即可。

判断两个单词是否有相同字母，只需要将上面的两个数做与操作，判断是否为0即可，`values[i] & values[j]) == 0`。

## 338  Counting Bits

**Detail**:

- description:
counting bit相信大家都没有问题，那么counting bits就需要找规律了。
可以发现任意一个偶数n和n+1的关系
```
countingBit(n) = countingBit(n + 1) - 1
```
然后hint还提示了可以分组计算，[1, 2], [2, 3], [4, 7], [8, 16]，我没想太多，不过应该还是有可以重复利用的部分。

## 343  Integer Break

**Detail**:

- description:
把一个数拆分开，求最大的成绩，用几个简单的例子就可以发现，拆出来的数要么是2，要么是3，所以我的方法还算比较简单，列一下代码，
需要注意的是一个数不能是它自己，如2必须要拆成1*1，所以这里简单注意一下就OK
```java
public class Solution {
	public static int integerBreak(int n) {
		return integerBreak(n, true);
    }

	public static int integerBreak(int n, boolean isFirst) {
		if (n < 4)
		{
			if (isFirst)
				return n-1 > 0 ? n-1 : 1;
			else
				return n > 0 ? n : 1;
		}
		if (n % 3 == 1)
			return 4 * integerBreak(n - 4, false);
		return 3 * integerBreak(n - 3, false);
    }
   }
```

看了下答案，用的dp算法，状态和状态转移方程这里就不一一描述了，但我觉得这样的效率会比较低。


## 344  Reverse Strin

**Detail**:

- description:
这个直接用了Java中的StringBuilder，用来做字符串的运算会快很多，不需要每次重新建一个String。

## 347  Top K Frequent Elements

**Detail**:

- description:
第一步必须是扫描，计入到hashmap中。
那么怎么从每个数字出现的次数来找到前k个最高频率相互此案的，这样是不是就必须再对frequent进行排序呢。
NO.NO.NO 因为总共只有n个数，那么即使所有的数字一样多，是不是出现的频率最高也就是n呢。从n到0循环遍历以频率为key的hashmap，看看是否有对应的数，如果有就取出来，直到取到了k个。


## 349  Intersection of Two Arrays

**Detail**:

- description:
我用的笨方法。

 1. 先把nums1中的数据放到一个map1中
 2. 再把nums2中的数据如果在map1中也有的话，放到map2中
 3. 再把map2中的读出来放进数组里。

## 350	Intersection of Two Arrays II

**Detail**:

- description:
获取两个数组中相同的数字，不过这些数字可能是有重复的。
笨方法如下：
1. 先获取一个数组中所有的数字和对应的次数
2. 遍历第二个数组，看看第一个数组中是否存在，如果存在则记录下，并讲第一个数组中该数对应的次数减一。
3. 所有记录下的值组合起来就是结果
4. 耗时8ms

## 357	Count Numbers with Unique Digits

**Detail**:

- description:

动态规划
找规律

Let f(k) = count of numbers with unique digits with length equals k.
