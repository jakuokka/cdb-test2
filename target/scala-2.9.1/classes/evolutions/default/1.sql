# --- First database schema

# --- !Ups

set ignorecase true;

create table race (
  id                        bigint not null,
  name                      varchar(255) not null,
  constraint pk_race primary key (id))
;

create table cat (
  id                        bigint not null,
  name                      varchar(255) not null,
  gender                    varchar(255) not null,
  color                     varchar(255) not null,
  birth                     timestamp,
  race_id                   bigint,
  constraint pk_cat primary key (id))
;

create sequence race_seq start with 1000;

create sequence cat_seq start with 1000;

alter table cat add constraint fk_cat_race_1 foreign key (race_id) references race (id) on delete restrict on update restrict;
create index ix_cat_race_1 on cat (race_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists race;

drop table if exists cat;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists race_seq;

drop sequence if exists cat_seq;

