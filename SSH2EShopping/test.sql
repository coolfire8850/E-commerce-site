drop database if exists shop;

create database shop default character set utf8;

use shop;

drop table if exists account;

drop table if exists category;

drop table if exists product;

drop table if exists shoppingcart;

drop table if exists sorder;

drop table if exists status;

drop table if exists user;

/*============================*/
/*      Table：administrator for back-end */
/*============================*/
create table account
(
	
	id int primary key not null auto_increment,
	
	login varchar(20),
	
	name varchar(20),
	
	pass varchar(20)
);

/*============================*/
/*     Table：product category */
/*============================*/
create table category
(
  
   id  int primary key not null auto_increment,
  
   type varchar(20),
   /* if hot, we show this product at the welcome page*/
   hot  bool default false,
  
   aid int,
   constraint aid_FK foreign key(aid) references account(id)
);

/*=============================*/
/* Table: product	 		   */
/*=============================*/
create table product
(
  
   id                  int primary key not null auto_increment,
  
   name                varchar(50),

   price               decimal(8,2),
  
   pic                 varchar(300),
   /*bref introduction  */
   details             longtext,
   /* 商品生产日期 */
   date                timestamp default CURRENT_TIMESTAMP,
   /* if recommend or not */
   commend             bool,
   /* if valid or not */
   open                bool,
   /* 商品所在的类别编号*/
   cid                  int,
   constraint cid_FK foreign key(cid) references category(id)
);

/*============================*/
/* Table: user		      */
/*============================*/
create table user
(
  
   id                  int primary key not null auto_increment,
  
   login               varchar(20),
  
   name                varchar(20),
  
   pass                varchar(20),
   
   sex                 varchar(20),
  
   phone               varchar(20),
  
   email               varchar(20)
);

/*=============================*/
/* Table: status for order	   */
/*=============================*/
create table status
(
  
   id                  int primary key not null auto_increment,
  
   status               varchar(10)
);

/*=============================*/
/* Table: shopping cart		   */
/*=============================*/
create table shoppingcart
(
  
   id                  int primary key not null auto_increment,
 
   name                varchar(20),
 
   phone               varchar(20),
 
   remark              varchar(20),
  
   date                timestamp default CURRENT_TIMESTAMP,
  
   total               decimal(8,2),
 
   post                varchar(20),
   
   address             varchar(200),
  
   sid                 int default 1,
 
   uid                 int,
   constraint sid_FK foreign key(sid) references status(id),
   constraint uid_FK foreign key(uid) references user(id)
);


ALTER TABLE shoppingcart AUTO_INCREMENT = 20161001;

/*=============================*/
/* Table: prodcut item in shoppingcart */
/*=============================*/

create table sorder
(
  
   id                  int primary key not null auto_increment,
  
   name                varchar(20),
   
   price               decimal(8,2),
 
   number              int not null,
  
   pid                  int,
   
   fid                  int,
   constraint pid_FK foreign key(pid) references product(id),
   constraint fid_FK foreign key(fid) references shoppingcart(id)
);


insert into account(login,name,pass) values('admin','admin','admin');
insert into account(login,name,pass) values('user','user','user');

INSERT INTO category (type,hot,aid) VALUES ('man',true,1);
INSERT INTO category (type,hot,aid) VALUES ('women',true,1);
INSERT INTO category (type,hot,aid) VALUES ('children',true,2);
INSERT INTO category (type,hot,aid) VALUES ('old age',true,2);


INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('zara costume',2999.00,'test.jpg','aaa','aaa',true,true,1);

INSERT INTO product (name,price,pic,remark,xremark,commend,open,cid) VALUES 
('Boss shirt',1999.00,'test.jpg','aaa','aaa',true,true,1);




INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user','jason','user','male','15216771570','nishengwus@gmail.com');

INSERT INTO user (login,name,pass,sex,phone,email)
VALUES ('user2','lora','user2','female','13812345679','20000@hotmail.com');


INSERT INTO status (status) VALUES ('not pay');
INSERT INTO status (status) VALUES ('payed');
INSERT INTO status (status) VALUES ('distribution');
INSERT INTO status (status) VALUES ('finished');


INSERT INTO shoppingcart (name,phone,remark,date,total,address,post,uid) VALUES ('bb','123','aa',default,200.3,'rue saint catheien','1000',1);
INSERT INTO shoppingcart (name,phone,remark,date,total,address,post,uid) VALUES ('bb','123','aa',default,200.3,'rue saint catheien','1000',2);
INSERT INTO shoppingcart (name,phone,remark,date,total,address,post,uid) VALUES ('bb','123','aa',default,200.3,'rue saint catheien','1000',2);


INSERT INTO sorder (name,price,number,pid,fid) VALUES ('zara costume',2999,3,15,201605001);
INSERT INTO sorder (name,price,number,pid,fid) VALUES ('zara costume',1999,5,16,201605001);


SELECT * FROM account;
SELECT * FROM category;
SELECT * FROM product;
SELECT * FROM user;
SELECT * FROM status;
SELECT * FROM shoppingcart;
SELECT * FROM sorder;
select sum(number) as 'turnover', name 'name' from sorder group by pid;