create database lms;
use lms;

DROP TABLE IF EXISTS manager;
create table manager (
manager_id int NOT NULL,
manager_name varchar(30) NOT NULL,
manager_username varchar(30) NOT NULL,
manager_pass varchar(30) NOT NULL,
primary key (manager_id) 
);

DROP TABLE IF EXISTS users;
create table users(
user_id int NOT NULL auto_increment,
user_name varchar(30) NOT NULL,
user_username varchar(30) NOT NULL,
user_pass varchar(30) NOT NULL,
user_phone varchar(11),
primary key(user_id)
);

DROP TABLE IF EXISTS publishers;
create table publishers(
publisher_id int NOT NULL auto_increment, 
publisher_name varchar(30) NOT NULL,
publisher_username varchar(30) NOT NULL,
publisher_pass varchar(30) NOT NULL,
publisher_phone varchar(11),
primary key (publisher_id)
);

DROP TABLE IF EXISTS books;
create table books(
book_id int NOT NULL auto_increment,
book_title varchar(30) NOT NULL,
book_author varchar(30) NOT NULL,
book_genre varchar(30) NOT NULL,
book_topics varchar(30) NOT NULL,
publisher_id int,
year_published int NOT NULL,
book_available varchar(10),
status varchar(20),
primary key (book_id),
constraint books_publishers foreign key(publisher_id) references publishers(publisher_id)
);

DROP TABLE IF EXISTS borrower_details;
create table borrower_details(
user_id int,
book_id int,
borrowed_on datetime,
due_date date,
return_date datetime,
days_overdue int,
penalty_charged varchar(10),
constraint borrowed_by_users foreign key(user_id) references users(user_id),
constraint borrowed_by_books foreign key(book_id) references books(book_id),
primary key (user_id, book_id)
);







