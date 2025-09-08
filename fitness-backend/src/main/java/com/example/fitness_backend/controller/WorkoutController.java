package com.example.fitness_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitness_backend.entity.User;
import com.example.fitness_backend.entity.Workout;
import com.example.fitness_backend.repository.UserRepository;
import com.example.fitness_backend.repository.WorkoutRepository;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{userId}/log")
    public Workout logWorkout(@PathVariable Long userId, @RequestBody Workout workout) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    @GetMapping("/{userId}")
    public List<Workout> getWorkouts(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return workoutRepository.findByUser(user);
    }
}
