-- Table: public."Accounts"

-- DROP TABLE public."Accounts";

CREATE TABLE public."Accounts"
(
    accountnumber bigint NOT NULL DEFAULT nextval('"Accounts_accountnumber_seq"'::regclass),
    ownerid1 bigint NOT NULL DEFAULT nextval('"Accounts_ownerid1_seq"'::regclass),
    ownerid2 bigint NOT NULL DEFAULT nextval('"Accounts_ownerid2_seq"'::regclass),
    routingnumber bigint,
    accountbalance numeric(12,2),
    accounttype character varying COLLATE pg_catalog."default",
    accountstatus character varying COLLATE pg_catalog."default",
    CONSTRAINT accountnumber PRIMARY KEY (accountnumber),
    CONSTRAINT ownerid1 FOREIGN KEY (ownerid1)
        REFERENCES public."Users" (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT ownerid2 FOREIGN KEY (ownerid2)
        REFERENCES public."Users" (userid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Accounts"
    OWNER to postgres;