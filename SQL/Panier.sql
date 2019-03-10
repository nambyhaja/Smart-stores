
/*==============================================================*/
/* Table : PANIER                                               */
/*==============================================================*/
create table PANIER (
   IDPANIER             INT4                 not null,
   IDCLIENT             INT4                 not null,
   constraint PK_PANIER primary key (IDPANIER)
);

/*==============================================================*/
/* Index : PANIER_PK                                            */
/*==============================================================*/
create unique index PANIER_PK on PANIER (
IDPANIER
);

/*==============================================================*/
/* Index : ASSOC_CLIENT_PANIER_FK                               */
/*==============================================================*/
create  index ASSOC_CLIENT_PANIER_FK on PANIER (
IDCLIENT
);

/*==============================================================*/
/* Table : PRODUITPANIER                                        */
/*==============================================================*/
create table PRODUITPANIER (
   IDPRODUITPANIER      INT4                 not null,
   IDPANIER             INT4                 not null,
   IDPRODUIT            INT4                 not null,
   QUANTITE             INT4                 null,
   constraint PK_PRODUITPANIER primary key (IDPRODUITPANIER)
);

/*==============================================================*/
/* Index : PRODUITPANIER_PK                                     */
/*==============================================================*/
create unique index PRODUITPANIER_PK on PRODUITPANIER (
IDPRODUITPANIER
);

/*==============================================================*/
/* Index : ASSOC_PANIER_PRODUITPANIER_FK                        */
/*==============================================================*/
create  index ASSOC_PANIER_PRODUITPANIER_FK on PRODUITPANIER (
IDPANIER
);

/*==============================================================*/
/* Index : ASSOC_PRODUIT_PRODUITPANIER_FK                       */
/*==============================================================*/
create  index ASSOC_PRODUIT_PRODUITPANIER_FK on PRODUITPANIER (
IDPRODUIT
);


alter table PANIER
   add constraint FK_PANIER_ASSOC_CLI_CLIENT foreign key (IDCLIENT)
      references CLIENT (IDCLIENT)
      on delete restrict on update restrict;

alter table PRODUITPANIER
   add constraint FK_PRODUITP_ASSOC_PAN_PANIER foreign key (IDPANIER)
      references PANIER (IDPANIER)
      on delete restrict on update restrict;

alter table PRODUITPANIER
   add constraint FK_PRODUITP_ASSOC_PRO_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT)
      on delete restrict on update restrict;
