DROP TABLE IF EXISTS  user_profile;
DROP TABLE IF EXISTS user_goals;
DROP TABLE IF EXISTS goal_category;
DROP TABLE IF EXISTS user_exercises;
DROP TABLE IF EXISTS exercise;
DROP TABLE IF EXISTS food_items;
DROP TABLE IF EXISTS user_meals;
DROP TABLE IF EXISTS meal_category;
DROP TABLE IF EXISTS user_foods;


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

CREATE TABLE goal_category
(
goal_category_id      INT GENERATED ALWAYS AS IDENTITY ,
category      varchar(128)    NOT NULL,
CONSTRAINT PK_goal_category PRIMARY KEY (goal_category_id)
);


CREATE TABLE user_goals
(
user_goals_id      INT GENERATED ALWAYS AS IDENTITY ,
user_id int , 
date_assigned DATE ,
category_id      int    ,
activity      varchar(128) ,
times_per_week      int    ,
duration          int   ,
is_completed         boolean            NOT NULL,
CONSTRAINT PK_goals PRIMARY KEY (user_goals_id),
CONSTRAINT FK_goals_user FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_goals_category FOREIGN KEY(category_id) REFERENCES goal_category(goal_category_id)

);




GRANT SELECT, INSERT, UPDATE, DELETE
ON goal_category 
TO final_capstone_appuser;


GRANT SELECT, INSERT, UPDATE, DELETE
ON user_goals 
TO final_capstone_appuser;

INSERT INTO goal_category(category) Values ('exercise');
INSERT INTO goal_category(category) Values ('nutrition');
INSERT INTO goal_category(category) Values ('sanity');

INSERT INTO user_goals(user_id, date_assigned, category_id, activity, times_per_week, duration, is_completed)
VALUES (1, '05/24/2020' , 1, 'running', 2, 10, false);

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

CREATE TABLE meal_category
(

meal_category_id                    int generated always as identity PRIMARY KEY,
meal_category              varchar(32) NOT NULL

);









CREATE TABLE food_items
(
food_id      INT GENERATED ALWAYS AS IDENTITY ,
food_name                  varchar(64)   NOT NULL,
meal_category_id               int NOT NULL,
calories_per_serving                 int NOT NULL,


CONSTRAINT PK_food_items PRIMARY KEY (food_id),
CONSTRAINT FK_meal_category_id FOREIGN KEY(meal_category_id ) REFERENCES meal_category(meal_category_id )


);

CREATE TABLE user_meals
(
user_meals_id      INT GENERATED ALWAYS AS IDENTITY ,
meal_category_id                 int NOT NULL,
meal_name                 varchar(64)   NOT NULL,
meal_description			varchar(300)   NOT NULL,
total_calories				int NOT NULL,


CONSTRAINT PK_user_meals PRIMARY KEY (user_meals_id),
CONSTRAINT FK_user_meals FOREIGN KEY (meal_category_id) REFERENCES meal_category(meal_category_id)


);


INSERT INTO meal_category(meal_category) VALUES('breakfast'),('lunch'),('dinner'),('dessert'),('snack');







CREATE TABLE user_foods
(
user_foods_id      INT GENERATED ALWAYS AS IDENTITY ,
food_id                 int NOT NULL,
food_name      varchar(64)   NOT NULL,
number_of_serving                 int NOT NULL,
user_id				int NOT NULL,
user_meals_id				int ,


CONSTRAINT PK_user_foods PRIMARY KEY (user_foods_id),
CONSTRAINT FK_user_id_user_foods_id FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_food_id_id FOREIGN KEY (food_id) REFERENCES food_items (food_id),
CONSTRAINT FK_user_meals_id_id FOREIGN KEY(user_meals_id) REFERENCES user_meals(user_meals_id)

);




GRANT SELECT, INSERT, UPDATE, DELETE
ON user_foods
TO final_capstone_appuser;


GRANT SELECT, INSERT, UPDATE, DELETE
ON user_meals 
TO final_capstone_appuser;

GRANT SELECT, INSERT, UPDATE, DELETE
ON food_items
TO final_capstone_appuser;

GRANT SELECT, INSERT, UPDATE, DELETE
ON meal_category
TO final_capstone_appuser;

COMMIT;

ROLLBACK;
