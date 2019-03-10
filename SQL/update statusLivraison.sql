DROP TABLE statuslivraison cascade;

CREATE TABLE statuslivraison
(
  idstatuslivraison integer NOT NULL,
  idbl integer NOT NULL,
  status integer,
  datestatus date,
  motif character varying(250),
  CONSTRAINT pk_statuslivraison PRIMARY KEY (idstatuslivraison),
  CONSTRAINT fk_statusli_assoc_bl__bl FOREIGN KEY (idbl)
      REFERENCES bl (idbl) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE statuslivraison
  OWNER TO postgres;

-- Index: assoc_bl_statuslivraison_fk

-- DROP INDEX assoc_bl_statuslivraison_fk;

CREATE INDEX assoc_bl_statuslivraison_fk
  ON statuslivraison
  USING btree
  (idbl);

-- Index: statuslivraison_pk

-- DROP INDEX statuslivraison_pk;

CREATE UNIQUE INDEX statuslivraison_pk
  ON statuslivraison
  USING btree
  (idstatuslivraison);