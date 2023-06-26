CREATE TABLE IF NOT EXISTS public.product_ratings
(
  id         BIGSERIAL NOT NULL,
  rating     INT4,
  client_id  BIGINT    NOT NULL,
  product_id BIGINT    NOT NULL,

  CONSTRAINT product_ratings_pk PRIMARY KEY (id),
  CONSTRAINT products_fk FOREIGN KEY (product_id)
  REFERENCES public.products (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)

TABLESPACE pg_default;
ALTER TABLE IF EXISTS public.product_ratings
  OWNER TO postgres;

