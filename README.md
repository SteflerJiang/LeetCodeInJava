LeetCodeInJava
===================
# List
+ #100  Same Tree
+ #104  Maximum Depth of Binary Tree
+ #122  Best Time to Buy and Sell Stock II
+ #136  Single Number
+ #171  Excel Sheet Column Number
+ #226  Invert Binary Tree
+ #237  Delete Node in a Linked List
+ #238  Product of Array Except Self
+ #242  Valid Anagram
+ #258  Add Digits
+ #260  Single Number III
+ #283  Move Zeroes
+ #292  Nim Game
+ #338  Counting Bits
+ #347  Top K Frequent Elements
+ #349  Intersection of Two Arrays
+ #344  Reverse String


  347 Top K Frequent Elements


2016-06-20
今天开始刷LeetCode，先从AC最高的做起来。因为不想放弃java，所以决定用java来完成这些题目。

今晚做了两天题目练练手

## #100  Same Tree

**Detail**:
-description:
也是递归的方法，首先判断当前节点的val是否相同，如果相同则分别判断左右子节点

## #104  Maximum Depth of Binary Tree

**Detail**:
-description:
没什么说的 直接递归

## #122  Best Time to Buy and Sell Stock II

**Detail**:
-description:
这个题目怎么说呢。。怎么会出现在leecode中，可能大部分人第一遍读下来之后没看懂题目的意思。其实很简单，就是我从一段时间开始到结束，什么时候买，什么时候卖是最赚的而且卖只能在买之后。所用就从左到右遍历一遍数组，如果后一个大于前一个，则表示可以赚钱，于是就相加。

## #136  Single Number

**Detail**:
-description:
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
## #171  Excel Sheet Column Number

**Detail**:
-description:
这个其实就是类似于十进制、十六进制，这里是二十六进制，然后利用ascii码与'A'的差值来计算。

## #226 Invert Binary Tree

**Detail**:
-description:
没什么说的 直接递归

## #237 Delete Node in a Linked List

**Detail**:
-description:
这个题之前在《剑指offer》上看到过。惯性思维是删除current节点，巧妙的方法是删除next节点，这样就不用去查找prev节点了。所以呢，把下一个节点的val复制过来，然后删除next节点就OK了。

## #238  Product of Array Except Self

**Detail**:
-description:
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

## #242  Valid Anagram

**Detail**:
-description:
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

## #258  Add Digits

**Detail**:
-description:
这个好像可以看wikipedia上关于digital root的解释，给个链接吧
https://en.wikipedia.org/wiki/Digital_root

## #260  Single Number III

**Detail**:
-description:
这个题和#136有点相似，但是是有两个数不是为双的。

 1. 先找出这两个数的异或结果。
 2. 既然有了这两个数的异或结果res，那么res中取第n位为1，就表示在这两个数中，有一个第n位为0，有一个第n位为1。
 3. 这样按照此区分，把所有的数分为两组，一组是第n位为0，一组是第n位为1，这样在两组中只存在一个不是双数的数，再按照#136的方法即可得出结果。

## #283  Move Zeroes

**Detail**:
-description:
一个re标志位用来标记当前数组的位置，非0就将它复制到前面去。
最后再把0补齐即可。

## #292  Nim Game

**Detail**:
-description:
没啥了，每次只能取1-3，这样保证取出的是4的倍数即可。

## #338  Counting Bits

**Detail**:
-description:
counting bit相信大家都没有问题，那么counting bits就需要找规律了。
可以发现任意一个偶数n和n+1的关系
```
countingBit(n) = countingBit(n + 1) - 1
```
然后hint还提示了可以分组计算，[1, 2], [2, 3], [4, 7], [8, 16]，我没想太多，不过应该还是有可以重复利用的部分。

## #344  Reverse Strin

**Detail**:
-description:
这个直接用了Java中的StringBuilder，用来做字符串的运算会快很多，不需要每次重新建一个String。

## #347  Top K Frequent Elements

**Detail**:
-description:
第一步必须是扫描，计入到hashmap中。
那么怎么从每个数字出现的次数来找到前k个最高频率相互此案的，这样是不是就必须再对frequent进行排序呢。
NO.NO.NO 因为总共只有n个数，那么即使所有的数字一样多，是不是出现的频率最高也就是n呢。从n到0循环遍历以频率为key的hashmap，看看是否有对应的数，如果有就取出来，直到取到了k个。


## #349  Intersection of Two Arrays

**Detail**:
-description:
我用的笨方法。

 1. 先把nums1中的数据放到一个map1中
 2. 再把nums2中的数据如果在map1中也有的话，放到map2中
 3. 再把map2中的读出来放进数组里。

Welcome to StackEdit!
===================


Hey! I'm your first Markdown document in **StackEdit**[^stackedit]. Don't delete me, I'm very helpful! I can be recovered anyway in the **Utils** tab of the <i class="icon-cog"></i> **Settings** dialog.

----------


Documents
-------------

StackEdit stores your documents in your browser, which means all your documents are automatically saved locally and are accessible **offline!**

> **Note:**

> - StackEdit is accessible offline after the application has been loaded for the first time.
> - Your local documents are not shared between different browsers or computers.
> - Clearing your browser's data may **delete all your local documents!** Make sure your documents are synchronized with **Google Drive** or **Dropbox** (check out the [<i class="icon-refresh"></i> Synchronization](#synchronization) section).

#### <i class="icon-file"></i> Create a document

The document panel is accessible using the <i class="icon-folder-open"></i> button in the navigation bar. You can create a new document by clicking <i class="icon-file"></i> **New document** in the document panel.

#### <i class="icon-folder-open"></i> Switch to another document

All your local documents are listed in the document panel. You can switch from one to another by clicking a document in the list or you can toggle documents using <kbd>Ctrl+[</kbd> and <kbd>Ctrl+]</kbd>.

#### <i class="icon-pencil"></i> Rename a document

You can rename the current document by clicking the document title in the navigation bar.

#### <i class="icon-trash"></i> Delete a document

You can delete the current document by clicking <i class="icon-trash"></i> **Delete document** in the document panel.

#### <i class="icon-hdd"></i> Export a document

You can save the current document to a file by clicking <i class="icon-hdd"></i> **Export to disk** from the <i class="icon-provider-stackedit"></i> menu panel.

> **Tip:** Check out the [<i class="icon-upload"></i> Publish a document](#publish-a-document) section for a description of the different output formats.


----------


Synchronization
-------------------

StackEdit can be combined with <i class="icon-provider-gdrive"></i> **Google Drive** and <i class="icon-provider-dropbox"></i> **Dropbox** to have your documents saved in the *Cloud*. The synchronization mechanism takes care of uploading your modifications or downloading the latest version of your documents.

> **Note:**

> - Full access to **Google Drive** or **Dropbox** is required to be able to import any document in StackEdit. Permission restrictions can be configured in the settings.
> - Imported documents are downloaded in your browser and are not transmitted to a server.
> - If you experience problems saving your documents on Google Drive, check and optionally disable browser extensions, such as Disconnect.

#### <i class="icon-refresh"></i> Open a document

You can open a document from <i class="icon-provider-gdrive"></i> **Google Drive** or the <i class="icon-provider-dropbox"></i> **Dropbox** by opening the <i class="icon-refresh"></i> **Synchronize** sub-menu and by clicking **Open from...**. Once opened, any modification in your document will be automatically synchronized with the file in your **Google Drive** / **Dropbox** account.

#### <i class="icon-refresh"></i> Save a document

You can save any document by opening the <i class="icon-refresh"></i> **Synchronize** sub-menu and by clicking **Save on...**. Even if your document is already synchronized with **Google Drive** or **Dropbox**, you can export it to a another location. StackEdit can synchronize one document with multiple locations and accounts.

#### <i class="icon-refresh"></i> Synchronize a document

Once your document is linked to a <i class="icon-provider-gdrive"></i> **Google Drive** or a <i class="icon-provider-dropbox"></i> **Dropbox** file, StackEdit will periodically (every 3 minutes) synchronize it by downloading/uploading any modification. A merge will be performed if necessary and conflicts will be detected.

If you just have modified your document and you want to force the synchronization, click the <i class="icon-refresh"></i> button in the navigation bar.

> **Note:** The <i class="icon-refresh"></i> button is disabled when you have no document to synchronize.

#### <i class="icon-refresh"></i> Manage document synchronization

Since one document can be synchronized with multiple locations, you can list and manage synchronized locations by clicking <i class="icon-refresh"></i> **Manage synchronization** in the <i class="icon-refresh"></i> **Synchronize** sub-menu. This will let you remove synchronization locations that are associated to your document.

> **Note:** If you delete the file from **Google Drive** or from **Dropbox**, the document will no longer be synchronized with that location.

----------


Publication
-------------

Once you are happy with your document, you can publish it on different websites directly from StackEdit. As for now, StackEdit can publish on **Blogger**, **Dropbox**, **Gist**, **GitHub**, **Google Drive**, **Tumblr**, **WordPress** and on any SSH server.

#### <i class="icon-upload"></i> Publish a document

You can publish your document by opening the <i class="icon-upload"></i> **Publish** sub-menu and by choosing a website. In the dialog box, you can choose the publication format:

- Markdown, to publish the Markdown text on a website that can interpret it (**GitHub** for instance),
- HTML, to publish the document converted into HTML (on a blog for example),
- Template, to have a full control of the output.

> **Note:** The default template is a simple webpage wrapping your document in HTML format. You can customize it in the **Advanced** tab of the <i class="icon-cog"></i> **Settings** dialog.

#### <i class="icon-upload"></i> Update a publication

After publishing, StackEdit will keep your document linked to that publication which makes it easy for you to update it. Once you have modified your document and you want to update your publication, click on the <i class="icon-upload"></i> button in the navigation bar.

> **Note:** The <i class="icon-upload"></i> button is disabled when your document has not been published yet.

#### <i class="icon-upload"></i> Manage document publication

Since one document can be published on multiple locations, you can list and manage publish locations by clicking <i class="icon-upload"></i> **Manage publication** in the <i class="icon-provider-stackedit"></i> menu panel. This will let you remove publication locations that are associated to your document.

> **Note:** If the file has been removed from the website or the blog, the document will no longer be published on that location.

----------


Markdown Extra
--------------------

StackEdit supports **Markdown Extra**, which extends **Markdown** syntax with some nice features.

> **Tip:** You can disable any **Markdown Extra** feature in the **Extensions** tab of the <i class="icon-cog"></i> **Settings** dialog.

> **Note:** You can find more information about **Markdown** syntax [here][2] and **Markdown Extra** extension [here][3].


### Tables

**Markdown Extra** has a special syntax for tables:

Item     | Value
-------- | ---
Computer | $1600
Phone    | $12
Pipe     | $1

You can specify column alignment with one or two colons:

| Item     | Value | Qty   |
| :------- | ----: | :---: |
| Computer | $1600 |  5    |
| Phone    | $12   |  12   |
| Pipe     | $1    |  234  |


### Definition Lists

**Markdown Extra** has a special syntax for definition lists too:

Term 1
Term 2
:   Definition A
:   Definition B

Term 3

:   Definition C

:   Definition D

	> part of definition D


### Fenced code blocks

GitHub's fenced code blocks are also supported with **Highlight.js** syntax highlighting:

```
// Foo
var bar = 0;
```

> **Tip:** To use **Prettify** instead of **Highlight.js**, just configure the **Markdown Extra** extension in the <i class="icon-cog"></i> **Settings** dialog.

> **Note:** You can find more information:

> - about **Prettify** syntax highlighting [here][5],
> - about **Highlight.js** syntax highlighting [here][6].


### Footnotes

You can create footnotes like this[^footnote].

  [^footnote]: Here is the *text* of the **footnote**.


### SmartyPants

SmartyPants converts ASCII punctuation characters into "smart" typographic punctuation HTML entities. For example:

|                  | ASCII                        | HTML              |
 ----------------- | ---------------------------- | ------------------
| Single backticks | `'Isn't this fun?'`            | 'Isn't this fun?' |
| Quotes           | `"Isn't this fun?"`            | "Isn't this fun?" |
| Dashes           | `-- is en-dash, --- is em-dash` | -- is en-dash, --- is em-dash |


### Table of contents

You can insert a table of contents using the marker `[TOC]`:

[TOC]


### MathJax

You can render *LaTeX* mathematical expressions using **MathJax**, as on [math.stackexchange.com][1]:

The *Gamma function* satisfying $\Gamma(n) = (n-1)!\quad\forall n\in\mathbb N$ is via the Euler integral

$$
\Gamma(z) = \int_0^\infty t^{z-1}e^{-t}dt\,.
$$

> **Tip:** To make sure mathematical expressions are rendered properly on your website, include **MathJax** into your template:

```
<script type="text/javascript" src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML"></script>
```

> **Note:** You can find more information about **LaTeX** mathematical expressions [here][4].


### UML diagrams

You can also render sequence diagrams like this:

```sequence
Alice->Bob: Hello Bob, how are you?
Note right of Bob: Bob thinks
Bob-->Alice: I am good thanks!
```

And flow charts like this:

```flow
st=>start: Start
e=>end
op=>operation: My Operation
cond=>condition: Yes or No?

st->op->cond
cond(yes)->e
cond(no)->op
```

> **Note:** You can find more information:

> - about **Sequence diagrams** syntax [here][7],
> - about **Flow charts** syntax [here][8].

### Support StackEdit

[![](https://cdn.monetizejs.com/resources/button-32.png)](https://monetizejs.com/authorize?client_id=ESTHdCYOi18iLhhO&summary=true)

  [^stackedit]: [StackEdit](https://stackedit.io/) is a full-featured, open-source Markdown editor based on PageDown, the Markdown library used by Stack Overflow and the other Stack Exchange sites.


  [1]: http://math.stackexchange.com/
  [2]: http://daringfireball.net/projects/markdown/syntax "Markdown"
  [3]: https://github.com/jmcmanus/pagedown-extra "Pagedown Extra"
  [4]: http://meta.math.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference
  [5]: https://code.google.com/p/google-code-prettify/
  [6]: http://highlightjs.org/
  [7]: http://bramp.github.io/js-sequence-diagrams/
  [8]: http://adrai.github.io/flowchart.js/
