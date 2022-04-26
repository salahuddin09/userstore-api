CREATE TABLE IF NOT EXISTS userprogress_tbl
(
    id SERIAL NOT NULL,
    level integer,
    score double precision,
    CONSTRAINT userprogress_tbl_pkey PRIMARY KEY (id)
);


ALTER TABLE users_tbl
    ADD CONSTRAINT "unique_progress_id" UNIQUE (progress_id);

ALTER TABLE users_tbl
    ADD CONSTRAINT "fk_users_userprogress" FOREIGN KEY (progress_id) REFERENCES userprogress_tbl (id) 
MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION;