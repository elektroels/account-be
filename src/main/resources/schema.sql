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