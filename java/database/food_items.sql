DROP TABLE IF EXISTS food_items, meals;


BEGIN TRANSACTION;



CREATE TABLE food_items
(
food_id                int        NOT NULL PRIMARY KEY,
calories_per_serving   int       NOT NULL,
number_of_servings     int       NOT NULL,
food_name                       varchar(64)   NOT NULL,
meal_category                   varchar(32)  NOT NUll

);


CREATE TABLE meals
(
meal_id      serial     NOT NULL PRIMARY KEY,
meal_category              varchar(32) NOT NULL,
meal_name                  varchar(64)   NOT NULL,
total_calories int NOT NULL,
quick_saved_meal boolean NOT NULL,
manually_input boolean NOT NULL,
user_id  int,


);


COMMIT;



