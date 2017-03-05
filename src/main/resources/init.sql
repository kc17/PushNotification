-- init database and account
CREATE DATABASE push DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
GRANT all ON *.* TO 'admin'@'%' identified by 'admin' ;
GRANT all ON *.* TO 'admin'@'localhost' identified by 'admin' ;