package moa.store.lessons.controller;

import moa.store.lessons.model.entity.Course;
import moa.store.lessons.model.entity.Lesson;
import moa.store.lessons.service.CourseService;
import moa.store.lessons.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping( value = "/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public ResponseEntity<List<Lesson>> getCourses(){
        List<Lesson> lessons = lessonService.getAll();
        if(lessons.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lessons);
    }
}
