CREATE TABLE IF NOT EXISTS public.products
(
  id           BIGSERIAL NOT NULL,
  description  VARCHAR(255) NOT NULL,
  discount     INT4 NOT NULL,
  name         VARCHAR(255) NOT NULL,
  price        BIGINT NOT NULL,
  uuid         UUID      NOT NULL,
  CONSTRAINT products_pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
  OWNER TO postgres;