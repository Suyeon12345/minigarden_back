-- auto-generated definition
create table EMP240118
(
    e_code    NUMBER(10) not null
        constraint EMP240118_PK
            primary key,
    e_name    VARCHAR2(20),
    e_gender  NUMBER(1)  not null,
    e_phone VARCHAR2(20)
)
/

