create sequence hibernate_sequence start 1 increment 1;

create table car (
  id int8 not null,
  createddate timestamp,
  is_deleted boolean not null,
  updated_date timestamp,
  color varchar(255),
  mark varchar(255),
  model varchar(255),
  vin varchar(255),
  primary key (id)
);

create table user_role (
  user_id int8 not null,
  roles varchar(255)
);

create table users (
  id int8 not null,
  createddate timestamp,
  is_deleted boolean not null,
  updated_date timestamp,
  activation_code varchar(255),
  active boolean not null,
  email varchar(255),
  password varchar(255),
  username varchar(255),
  primary key (id)
);

alter table if exists user_role add constraint userRoles foreign key (user_id) references users;