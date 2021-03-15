SELECT * from user_profile;
select * from users;

DROP TABLE IF EXISTS  user_profile;

BEGIN TRANSACTION;


CREATE TABLE user_profile
(
profile_id      INT GENERATED ALWAYS AS IDENTITY   PRIMARY KEY,
user_id         int UNIQUE NOT NULL, 
first_name      varchar(128)    NOT NULL,
last_name       varchar(128)    NOT NULL,
email           varchar(128)   NOT NULL,
age             int            NOT NULL,
feet            int            NOT NULL,
inches          int            NOT NULL,
current_weight  DECIMAL        NOT NULL

);


ALTER TABLE user_profile
        ADD CONSTRAINT fk_user_id_id FOREIGN KEY (user_id) REFERENCES users(user_id);

GRANT SELECT, INSERT, UPDATE, DELETE
ON user_profile 
TO final_capstone_appuser;



select * from user_profile;

INSERT INTO user_profile(user_id,first_name, last_name, email, age, feet, inches, current_weight)
VALUES (1,'Joe', 'Smith','joe@gmail.com', 1, 1, 1, 1), (2,'Bill', 'Gates','bill@gmail.com', 1,1,1,1);
select * from user_profile;
select * from users;
COMMIT;

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

ROLLBACK;


SELECT profile_id, first_name, last_name, age, feet, inches, current_weight FROM user_profile JOIN users ON user_profile.profile_id = users.user_id WHERE username = 'Miked';

Begin Transaction;
GRANT ALL PRIVILEGES
ON user_profile 
TO final_capstone_appuser;
Commit;

alter table user_profile
Drop column create_date;

Delete
From users
where user_id >2;



grant all on sequence user_profile_profile_id_seq to final_capstone_appuser;
