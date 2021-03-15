
DROP TABLE IF EXISTS food_items;
DROP TABLE IF EXISTS user_meals;
DROP TABLE IF EXISTS meal_category;
DROP TABLE IF EXISTS user_foods;

START TRANSACTION;


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


SELECT * FROM goal_category;