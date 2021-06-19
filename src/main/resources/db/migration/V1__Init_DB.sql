drop table if exists ph_user;
drop table if exists ph_role;

create table ph_user (
    id bigint not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    gender varchar(255) not null,
    name varchar(255) not null,
    surname varchar(255) not null,
    birthdate date not null,
    primary key (id)
                  );

create table ph_role (
    id bigint not null auto_increment,
    role_type varchar(255),
    primary key (id)
                     );

create table ph_user_roles (
    ph_user_id bigint not null,
    roles_id            bigint not null,
    primary key (ph_user_id, roles_id)
                             );

alter table ph_user_roles add constraint ph_user_roles_fk0 foreign key (ph_user_id) references ph_user (id);
alter table ph_user_roles add constraint ph_user_roles_fk1 foreign key (roles_id) references ph_role (id);


