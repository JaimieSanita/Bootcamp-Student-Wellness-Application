BEGIN TRANSACTION;

CREATE TABLE user_profile
(
profile_id      int           NOT NULL,
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
select * from user_profile;
Start transaction;
INSERT INTO user_profile(profile_id,first_name, last_name, age, feet, inches, current_weight)
VALUES (1,'Joe', 'Smith', 1, 1, 1, 1), (2,'Bill', 'Gates', 1,1,1,1),(3,'Mike','Drew', 39, 5, 8, 165);
select * from user_profile;
select * from users;
ROLLBACK;

SELECT first_name, last_name, age, feet, inches, current_weight FROM user_profile JOIN users ON user_profile.profile_id = users.user_id WHERE username = 'Miked';

select *
From user_profile
join users
On user_profile.profile_id = users.user_id
WHERE username = 'admin';

BEGIN TRANSACTION;

UPDATE user_profile
SET first_name = 'steve',last_name = 'jobs', age=2,feet=2,inches=2,current_weight=2
WHERE profile_id = 3;



Rollback;
