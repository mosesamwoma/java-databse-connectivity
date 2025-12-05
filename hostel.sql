DROP DATABASE IF EXISTS hostel;
CREATE DATABASE hostel;
USE hostel;

CREATE TABLE students(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  phone VARCHAR(20),
  course VARCHAR(50)
);

CREATE TABLE rooms(
  id INT AUTO_INCREMENT PRIMARY KEY,
  room_no VARCHAR(10),
  capacity INT
);

CREATE TABLE allocations(
  id INT AUTO_INCREMENT PRIMARY KEY,
  student_id INT,
  room_id INT,
  start_date DATE,
  FOREIGN KEY(student_id) REFERENCES students(id),
  FOREIGN KEY(room_id) REFERENCES rooms(id)
);

INSERT INTO students(name,phone,course) VALUES
('Ali Khan','123456789','CS'),
('Sarah Ahmed','987654321','IT'),
('John Miller','555889900','Business');

INSERT INTO rooms(room_no,capacity) VALUES
('101',2),
('102',3),
('201',1);

INSERT INTO allocations VALUES
(1,1,1,'2025-01-10'),
(2,2,2,'2025-01-12'),
(3,3,3,'2025-01-15');
