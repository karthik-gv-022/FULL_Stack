package com.example.fitness_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness_backend.entity.User;
import com.example.fitness_backend.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUser(User user);
}
