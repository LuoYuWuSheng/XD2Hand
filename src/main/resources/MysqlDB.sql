# 创建数据库 默认字符集设置为utf8
# 执行时候防止需要加上--default-character-set=utf8防止乱码
CREATE DATABASE IF NOT EXISTS BookStore CHARACTER SET utf8;

USE BookStore;

# 禁止外键约束检查 不建议
# SET FOREIGN_KEY_CHECKS=0;

-- 团体表
# 我们把无论是学校 还是将来的小区都视为一个团体
CREATE TABLE IF NOT EXISTS Community(
#   社区id
  Community_id int AUTO_INCREMENT PRIMARY KEY ,
#   社区名称
  name VARCHAR(300) NOT NULL,
#   社区地址
  address VARCHAR(500),
#   社区类型 0代表学校 1代表小区 2代表村 目前不打算吧把类型作为外键，这里采用约定，不知道对以后会不会有影响
#   希望能做到 要增加类型表的时候只需要将type修改为 foreignkey即可，不改动代码
  type TINYINT
);

-- 班级信息表
CREATE TABLE IF NOT EXISTS Classes(
#   班级id
  Class_id INT PRIMARY KEY AUTO_INCREMENT,
#   班级名称
  name VARCHAR(50) NOT NULL ,
#   所属团体
  Community_id int,
  FOREIGN KEY (Community_id) REFERENCES Community(Community_id)
);

# 创建用户表
CREATE TABLE IF NOT EXISTS User_Student(
#   用户账号ID
  Stu_id int PRIMARY KEY AUTO_INCREMENT,
#   用户姓名
  name VARCHAR(100) NOT NULL ,
#   昵称
  nickname VARCHAR(100),
#   电话号
  phoneNumber VARCHAR(20),
#   用户邮箱
  email VARCHAR(40),
#   团体-对于学生来说是学校
  Community_id INT,
#   班级
  classes INT,
#   用户头像
  portrait VARCHAR(200),
#   账号密码
  passwd VARCHAR(40) NOT NULL,
  FOREIGN KEY (Community_id) REFERENCES Community(Community_id),
  FOREIGN KEY (classes) REFERENCES Classes(Class_id)
);

-- 图书类型表
CREATE TABLE IF NOT EXISTS Book_TypeInfo(
  BookTypeId int auto_increment primary key,
  BookTypeName varchar(50) not null
);

-- isbn 表
CREATE TABLE IF NOT EXISTS Book_Isbn(
#   isbn 号
  ISBN_id BIGINT PRIMARY KEY ,
#   10位isbn
  isbn10 VARCHAR(12),
#   13位isbn
  isbn13 VARCHAR(15),
#   图书名称
  title VARCHAR(100),
#   这里的图片是豆瓣的，要不要持久化到本地，写成本地的
  image VARCHAR(300),
#   作者姓名
  author VARCHAR(80),
#   译者姓名
  translator VARCHAR(80),
#   出版社
  publisher VARCHAR(150),
#   出版日期
  pubdate DATE,
#   装订
  binding VARCHAR(10),
#   用float还是用varchar
  price FLOAT,
#   还不知道要不要，数据库使用数组如何用。
#   tag VARCHAR(1),
#   图书页数
  pages SMALLINT,
#   作者简介
  author_intro TEXT,
#   图书摘要
  summary TEXT,
#   图书目录
  catalog TEXT
);

-- 创建图书列表
#  这里有个难点是如何进行分类标识？而且我们有两种分类法方法
CREATE TABLE IF NOT EXISTS Books(
#   图书id
  Book_id INT PRIMARY KEY AUTO_INCREMENT,
#   发布者的id
  Stu_id int,
#   图书 isbn编号
  isbn BIGINT,
#   旧书的图片 需要对个数进行限制。存放的是路径
#   默认第一个为封面，但是前端在进行旧书发布的时候需要区别对待封面图片和详情
  pictures VARCHAR(500),
# 新旧等级  10代表全新 9代表九成新 以此类推
  level int,
#   推荐星级 5代表五星推荐
  recommendStar int,
#   图书发布时间
  publish_date DATE,
#   图书分类编码 通用分类
  BookTypeId int,
#   定制化分了 按照班级分类
  typeCode_class VARCHAR(20),
#   价格
  price float,
#   书名 用户可以字节写书名，默认是和isbn查到的同名。
  name VARCHAR(100),

  FOREIGN KEY (Stu_id) REFERENCES User_Student(Stu_id),
  FOREIGN KEY (BookTypeId) REFERENCES Book_TypeInfo(BookTypeId),
  FOREIGN KEY (isbn) REFERENCES Book_Isbn(ISBN_id)
);

-- 图书评论表
CREATE TABLE IF NOT EXISTS Book_Comment(
#   评论id
  C_id int PRIMARY KEY AUTO_INCREMENT,
#   发表评论用户id
  Stu_id int,
#   isbn 用isbn来对图书进行分类
  isbn BIGINT,
#   评论内容
  content TEXT,
#   发布评论的时间
  Commentdate datetime,

  foreign key (Stu_id) references User_Student(Stu_id),
#  这个外键约束加不上 一加就有错 
  foreign key (isbn) references Book_Isbn(ISBN_id)
);

-- 订单表
CREATE TABLE IF NOT EXISTS Orders(
  OrderID varchar(20) PRIMARY KEY,
  Stu_id int,
  totalMoney float,
  orderDate datetime,
  foreign key (Stu_id) references User_Student(Stu_id)
);

-- 订单详情
CREATE TABLE IF NOT EXISTS Order_Detail(
  OrderDetailID varchar(20) primary key,
  OrderID varchar(20) not null,
  Book_ID int not null,
  foreign key (OrderID) references Orders(OrderID)
);

-- 插入一些测试用数据

INSERT INTO Community VALUES (1,'西安电子科技大学','陕西省 西安市 太白南路2号',0);

INSERT INTO Classes VALUES (1,'计算机学院 031114班',1);

INSERT INTO book_isbn VALUES (1,'7115145543','9787115145543','C++ primer','https://img3.doubanio.com/mpic/s1638975.jpg',
  'Stanley B.Lippman','李师贤','人民邮电出版社','2006-1-1','16开','99.00',745,'本书所有作者都是著名的C++权威人物。\nStanley B. Lippman目前是微软公司 Visual C++ 团队的架构师。他从1984年开始在贝尔实验室与C++的设计者Bjarne Stroustrup一起从事C++的设计与开发。他在迪士尼和梦工厂从事动画制作，还担任过JPL的高级顾问。他还著有Inside the C++ Object Model。\nJosée Lajoie曾经是IBM加拿大研究中心C/C++编译器开发团队的成员，在ISO C++标准委员会工作了7年，担任过ISO核心语言工作组的主席和C++ Report杂志的专栏作家。\nBarbara E. Moo是拥有25年软件经验的独立咨询顾问。在AT&T，她与Stroustrup、Lippman一起管理过复杂的C++开发项目。她和Andrew Koenig合著了Accelerated C++和Ruminations on C++。',
    '本书是久负盛名的C++经典教程，其内容是C++大师Stanley B. Lippman丰富的实践经验和C++标准委员会原负责人Josée Lajoie对C++标准深入理解的完美结合，已经帮助全球无数程序员学会了C++。本版对前一版进行了彻底的修订，内容经过了重新组织，更加入了C++ 先驱Barbara E. Moo在C++教学方面的真知灼见。既显著改善了可读性，又充分体现了C++语言的最新进展和当前的业界最佳实践。书中不但新增大量教学辅助内容，用于强调重要的知识点，提醒常见的错误，推荐优秀的编程实践，给出使用提示，还包含大量来自实战的示例和习题。对C++基本概念和技术全面而且权威的阐述，对现代C++编程风格的强调，使本书成为C++初学者的最佳指南；对于中高级程序员，本书也是不可或缺的参考书。本书的前言阐述了 第4版和前一版的不同之处。',
    '第1章 快速入门\n1.1 编写简单的C++程序\n1.2 初窥输入/输出\n1.3 关于注释\n1.4 控制结构 入\n1.5 类的简介\n1.6 C++程序\n小结\n术语\n第一部分 基本语言\n第2章 变量和基本类型\n2.1 基本内置类型\n2.2 字面值常量\n2.3 变量\n2.4 const限定符\n2.5 引用\n2.6 typedef名字\n2.7 枚举\n2.8 类类型\n2.9 编写自己的头文件\n小结\n术语\n第3章 标准库类型\n3.1 命名空间的using声明\n3.2 标准库string类型\n3.3 标准库vector类型\n3.4 迭代器简介\n3.5 标准库bitset类型\n小结\n术语\n第4章 数组和指针\n4.1 数组\n4.2 指针的引入\n4.3 C风格字符串\n4.4 多维数组\n小结\n术语\n第5章 表达式\n5.1 算术操作符\n5.2 关系操作符和逻辑操作符\n5.3 位操作符\n5.4 赋值操作符\n5.5 自增和自减操作符\n5.6 箭头操作符\n5.7 条件操作符\n5.8 sizeof操作符\n5.9 逗号操作符\n5.10 复合表达式的求值\n5.11 new和delete表达式\n5.12 类型转换\n小结\n术语\n第6章 语句\n6.1 简单语句\n6.2 声明语句\n6.3 复合语句（块）\n6.4 语句作用域\n6.5 if语句\n6.6 switch语句\n6.7 while语句\n6.8 for循环语句\n6.9 do while语句\n6.10 break语句\n6.11 continue语句\n6.12 goto语句\n6.13 try块和异常处理\n6.14 使用预处理器进行调试\n小结\n术语\n第7章 函数\n7.1 函数的定义\n7.2 参数传递\n7.3 return语句\n7.4 函数声明\n7.5 局部对象\n7.6 内联函数\n7.7 类的成员函数\n7.8 重载函数\n7.9 指向函数的指针\n小结\n术语\n第8章 标准IO库\n8.1 面向对象的标准库\n8.2 条件状态\n8.3 输出缓冲区的管理\n8.4 文件的输入和输出\n8.5 字符串流\n小结\n术语\n第二部分 容器和算法\n第9章 顺序容器\n第10章 关联容器\n第11章 泛型算法\n第三部分 类和数据抽象\n第12章 类\n第13章 复制控制\n第14章 重载操作符与转换\n第四部分 面向对象编程与泛型编程\n第15章 面向对象编程\n第16章 模板与泛型编程\n第五部分 高级主题\n第17章 用于大型程序的工具\n第18章 特殊工具与技术\n附录 标准库\n索引'
);

INSERT INTO book_typeinfo VALUES (1,'计算机');

INSERT INTO user_student VALUES (1,'张洋','luoyu','15529095223','z_y_ang@163.com','1','1','','admin');