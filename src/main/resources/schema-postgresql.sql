CREATE TABLE "booking_resources"
(
    "booking_resources_id" INTEGER NOT NULL,
    "resource_id"          INTEGER NOT NULL,
    "duration_time"        INTEGER NOT NULL,
    "user_id"              INTEGER NOT NULL,
    "status_id"            INTEGER NOT NULL,
    "start_booking"        DATE    NOT NULL,
    "end_booking"          DATE    NOT NULL
);
ALTER TABLE
    "booking_resources"
    ADD PRIMARY KEY ("booking_resources_id");
CREATE TABLE "users"
(
    "user_id"     INTEGER          NOT NULL,
    "access_code" INTEGER          NOT NULL,
    "login"       VARCHAR(255)     NOT NULL,
    "email"       VARCHAR(255)     NOT NULL,
    "phone"       VARCHAR(255)     NOT NULL,
    "address"     VARCHAR(255)     NOT NULL,
    "balance"     DECIMAL(10, 2) DEFAULT 0.00
);
ALTER TABLE
    "users"
    ADD PRIMARY KEY ("user_id");
CREATE TABLE "roles"
(
    "role_id"   INTEGER   NOT NULL,
    "role_name" CHAR(255) NOT NULL
);
ALTER TABLE
    "roles"
    ADD PRIMARY KEY ("role_id");
CREATE TABLE "users_roles"
(
    "user_id" INTEGER NOT NULL,
    "role_id" INTEGER NOT NULL
);
CREATE TABLE "resource_type"
(
    "resource_type_id"   INTEGER          NOT NULL,
    "resource_type_name" VARCHAR(255)     NOT NULL,
    "resource_type_cost" DECIMAL(10, 2) DEFAULT 0.00
);
ALTER TABLE
    "resource_type"
    ADD PRIMARY KEY ("resource_type_id");
CREATE TABLE "notifications"
(
    "notification_id"   INTEGER      NOT NULL,
    "user_id"           INTEGER      NOT NULL,
    "notification_text" VARCHAR(255) NOT NULL,
    "creation_data"     DATE         NOT NULL
);
ALTER TABLE
    "notifications"
    ADD PRIMARY KEY ("notification_id");
CREATE TABLE "status"
(
    "status_id"   INTEGER      NOT NULL,
    "status_name" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "status"
    ADD PRIMARY KEY ("status_id");
CREATE TABLE "transaction_history"
(
    "transaction_history_id" INTEGER          NOT NULL,
    "user_id"                INTEGER          NOT NULL,
    "operation_sum"          DECIMAL(10, 2) DEFAULT 0.00,
    "operation"              VARCHAR(255) CHECK
        ("operation" IN ('INCREASE', 'DECREASE')) NOT NULL,
    "description"            VARCHAR(255)     NOT NULL,
    "modification_date"      DATE             NOT NULL
);
ALTER TABLE
    "transaction_history"
    ADD PRIMARY KEY ("transaction_history_id");
CREATE TABLE "resource"
(
    "resource_id"            INTEGER      NOT NULL,
    "resource_identificator" VARCHAR(255) NOT NULL,
    "resource_type_id"       INTEGER      NOT NULL,
    "status_id"              INTEGER      NOT NULL
);
ALTER TABLE
    "resource"
    ADD PRIMARY KEY ("resource_id");
ALTER TABLE
    "users_roles"
    ADD CONSTRAINT "users_roles_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "transaction_history"
    ADD CONSTRAINT "transaction_history_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "booking_resources"
    ADD CONSTRAINT "booking_resources_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "users_roles"
    ADD CONSTRAINT "users_roles_role_id_foreign" FOREIGN KEY ("role_id") REFERENCES "roles" ("role_id");
ALTER TABLE
    "notifications"
    ADD CONSTRAINT "notifications_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "resource"
    ADD CONSTRAINT "resource_resource_type_id_foreign" FOREIGN KEY ("resource_type_id") REFERENCES "resource_type" ("resource_type_id");
ALTER TABLE
    "resource"
    ADD CONSTRAINT "resource_status_id_foreign" FOREIGN KEY ("status_id") REFERENCES "status" ("status_id");
ALTER TABLE
    "booking_resources"
    ADD CONSTRAINT "booking_resources_status_id_foreign" FOREIGN KEY ("status_id") REFERENCES "status" ("status_id");
ALTER TABLE
    "booking_resources"
    ADD CONSTRAINT "booking_resources_resource_id_foreign" FOREIGN KEY ("resource_id") REFERENCES "resource" ("resource_id");