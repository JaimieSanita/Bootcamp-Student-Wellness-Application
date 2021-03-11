DROP TABLE IF EXISTS exercise;

CREATE TABLE exercise
(

exercise_id                    int generated always as identity,
exercise_category              varchar(32) NOT NULL, 
exercise_name                  varchar(64)   NOT NULL,
exercise_length               int NOT NULL,
exercise_description          varchar(128),
calories_burn                 int NOT NULL,
equipment                     boolean

);

alter table exercise
add constraint pk_exercise PRIMARY KEY (exercise_id);


COMMIT;