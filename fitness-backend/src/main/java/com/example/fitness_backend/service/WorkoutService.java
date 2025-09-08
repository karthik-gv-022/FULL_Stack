package com.example.fitness_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitness_backend.entity.User;
import com.example.fitness_backend.entity.Workout;
import com.example.fitness_backend.repository.UserRepository;
import com.example.fitness_backend.repository.WorkoutRepository;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    public Workout logWorkout(Long userId, Workout workout) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        workout.setUser(user);
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkouts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return workoutRepository.findByUser(user);
    }
}
