CREATE TABLE `role`
(
    id  BIGINT AUTO_INCREMENT NOT NULL,
    nom VARCHAR(50) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT pk_user_role PRIMARY KEY (role_id, user_id)
);

CREATE TABLE users
(
    id                     BIGINT       NOT NULL,
    user_type              VARCHAR(20) NULL,
    email                  VARCHAR(255) NOT NULL,
    password               VARCHAR(255) NOT NULL,
    nom                    VARCHAR(50)  NOT NULL,
    prenom                 VARCHAR(50)  NOT NULL,
    telephone              VARCHAR(255) NULL,
    created_at             datetime     NOT NULL,
    updated_at             datetime     NOT NULL,
    specialite             VARCHAR(255) NULL,
    inpe                   VARCHAR(255) NOT NULL,
    numero_securite_social VARCHAR(255) NULL,
    date_naissance         date NULL,
    sexe                   VARCHAR(1)   NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE `role`
    ADD CONSTRAINT uc_role_nom UNIQUE (nom);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_inpe UNIQUE (inpe);

ALTER TABLE users
    ADD CONSTRAINT uc_users_numerosecuritesocial UNIQUE (numero_securite_social);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES `role` (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);