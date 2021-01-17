INSERT INTO manager(manager_id, manager_name, manager_username, manager_pass) values
(1, 'bakr', 'bakr123', 'password'), 
(2, 'iliyar', 'iliyar123', 'password');

INSERT INTO users (user_name, user_username, user_pass, user_phone) values
('ali', 'ali123', 'password', '00112233445'),
('kemal', 'kemal123', 'password', '11223344556');

INSERT INTO publishers(publisher_name, publisher_username, publisher_pass, publisher_phone) values
('pearson', 'pearson123', 'password', 00011100011),
('oxford', 'oxford123', 'password', 11100011100);

INSERT INTO books(book_title, book_author, book_genre, book_topics, publisher_id, year_published, book_available, status) values
('Angels and Demons', 'Dan Brown', 'fiction', 'fiction', 1, 2000, 'yes', 'Borrowed'),
('Database Management Systems', 'Ramakrishnan', 'non-fiction', 'Normalization', 2, 2003, 'no', 'Not Borrowed');

INSERT INTO borrower_details(user_id, book_id, borrowed_on, due_date, return_date, days_overdue, penalty_charged) values
(1, 1, '2020-12-20 03:14:07', '2020-12-25', '2020-12-16 05:14:07', 1, '$10'),
(2, 2, '2020-12-18 12:14:07', '2020-12-23', '2020-12-23 20:14:07', 0, '$0');
