
DROP TABLE IF EXISTS user_goals;
DROP TABLE IF EXISTS goal_category;
BEGIN TRANSACTION;

CREATE TABLE goal_category
(
goal_category_id      INT GENERATED ALWAYS AS IDENTITY ,
category      varchar(128)    NOT NULL,
CONSTRAINT PK_goal_category PRIMARY KEY (goal_category_id)
);


CREATE TABLE user_goals
(
user_goals_id      INT GENERATED ALWAYS AS IDENTITY ,
user_id int NOT NULL, 
date_assigned DATE NOT NULL,
category_id      int    NOT NULL,
activity      varchar(128) NOT NULL,
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






Select * from goal_category;
SELECT * FROM user_goals;

ROLLBACK;


COMMIT;
Select * from user_goals where user_id = 1;

SELECT user_goals_id, date_assigned, category, activity, times_per_week, duration, is_completed
FROM user_goals
JOIN users
ON users.user_id = user_goals.user_id
WHERE username = 'user';

UPDATE  user_goals SET user_id = 1, date_assigned ='1/2/13/', category='running', activity='running', times_per_week='3', duration='3', is_completed=false 
FROM user_goals AS g
JOIN users
ON users.user_id = g.user_id
WHERE user_id= 1;


SELECT count(*) FROM user_goals AS ug JOIN users AS u ON ug.user_id = u.user_id WHERE u.username= 'user' AND ug.user_goals_id =1;
