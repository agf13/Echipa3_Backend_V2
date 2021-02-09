package com.echipa3.backend.services;

import com.echipa3.backend.entities.Course;
import com.echipa3.backend.entities.Description;

import java.util.List;

public interface ICourseService {
    public List<Course> getAll();

    public Course getById(Long id);

    public void saveOrUpdate(Course course);

    public void delete(Long id);
}
