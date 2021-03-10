DROP TABLE IF EXISTS  goals;

BEGIN TRANSACTION;


CREATE TABLE goals
(
goal_id      INT GENERATED ALWAYS AS IDENTITY ,
goal_setter        int NOT NULL, 
date_assigned varchar(128) NOT NULL,
category      varchar(128)    NOT NULL,
activity      varchar(128) NOT NULL,
times_per_week      int    NOT NULL,
duration          int   NOT NULL,
is_completed         boolean            NOT NULL,
CONSTRAINT PK_goals PRIMARY KEY (goal_id),
CONSTRAINT FK_goals_user_profile FOREIGN KEY(goal_setter) REFERENCES user_profile(profile_id)
);

GRANT SELECT, INSERT, UPDATE, DELETE
ON goals 
TO final_capstone_appuser;

COMMIT;

INSERT INTO GOALS(goal_setter, date_assigned, category, activity, times_per_week, duration, is_completed)
VALUES (1, '5/24/2020' , 'exercise', 'burpees', 3, 30, false);



SELECT * FROM goals;