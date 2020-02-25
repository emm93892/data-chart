create table account(
    user_id SERIAL primary key not null ,
    passphrase text not null ,
    user_name text not null unique
);

create table history(
    user_id Integer not null ,
    data_id SERIAL primary key not null ,
    data_name text not null ,
    date timestamp not null,
    foreign key (user_id) references account(user_id)
);

create table save_data(
    data_id Serial primary key not null ,
    binary_data bytea not null,
    foreign key (data_id) references history(data_id)
);

insert into account(passphrase, user_name)
    values ('admin','admin');