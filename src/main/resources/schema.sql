create table accounts 
(
   id integer not null auto_increment,
   customer_id integer not null,
   account_name varchar(255) not null, 
   balance numeric not null,
   primary key(id)
);
   
create table transactions 
(
   id integer not null auto_increment,
   account_id integer not null,
   amount numeric not null,
   timeof timestamp default current_timestamp,
   primary key(id),
   foreign key (account_id) references accounts(id)
);

INSERT INTO accounts (customer_id, account_name, balance) values
(1, 'everyday', 100),
(1, 'savings', 300);


INSERT INTO transactions (account_id, amount, timeof) VALUES
(1, 0, {ts '2023-06-18 18:47:52.69'}),
(1, 100, {ts '2023-06-19 18:47:52.69'}),
(1, -100, {ts '2023-06-20 18:47:52.69'}),
(1, 100, {ts '2023-06-21 18:47:52.69'});

/*
INSERT INTO TEST VALUES(2, {ts '2012-09-17 18:47:52.69'});

INSERT INTO transactions (account_id, amount) VALUES 
(1, 0),
(1, 100),
(1, -100),
(1, 100),
(2, 0),
(2, 50),
(2, 100),
(2, 3000),
(2, -3150),
(2, 300);

INSERT INTO transactions (account_id, amount, timeof) VALUES (1, 0, TO_TIMESTAMP(' 2020-07-10 15:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO TEST (ID, DATE) VALUES(1,
parsedatetime('17-09-2012 18:47:52.69', 'dd-MM-yyyy hh:mm:ss.SS'))

*/