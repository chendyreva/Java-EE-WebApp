create table products(
                                                  id bigserial primary key,
                                                  name varchar(50) not null,
                                                  description varchar(80) not null unique,
                                                  price int
                         )