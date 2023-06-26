CREATE TABLE IF NOT EXISTS public.clients
(
  id           BIGSERIAL NOT NULL,
  discount_one INT4 NOT NULL,
  discount_two INT4 NOT NULL,
  name         VARCHAR(255) NOT NULL,
  uuid         UUID NOT NULL,
  CONSTRAINT clients_pk PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clients
  OWNER TO postgres;