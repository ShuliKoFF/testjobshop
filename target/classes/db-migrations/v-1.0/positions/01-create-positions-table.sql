CREATE TABLE IF NOT EXISTS public.positions
(
  id                 BIGSERIAL NOT NULL,
  final_discount     INT4 NOT NULL,
  final_price        BIGINT NOT NULL,
  product_id         BIGINT NOT NULL,
  price_for_quantity BIGINT NOT NULL,
  quantity           INT4 NOT NULL,
  sale_id            BIGINT NOT NULL,

  CONSTRAINT positions_pk PRIMARY KEY (id),
  CONSTRAINT products_fk FOREIGN KEY (product_id)
  REFERENCES public.products (id) MATCH SIMPLE,
  CONSTRAINT sales_fk FOREIGN KEY (sale_id)
  REFERENCES public.sales (id) MATCH SIMPLE
  ON UPDATE NO ACTION
  ON DELETE NO ACTION
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.positions
  OWNER TO postgres;
