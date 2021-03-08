CREATE TABLE exercise 
(
exercise_id                    int     NOT NULL,
exercise_category              varchar(32) NOT NULL, 
exercise_name                  varchar(64)   NOT NULL,
exercise_length               int NOT NULL, 
exercise_description          varchar(128), 
calories_burn                 int NOT NULL, 
equipment                     boolean  

);

alter table exercise 
add constraint fk_exercise_id_id foreign key (exercise_id) references users (user_id);

COMMIT; 