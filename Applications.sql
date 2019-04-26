-- Table: public."Applications"

-- DROP TABLE public."Applications";

CREATE TABLE public."Applications"
(
    applicationid bigint NOT NULL DEFAULT nextval('"Applications_applicationid_seq"'::regclass),
    firstname character varying COLLATE pg_catalog."default",
    lastname character varying COLLATE pg_catalog."default",
    username character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    usertype character varying COLLATE pg_catalog."default",
    accounttype character varying COLLATE pg_catalog."default",
    depositamount numeric(12,2),
    status character varying COLLATE pg_catalog."default",
    currentuser bigint,
    currentuser2 bigint,
    firstname2 character varying COLLATE pg_catalog."default",
    lastname2 character varying COLLATE pg_catalog."default",
    username2 character varying COLLATE pg_catalog."default",
    password2 character varying COLLATE pg_catalog."default",
    CONSTRAINT applicationid PRIMARY KEY (applicationid)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Applications"
    OWNER to postgres;