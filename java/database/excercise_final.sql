
DROP TABLE IF EXISTS user_exercises;
DROP TABLE IF EXISTS exercise;

START TRANSACTION;

CREATE TABLE exercise
(

exercise_id                    int generated always as identity PRIMARY KEY,
exercise_category              varchar(32) NOT NULL

);



CREATE TABLE user_exercises
(
user_exercise_id      INT GENERATED ALWAYS AS IDENTITY ,
user_id int NOT NULL, 
exercise_category_id             int NOT NULL,
exercise_name                  varchar(64)   NOT NULL,
date_assigned DATE ,
exercise_length               int NOT NULL,
exercise_description          varchar(128),
calories_burn                 int NOT NULL,
equipment                     boolean,


CONSTRAINT PK_user_exercises PRIMARY KEY (user_exercise_id),
CONSTRAINT FK_user_id_id FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_excercise_id_id FOREIGN KEY (exercise_category_id) REFERENCES exercise (exercise_id)

);



GRANT SELECT, INSERT, UPDATE, DELETE
ON user_exercises
TO final_capstone_appuser;


GRANT SELECT, INSERT, UPDATE, DELETE
ON exercise 
TO final_capstone_appuser;



INSERT INTO exercise(exercise_category) VALUES ('balance');
INSERT INTO exercise(exercise_category) VALUES ('flexibility');
INSERT INTO exercise(exercise_category) VALUES ('strength');
INSERT INTO exercise(exercise_category) VALUES ('endurance');

INSERT INTO user_exercises(user_id, exercise_category_id, exercise_name, date_assigned, exercise_length, exercise_description, calories_burn, equipment)
VALUES(1,1,'eating', '02/02/2020', 1, 'I ate a bunch of chicken', 7, false),(1,2,'sleeping','02/02/2020', 1, 'had a good nap', 7, false),(1,3,'eating','02/02/2020', 1, 'I ate a bunch of cheese', 7, false);


SELECT * FROM user_goals;

SELECT * FROM exercise;
SELECT * FROM user_exercises;
SELECT * FROM users;
SELECT user_exercises.* FROM user_exercises JOIN users ON user_exercises.user_id = users.user_id WHERE users.username = 'user';


ROLLBACK;


COMMIT;