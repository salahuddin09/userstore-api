CREATE TABLE IF NOT EXISTS users_tbl
(
    id SERIAL NOT NULL,
    country character varying(255) ,
    name character varying(255) NOT NULL,
    progress_id bigint NULL,
    CONSTRAINT users_tbl_pkey PRIMARY KEY (id)
);

