DROP TABLE IF EXISTS  user_profile;

BEGIN TRANSACTION;


CREATE TABLE user_profile
(
profile_id      int          PRIMARY KEY,
first_name      varchar(128)    NOT NULL,
last_name       varchar(128)    NOT NULL,
email           varchar(128)   NOT NULL,
age             int            NOT NULL,
feet            int            NOT NULL,
inches          int            NOT NULL,
current_weight  DECIMAL        NOT NULL

);


ALTER TABLE user_profile
        ADD CONSTRAINT fk_profile_id_id FOREIGN KEY (profile_id) REFERENCES users(user_id);



COMMIT;
select * from user_profile;
Start transaction;
INSERT INTO user_profile(profile_id,first_name, last_name, email, age, feet, inches, current_weight)
VALUES (1,'Joe', 'Smith','joe@gmail.com', 1, 1, 1, 1), (2,'Bill', 'Gates','bill@gmail.com', 1,1,1,1),(3,'Mike','Drew','werdekim@gmail.com', 39, 5, 8, 165);
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

SELECT * from user_profile;
select * from users;

Rollback;


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
where user_id = 4;