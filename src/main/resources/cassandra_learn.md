##建立集群


## 建空间
CREATE KEYSPACE spacenametest
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

##删除空间 
DROP KEYSPACE spacenametest

## 验证空间
Describe spacenametest

## 使用空间
use spacenametest;

## 建表
##多个主键
CREATE TABLE student(
  id int,
  name text,
  age int,
  PRIMARY KEY (id,name)1
)

## 或者
## 一个主键
CREATE TABLE student(
  id int PRIMARY KEY,
  name text,
  age int,
  PRIMARY KEY
)

