-- Create Database
CREATE DATABASE IF NOT EXISTS fitness_tracker;
USE fitness_tracker;

-- Create Users Table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Workouts Table
CREATE TABLE IF NOT EXISTS workouts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    title VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    duration INT NOT NULL,
    calories INT NOT NULL,
    intensity ENUM('low', 'moderate', 'high') NOT NULL,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create Goals Table
CREATE TABLE IF NOT EXISTS goals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    weekly_goal INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
