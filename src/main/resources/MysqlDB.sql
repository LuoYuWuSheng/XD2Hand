# 创建数据库 默认字符集设置为utf8
# 执行时候防止需要加上--default-character-set=utf8防止乱码
CREATE DATABASE IF NOT EXISTS BookStore CHARACTER SET utf8;

USE BookStore;

# 禁止外键约束检查 不建议
# SET FOREIGN_KEY_CHECKS=0;

# 创建用户表
CREATE TABLE IF NOT EXISTS User(
#   用户账号ID
  User_id int PRIMARY KEY AUTO_INCREMENT,
#   用户姓名
  name VARCHAR(100) NOT NULL ,
#   用户类型0买 1卖
  type TINYINT(1),
#   账号密码
  passwd VARCHAR(40) NOT NULL
);


-- 创建图书商品列表
CREATE TABLE IF NOT EXISTS Books(
#   图书id
  Book_id INT PRIMARY KEY AUTO_INCREMENT,
#   发布者的id
  User_id int,
#   默认第一个为封面，但是前端在进行旧书发布的时候需要区别对待封面图片和详情
  pictures VARCHAR(500),
#   图书发布时间
  publish_date DATE,
#   价格
  price float,
#   书名 用户可以字节写书名，默认是和isbn查到的同名。
  title VARCHAR(100),
#   摘要
  subtitle VARCHAR(160),
#   详细信息
  detail VARCHAR(1200),
#   图书数量
  num INT,
  FOREIGN KEY (User_id) REFERENCES User(User_id)
);

-- 订单表 冗余存储，避免连接操作
CREATE TABLE IF NOT EXISTS Orders(
  OrderID varchar(20) PRIMARY KEY,
  Seller_id int,
  Buyer_id int,
  Book_ID int not null,
  Book_Title VARCHAR(100),
  Book_Price FLOAT,
  Book_Num int not null,
  orderDate datetime,
  Book_Picture VARCHAR(500),

  foreign key (Seller_id) references User(User_id),
  foreign key (Buyer_id) references User(User_id)
);

-- 插入一些测试用数据
INSERT INTO User VALUES ('','buyer','0','reyub');
INSERT INTO User VALUES ('','seller','1','relles');
INSERT INTO Books VALUES ('','1','https://img3.doubanio.com/mpic/s1638975.jpg',
  '2018-1-1','99.00','C++ primer','一起来编程','入门必学，编程必会',100
);