
/*==============================================================*/
/* Table : BC                                                   */
/*==============================================================*/
create table BC (
   IDBC                 INT4                 not null,
   IDCLIENT             INT4                 not null,
   DATECOMMANDE         DATE                 null,
   UIDBC                  VARCHAR(50)          null,
   constraint PK_BC primary key (IDBC)
);

/*==============================================================*/
/* Index : BC_PK                                                */
/*==============================================================*/
create unique index BC_PK on BC (
IDBC
);

/*==============================================================*/
/* Index : ASSOC_BC_CLIENT_FK                                   */
/*==============================================================*/
create  index ASSOC_BC_CLIENT_FK on BC (
IDCLIENT
);

/*==============================================================*/
/* Table : BL                                                   */
/*==============================================================*/
create table BL (
   IDBL                 INT4                 not null,
   IDLIVREUR            INT4                 not null,
   IDFACTURE            INT4                 not null,
   DATEDEBUT            DATE                 null,
   DATEFIN              DATE                 null,
   constraint PK_BL primary key (IDBL)
);

/*==============================================================*/
/* Index : BL_PK                                                */
/*==============================================================*/
create unique index BL_PK on BL (
IDBL
);

/*==============================================================*/
/* Index : ASSOC_FACTURE_BL_FK                                  */
/*==============================================================*/
create  index ASSOC_FACTURE_BL_FK on BL (
IDFACTURE
);

/*==============================================================*/
/* Index : ASSOC_BL_LIVREUR_FK                                  */
/*==============================================================*/
create  index ASSOC_BL_LIVREUR_FK on BL (
IDLIVREUR
);

/*==============================================================*/
/* Table : CATEGORIE                                            */
/*==============================================================*/
create table CATEGORIE (
   IDCATEGORIE          INT4                 not null,
   DESIGNATION          VARCHAR(250)         null,
   constraint PK_CATEGORIE primary key (IDCATEGORIE)
);

/*==============================================================*/
/* Index : CATEGORIE_PK                                         */
/*==============================================================*/
create unique index CATEGORIE_PK on CATEGORIE (
IDCATEGORIE
);

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT (
   IDCLIENT             INT4                 not null,
   NOM                  VARCHAR(50)          null,
   PRENOM               VARCHAR(50)          null,
   LOGIN                VARCHAR(50)          null,
   MOTDEPASSE           VARCHAR(250)         null,
   constraint PK_CLIENT primary key (IDCLIENT)
);

/*==============================================================*/
/* Index : CLIENT_PK                                            */
/*==============================================================*/
create unique index CLIENT_PK on CLIENT (
IDCLIENT
);

/*==============================================================*/
/* Table : DETAILCOMMANDE                                       */
/*==============================================================*/
create table DETAILCOMMANDE (
   IDDETAILCOMMANDE     INT4                 not null,
   IDPRODUIT            INT4                 not null,
   IDBC                 INT4                 not null,
   NOMBRE               INT4                 null,
   constraint PK_DETAILCOMMANDE primary key (IDDETAILCOMMANDE)
);

/*==============================================================*/
/* Index : DETAILCOMMANDE_PK                                    */
/*==============================================================*/
create unique index DETAILCOMMANDE_PK on DETAILCOMMANDE (
IDDETAILCOMMANDE
);

/*==============================================================*/
/* Index : ASSOC_PRODUIT_DETAILCOMMANDE_FK                      */
/*==============================================================*/
create  index ASSOC_PRODUIT_DETAILCOMMANDE_FK on DETAILCOMMANDE (
IDPRODUIT
);

/*==============================================================*/
/* Index : ASSOC_DETAICOMMANDE_BC_FK                            */
/*==============================================================*/
create  index ASSOC_DETAICOMMANDE_BC_FK on DETAILCOMMANDE (
IDBC
);

/*==============================================================*/
/* Table : FACTURE                                              */
/*==============================================================*/
create table FACTURE (
   IDFACTURE            INT4                 not null,
   IDBC                 INT4                 not null,
   REMISE               NUMERIC              null,
   constraint PK_FACTURE primary key (IDFACTURE)
);

/*==============================================================*/
/* Index : FACTURE_PK                                           */
/*==============================================================*/
create unique index FACTURE_PK on FACTURE (
IDFACTURE
);

/*==============================================================*/
/* Index : ASSOC_BC_FACTURE_FK                                  */
/*==============================================================*/
create  index ASSOC_BC_FACTURE_FK on FACTURE (
IDBC
);

/*==============================================================*/
/* Table : LIVREUR                                              */
/*==============================================================*/
create table LIVREUR (
   IDLIVREUR            INT4                 not null,
   NOM                  VARCHAR(50)          null,
   PRENOM               VARCHAR(50)          null,
   LOGIN                VARCHAR(50)          null,
   MOTDEPASSE           VARCHAR(250)         null,
   constraint PK_LIVREUR primary key (IDLIVREUR)
);

/*==============================================================*/
/* Index : LIVREUR_PK                                           */
/*==============================================================*/
create unique index LIVREUR_PK on LIVREUR (
IDLIVREUR
);

/*==============================================================*/
/* Table : PRIX                                                 */
/*==============================================================*/
create table PRIX (
   IDPRIX               INT4                 not null,
   IDPRODUIT            INT4                 not null,
   PRIXUNITAIRE         NUMERIC              null,
   DATEPRIX                 DATE                 null,
   constraint PK_PRIX primary key (IDPRIX)
);

/*==============================================================*/
/* Index : PRIX_PK                                              */
/*==============================================================*/
create unique index PRIX_PK on PRIX (
IDPRIX
);

/*==============================================================*/
/* Index : ASSOC_PRODUIT_PRIX_FK                                */
/*==============================================================*/
create  index ASSOC_PRODUIT_PRIX_FK on PRIX (
IDPRODUIT
);

/*==============================================================*/
/* Table : PRODUIT                                              */
/*==============================================================*/
create table PRODUIT (
   IDPRODUIT            INT4                 not null,
   IDCATEGORIE          INT4                 not null,
   CODE                 VARCHAR(50)          null,
   DESIGNATION          VARCHAR(250)         null,
   DESCRIPTION          VARCHAR(250)         null,
   UID                  VARCHAR(50)          null,
   PHOTO                VARCHAR(50)          null,
   PRIX                 NUMERIC              null,
   TVA                  NUMERIC              null,
   constraint PK_PRODUIT primary key (IDPRODUIT)
);

/*==============================================================*/
/* Index : PRODUIT_PK                                           */
/*==============================================================*/
create unique index PRODUIT_PK on PRODUIT (
IDPRODUIT
);

/*==============================================================*/
/* Index : ASSOC_PRODUIT_CATEGORIE_FK                           */
/*==============================================================*/
create  index ASSOC_PRODUIT_CATEGORIE_FK on PRODUIT (
IDCATEGORIE
);

/*==============================================================*/
/* Table : STATUSLIVRAISON                                      */
/*==============================================================*/
create table STATUSLIVRAISON (
   IDSTATUSLIVRAISON    INT4                 not null,
   IDBL                 INT4                 not null,
   STATUS               BOOL                 null,
   DATESTATUS           DATE                 null,
   MOTIF                VARCHAR(250)         null,
   constraint PK_STATUSLIVRAISON primary key (IDSTATUSLIVRAISON)
);

/*==============================================================*/
/* Index : STATUSLIVRAISON_PK                                   */
/*==============================================================*/
create unique index STATUSLIVRAISON_PK on STATUSLIVRAISON (
IDSTATUSLIVRAISON
);

/*==============================================================*/
/* Index : ASSOC_BL_STATUSLIVRAISON_FK                          */
/*==============================================================*/
create  index ASSOC_BL_STATUSLIVRAISON_FK on STATUSLIVRAISON (
IDBL
);

/*==============================================================*/
/* Table : STOCK                                                */
/*==============================================================*/
create table STOCK (
   IDSTOCK              INT4                 not null,
   IDPRODUIT            INT4                 not null,
   NOMBRE               INT4                 not null,
   SEUIL                INT4                 not null,
   constraint PK_STOCK primary key (IDSTOCK)
);

/*==============================================================*/
/* Index : STOCK_PK                                             */
/*==============================================================*/
create unique index STOCK_PK on STOCK (
IDSTOCK
);

/*==============================================================*/
/* Index : ASSOC_STOCK_PRODUIT_FK                               */
/*==============================================================*/
create  index ASSOC_STOCK_PRODUIT_FK on STOCK (
IDPRODUIT
);

/*==============================================================*/
/* Table : TVA                                                  */
/*==============================================================*/
create table TVA (
   IDTVA                INT4                 not null,
   IDPRODUIT            INT4                 not null,
   DATEAPPLICATION      DATE                 null,
   TAUX                 NUMERIC              null,
   constraint PK_TVA primary key (IDTVA)
);

/*==============================================================*/
/* Index : TVA_PK                                               */
/*==============================================================*/
create unique index TVA_PK on TVA (
IDTVA
);

/*==============================================================*/
/* Index : ASSOC_PRODUIT_TVA_FK                                 */
/*==============================================================*/
create  index ASSOC_PRODUIT_TVA_FK on TVA (
IDPRODUIT
);

/*==============================================================*/
/* Table : VENDEUR                                              */
/*==============================================================*/
create table VENDEUR (
   IDVENDEUR            INT4                 not null,
   NOM                  VARCHAR(50)          null,
   PRENOM               VARCHAR(50)          null,
   LOGIN                VARCHAR(50)          null,
   MOTDEPASSE           VARCHAR(250)         null,
   constraint PK_VENDEUR primary key (IDVENDEUR)
);

/*==============================================================*/
/* Index : VENDEUR_PK                                           */
/*==============================================================*/
create unique index VENDEUR_PK on VENDEUR (
IDVENDEUR
);

alter table BC
   add constraint FK_BC_ASSOC_BC__CLIENT foreign key (IDCLIENT)
      references CLIENT (IDCLIENT)
      on delete restrict on update restrict;

alter table BL
   add constraint FK_BL_ASSOC_BL__LIVREUR foreign key (IDLIVREUR)
      references LIVREUR (IDLIVREUR)
      on delete restrict on update restrict;

alter table BL
   add constraint FK_BL_ASSOC_FAC_FACTURE foreign key (IDFACTURE)
      references FACTURE (IDFACTURE)
      on delete restrict on update restrict;

alter table DETAILCOMMANDE
   add constraint FK_DETAILCO_ASSOC_DET_BC foreign key (IDBC)
      references BC (IDBC)
      on delete restrict on update restrict;

alter table DETAILCOMMANDE
   add constraint FK_DETAILCO_ASSOC_PRO_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT)
      on delete restrict on update restrict;

alter table FACTURE
   add constraint FK_FACTURE_ASSOC_BC__BC foreign key (IDBC)
      references BC (IDBC)
      on delete restrict on update restrict;

alter table PRIX
   add constraint FK_PRIX_ASSOC_PRO_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT)
      on delete restrict on update restrict;

alter table PRODUIT
   add constraint FK_PRODUIT_ASSOC_PRO_CATEGORI foreign key (IDCATEGORIE)
      references CATEGORIE (IDCATEGORIE)
      on delete restrict on update restrict;

alter table STATUSLIVRAISON
   add constraint FK_STATUSLI_ASSOC_BL__BL foreign key (IDBL)
      references BL (IDBL)
      on delete restrict on update restrict;

alter table STOCK
   add constraint FK_STOCK_ASSOC_STO_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT)
      on delete restrict on update restrict;

alter table TVA
   add constraint FK_TVA_ASSOC_PRO_PRODUIT foreign key (IDPRODUIT)
      references PRODUIT (IDPRODUIT)
      on delete restrict on update restrict;

