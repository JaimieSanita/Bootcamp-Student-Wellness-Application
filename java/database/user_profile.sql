BEGIN TRANSACTION;

CREATE TABLE user_profile
(
profile_id      int            NOT NULL,
first_name      varchar(64)    NOT NULL,
last_name       varchar(64)    NOT NULL,
age             int            NOT NULL,
feet            int            NOT NULL,
inches          int            NOT NULL,
create_date     TIMESTAMP      NOT NULL DEFAULT now(),
current_weight  DECIMAL        NOT NULL

);


ALTER TABLE user_profile
        ADD CONSTRAINT fk_profile_id_id FOREIGN KEY (profile_id) REFERENCES users(user_id);


COMMIT;