CREATE TABLE students (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
login VARCHAR(20),
pass VARCHAR(20),
UNIQUE INDEX `login_UNIQUE` (`login` ASC));

CREATE TABLE teachers (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
login VARCHAR(20),
pass VARCHAR(20),
UNIQUE INDEX `login_UNIQUE` (`login` ASC));

CREATE TABLE courses(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
price INT,
time VARCHAR(20));

CREATE TABLE student_Course (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
students_id INT NOT NULL,
courses_id INT NOT NULL,
CONSTRAINT student FOREIGN KEY ( students_id ) REFERENCES students (id),
CONSTRAINT course FOREIGN KEY ( courses_id ) REFERENCES courses ( id ));

CREATE TABLE teacher_Course(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
teachers_id INT NOT NULL,
courses_id  INT NOT NULL,
CONSTRAINT teacher FOREIGN KEY ( teachers_id ) REFERENCES teachers ( id ),
CONSTRAINT cours FOREIGN KEY ( courses_id ) REFERENCES courses ( id ));

CREATE TABLE topic (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30),
courses_id INT NOT NULL,
CONSTRAINT cour FOREIGN KEY ( courses_id ) REFERENCES courses ( id ));

CREATE TABLE test (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
number_of_attempts INT,
time_limit INT,
ball_to_pass INT,
courses_id INT NOT NULL,
topic_id INT NOT NULL,
CONSTRAINT topic FOREIGN KEY ( topic_id ) REFERENCES topic ( id ));

CREATE TABLE questions(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
question VARCHAR(100),
test_id INT NOT NULL,
CONSTRAINT test FOREIGN KEY ( test_id ) REFERENCES test ( id ));

CREATE TABLE answers(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
text VARCHAR(100),
ball INT,
questions_id INT NOT NULL,
CONSTRAINT question FOREIGN KEY ( questions_id ) REFERENCES questions ( id ));

CREATE TABLE testHistory(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
numberOfTry INT,
date DATETIME,
countBall INT,
students_id INT NOT NULL);

CREATE TABLE given_answers(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
answers_id INT NOT NULL,
testHistory_id INT NOT NULL,
CONSTRAINT answer FOREIGN KEY ( answers_id ) REFERENCES answers ( id ),
CONSTRAINT testHistor FOREIGN KEY ( testHistory_id) REFERENCES testHistory ( id ));
