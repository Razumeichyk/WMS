
    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM

    insert into hibernate_sequence values ( 1 )

    create table Product (
       id bigint not null,
        name varchar(255),
        quantity integer,
        primary key (id)
    ) engine=MyISAM

    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM

    insert into hibernate_sequence values ( 1 )

    create table products (
       id bigint not null,
        name varchar(255),
        quantity integer,
        primary key (id)
    ) engine=MyISAM

    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM

    insert into hibernate_sequence values ( 1 )

    create table products (
       id bigint not null,
        name varchar(255),
        quantity integer,
        primary key (id)
    ) engine=MyISAM
