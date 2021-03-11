DROP TABLE IF EXISTS user_meals;

BEGIN TRANSACTION;

CREATE TABLE user_meals
(
meal_id      INT GENERATED ALWAYS AS IDENTITY ,
user_id int NOT NULL, 

CONSTRAINT PK_user_meals PRIMARY KEY (user_id),
CONSTRAINT FK_user_id_id FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_meal_id_id FOREIGN KEY (meal_id) REFERENCES meals (meal_id)

);







COMMIT;