DROP TABLE IF EXISTS bookmarks;
DROP SEQUENCE IF EXISTS bm_id_seq;
create sequence bm_id_seq start with 1 increment by 50;

create table bookmarks (
    id bigint default nextval('bm_id_seq') not null,
    title varchar(255) not null,
    createdAt timestamp,
    primary key(id)
);