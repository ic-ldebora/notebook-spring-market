create table category
(
    "id"          serial       not null,
    "description" varchar(255) not null,
    "status"      boolean      not null,
    primary key ("id")
);

create table product
(
    "id"             serial         not null,
    "name"           varchar(255)   null,
    "category_id"    int            not null,
    "barcode"        varchar(255)   null,
    "sale_price"     decimal(16, 2) null,
    "stock_quantity" int            not null,
    "status"         boolean        null,
    primary key ("id"),
    constraint "fk_product_category"
        foreign key ("category_id")
            references category ("id")
            on delete no action
            on update no action
);

create table client
(
    "id"         varchar(255) not null,
    "first_name" varchar(255) null,
    "last_name"  varchar(255) null,
    "cellphone"  numeric      null,
    "address"    varchar(255) null,
    "email"      varchar(255) null,
    primary key ("id")
);

create table purchase
(
    "id"           serial       not null,
    "client_id"    varchar(255) not null,
    "date"         timestamp    null,
    "half_payment" char(1)      null,
    "comment"      varchar(255) null,
    "status"       char(1)      null,
    primary key ("id"),
    constraint "fk_purchase_client"
        foreign key ("client_id")
            references client ("id")
            on delete no action
            on update no action
);

create table purchase_product
(
    "purchase_id" int            not null,
    "product_id"  int            not null,
    "quantity"    int            null,
    "total"       decimal(16, 2) null,
    "status"      boolean        null,
    primary key ("purchase_id", "product_id"),
    constraint "fk_purchase_product_product"
        foreign key ("product_id")
            references product ("id")
            on delete no action
            on update no action,
    constraint "fk_purchase_product_purchase"
        foreign key ("purchase_id")
            references purchase ("id")
            on delete no action
            on update no action
);
