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
(1, 'savings', -1);


INSERT INTO transactions (account_id, amount, timeof) VALUES
(1, 0, {ts '2023-06-18 18:47:52.69'}),
(1, 100, {ts '2023-06-19 18:47:52.69'}),
(1, -100, {ts '2023-06-20 18:47:52.69'}),
(1, 100, {ts '2023-06-21 18:47:52.69'}),
(2, 0, {ts '2012-09-14 18:47:52.69'}),
(2, 50, {ts '2012-09-16 18:47:52.69'}),
(2, 100, {ts '2012-09-18 18:47:52.69'}),
(2, 3000, {ts '2012-09-20 18:47:52.69'}),
(2, -3151, {ts '2012-09-22 18:47:52.69'});
