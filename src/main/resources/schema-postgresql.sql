CREATE TABLE "booking_resources"
(
    "resource_id"      INTEGER NOT NULL,
    "resource_type_id" INTEGER NOT NULL,
    "status_id"        INTEGER NOT NULL,
    "duration_time"    INTEGER NOT NULL,
    "start_booking"    DATE    NOT NULL,
    "end_booking"      DATE    NOT NULL
);
ALTER TABLE
    "booking_resources"
    ADD PRIMARY KEY ("resource_id");
CREATE TABLE "users"
(
    "user_id"     INTEGER      NOT NULL,
    "access_code" INTEGER      NOT NULL,
    "login"       VARCHAR(255) NOT NULL,
    "email"       VARCHAR(255) NOT NULL
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
CREATE TABLE "residents"
(
    "resident_id"         INTEGER          NOT NULL,
    "user_id"             INTEGER          NOT NULL,
    "residential_address" VARCHAR(255)     NOT NULL,
    "phone"               VARCHAR(255)     NOT NULL,
    "balance"             DECIMAL(10,2) DEFAULT 0.00
);
ALTER TABLE
    "residents"
    ADD PRIMARY KEY ("resident_id");
CREATE TABLE "managers"
(
    "manager_id" INTEGER      NOT NULL,
    "user_id"    INTEGER      NOT NULL,
    "name"       VARCHAR(255) NOT NULL,
    "surname"    VARCHAR(255) NOT NULL,
    "job_title"  VARCHAR(255) NOT NULL
);
ALTER TABLE
    "managers"
    ADD PRIMARY KEY ("manager_id");
CREATE TABLE "booking_resources_residents"
(
    "resident_id" INTEGER NOT NULL,
    "resource_id" INTEGER NOT NULL
);
CREATE TABLE "users_roles"
(
    "user_id" INTEGER NOT NULL,
    "role_id" INTEGER NOT NULL
);
CREATE TABLE "resource_type"
(
    "resource_type_id"   INTEGER          NOT NULL,
    "reSource_type_name" VARCHAR(255)     NOT NULL,
    "reSource_type_cost" DECIMAL(10,2) DEFAULT 0.00
);
ALTER TABLE
    "recource_type"
    ADD PRIMARY KEY ("recource_type_id");
CREATE TABLE "notifications"
(
    "notification_id"   INTEGER      NOT NULL,
    "manager_id"        INTEGER      NOT NULL,
    "notification_text" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "notifications"
    ADD PRIMARY KEY ("notification_id");
CREATE TABLE "passports"
(
    "passport_number"      VARCHAR(255) NOT NULL,
    "resident_id"          INTEGER      NOT NULL,
    "name"                 VARCHAR(255) NOT NULL,
    "surname"              VARCHAR(255) NOT NULL,
    "gender"               VARCHAR(255) CHECK
        ("gender" IN ('MALE', 'FEMALE'))     NOT NULL,
    "nationality"          VARCHAR(255) NOT NULL,
    "registration_address" VARCHAR(255) NOT NULL,
    "birth_date"           DATE         NOT NULL,
    "expire_date"          DATE         NOT NULL
);
ALTER TABLE
    "passports"
    ADD PRIMARY KEY ("passport_number");
CREATE TABLE "status"
(
    "status_id"   INTEGER NOT NULL,
    "status_name" INTEGER NOT NULL
);
ALTER TABLE
    "status"
    ADD PRIMARY KEY ("status_id");
CREATE TABLE "sending_notifications"
(
    "resident_id"     INTEGER NOT NULL,
    "notification_id" INTEGER NOT NULL
);
CREATE TABLE "balance_history"
(
    "balance_history_id" INTEGER          NOT NULL,
    "resident_id"        INTEGER          NOT NULL,
    "operation_sum"      DECIMAL(10,2) DEFAULT 0.00,
    "operation"          VARCHAR(255) CHECK
        ("operation" IN ('INCREASE', 'DECREASE')) NOT NULL,
    "description"        VARCHAR(255)    ,
    "modification_date"  DATE             NOT NULL
);
ALTER TABLE
    "balance_history"
    ADD PRIMARY KEY ("balance_history_id");
ALTER TABLE
    "users_roles"
    ADD CONSTRAINT "users_roles_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "users_roles"
    ADD CONSTRAINT "users_roles_role_id_foreign" FOREIGN KEY ("role_id") REFERENCES "roles" ("role_id");
ALTER TABLE
    "booking_resources_residents"
    ADD CONSTRAINT "booking_resources_residents_resource_id_foreign" FOREIGN KEY ("resource_id") REFERENCES "booking_resources" ("resource_id");
ALTER TABLE
    "booking_resources_residents"
    ADD CONSTRAINT "booking_resources_residents_resident_id_foreign" FOREIGN KEY ("resident_id") REFERENCES "residents" ("resident_id");
ALTER TABLE
    "sending_notifications"
    ADD CONSTRAINT "sending_notifications_notification_id_foreign" FOREIGN KEY ("notification_id") REFERENCES "notifications" ("notification_id");
ALTER TABLE
    "sending_notifications"
    ADD CONSTRAINT "sending_notifications_resident_id_foreign" FOREIGN KEY ("resident_id") REFERENCES "residents" ("resident_id");
ALTER TABLE
    "booking_resources"
    ADD CONSTRAINT "booking_resources_resource_type_id_foreign" FOREIGN KEY ("resource_type_id") REFERENCES "recource_type" ("recource_type_id");
ALTER TABLE
    "booking_resources"
    ADD CONSTRAINT "booking_resources_status_id_foreign" FOREIGN KEY ("status_id") REFERENCES "status" ("status_id");
ALTER TABLE
    "balance_history"
    ADD CONSTRAINT "balance_history_resident_id_foreign" FOREIGN KEY ("resident_id") REFERENCES "residents" ("resident_id");
ALTER TABLE
    "managers"
    ADD CONSTRAINT "managers_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "residents"
    ADD CONSTRAINT "residents_user_id_foreign" FOREIGN KEY ("user_id") REFERENCES "users" ("user_id");
ALTER TABLE
    "notifications"
    ADD CONSTRAINT "notifications_manager_id_foreign" FOREIGN KEY ("manager_id") REFERENCES "managers" ("manager_id");
ALTER TABLE
    "passports"
    ADD CONSTRAINT "passports_resident_id_foreign" FOREIGN KEY ("resident_id") REFERENCES "residents" ("resident_id");