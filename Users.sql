-- Table: public."Users"

-- DROP TABLE public."Users";

CREATE TABLE public."Users"
(
    userid bigint NOT NULL DEFAULT nextval('"Users_userid_seq"'::regclass),
    firstname character varying COLLATE pg_catalog."default",
    lastname character varying COLLATE pg_catalog."default",
    username character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    usertype character varying COLLATE pg_catalog."default",
    CONSTRAINT userid PRIMARY KEY (userid),
    CONSTRAINT username UNIQUE (username)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Users"
    OWNER to postgres;