CREATE TABLE IF NOT EXISTS public.sales
(
  id           BIGSERIAL NOT NULL,
  client_id    BIGINT    NOT NULL,
  date         TIMESTAMP NOT NULL,
  check_number INT4      NOT NULL,
  CONSTRAINT sales_pk PRIMARY KEY (id),
  CONSTRAINT clients_fk FOREIGN KEY (client_id)
  REFERENCES public.clients (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.sales
  OWNER TO postgres;

CREATE SEQUENCE public.check_number_seq
CYCLE
INCREMENT 1
START 100
MINVALUE 100
MAXVALUE 2147483647
CACHE 1
OWNED BY sales.check_number;

ALTER SEQUENCE public.check_number_seq
OWNER TO postgres;

ALTER TABLE IF EXISTS public.sales
ALTER COLUMN check_number SET DEFAULT nextval('check_number_seq'::regclass);

