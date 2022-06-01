package moa.store.lessons.service;

import moa.store.lessons.model.entity.Course;
import moa.store.lessons.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends BaseService<Course>{


    @Autowired
    public CourseService(CourseRepository courseRepository){
        repository = courseRepository;
    }

}
