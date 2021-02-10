package com.echipa3.backend.services;

import com.echipa3.backend.entities.Course;

import java.util.List;

public interface ICourseService {
    public List<Course> getAll();

    public Course getById(Long id);

    public Course saveOrUpdate(Course course);

    public void delete(Long id);
}
