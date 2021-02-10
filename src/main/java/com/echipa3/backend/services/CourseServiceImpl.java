package com.echipa3.backend.services;

import com.echipa3.backend.entities.Course;
import com.echipa3.backend.repositories.IRepoCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements ICourseService{

    @Autowired
    private IRepoCourse repository;

    @Override
    public List<Course> getAll() {
        return (List<Course>)repository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Course saveOrUpdate(Course course) {
        return repository.save(course);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
