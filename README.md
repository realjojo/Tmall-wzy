# Tmall-wzy
---
## 遇到的问题
* **日期格式出错**  
**问题原因：** 数据库中的DateTime类型和Timestamp类型在java中对应的均为java.sql.Timestamp类型，js中通过new Date()获取到的日期格式为"Mar 31 10:10:43 UTC+0800 2012"这种格式，无法与java中的日期格式对应，需要进行转换  
**解决方式：**  
1、转换成"yyyy-MM-dd HH:mm:ss"或转换成时间戳格式：[https://www.cnblogs.com/linJie1930906722/p/6343337.html](https://www.cnblogs.com/linJie1930906722/p/6343337.html)  
2、转换成"yyyy-MM-dd'T'HH:mm:ss.SSSZ"格式：[https://segmentfault.com/q/1010000014069239?sort=created](https://segmentfault.com/q/1010000014069239?sort=created)  
3、Date,DateTime,TimeStamp和Time比较：[https://blog.csdn.net/qq_28483283/article/details/81873054](https://blog.csdn.net/qq_28483283/article/details/81873054)  
4、基本SQL Server,JDBC和Java数据类型之间的默认映射关系：[http://www.cnblogs.com/cunkouzh/p/5504052.html](http://www.cnblogs.com/cunkouzh/p/5504052.html)  
[https://www.cnblogs.com/heganlin/p/6074485.html](https://www.cnblogs.com/heganlin/p/6074485.html)  

* **v-for循环两个\<tr>标签**  
**问题原因：** 做成table的展开与折叠，点击当前tr展开一个子表格    
**解决方式：** 官方文档：[https://cn.vuejs.org/v2/guide/list.html#%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9](https://cn.vuejs.org/v2/guide/list.html#%E6%B3%A8%E6%84%8F%E4%BA%8B%E9%A1%B9)  
博客：[https://forum.vuejs.org/t/v-for-tr/36267](https://forum.vuejs.org/t/v-for-tr/36267)  

## TODO
1. 给用户加盐（salt值）：[https://www.jianshu.com/p/30e3c025674f](https://www.jianshu.com/p/30e3c025674f)  
2. hibernate级联删除：[https://www.cnblogs.com/lubolin/p/7767399.html](https://www.cnblogs.com/lubolin/p/7767399.html)  
3. 