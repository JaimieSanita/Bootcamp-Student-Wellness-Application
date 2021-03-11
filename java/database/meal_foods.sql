DROP TABLE IF EXISTS meal_foods;

BEGIN TRANSACTION;

CREATE TABLE meal_foods
(
meal_id INT NOT NULL,
food_id INT NOT NULL,
quatity INT NOT NULL



);

ALTER TABLE meal_foods
ADD CONSTRAINT fk_meal_id_id FOREIGN KEY  (meal_id)  REFERENCES meals(meal_id),
ADD CONSTRAINT fk_food_id_id FOREIGN KEY (food_id)   REFERENCES food_items(food_id);

COMMIT;