/*
drop table if exists save_data;
drop table if exists history;
drop table if exists account;

create table if not exists account
(
    user_id    SERIAL primary key not null,
    passphrase text               not null,
    user_name  text               not null unique

);

create table if not exists history(
    user_id Integer not null ,
    data_id SERIAL primary key  not null ,
    data_name text not null ,
    date timestamp not null ,
    foreign key (user_id) references account(user_id)

);

create table if not exists save_data(
    data_id Serial primary key not null ,
    binary_data bytea not null ,
    foreign key (data_id) references history(data_id)
);

 */