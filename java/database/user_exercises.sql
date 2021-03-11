DROP TABLE IF EXISTS user_exercises;

BEGIN TRANSACTION;

CREATE TABLE user_exercises
(
exercise_id      INT GENERATED ALWAYS AS IDENTITY ,
user_id int NOT NULL, 

CONSTRAINT PK_user_exercises PRIMARY KEY (user_id),
CONSTRAINT FK_user_id_id FOREIGN KEY(user_id) REFERENCES users(user_id),
CONSTRAINT FK_excercise_id_id FOREIGN KEY (exercise_id) REFERENCES exercise (exercise_id)

);

COMMIT;