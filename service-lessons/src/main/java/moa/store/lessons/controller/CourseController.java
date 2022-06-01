package moa.store.lessons.controller;

import moa.store.lessons.model.entity.Course;
import moa.store.lessons.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping( value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courses = courseService.getAll();
        if(courses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courses);
    }
}
