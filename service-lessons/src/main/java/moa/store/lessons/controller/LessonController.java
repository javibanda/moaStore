package moa.store.lessons.controller;

import moa.store.lessons.model.entity.Lesson;
import moa.store.lessons.service.LessonService;
import moa.store.lessons.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Lesson>> getCoursesByMonth(@PathVariable int id){
        List<Lesson> lessons = lessonService.getByMonth(id);
        if(lessons.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lessons);
    }

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson, BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }

        Lesson lessonCreated = lessonService.create(lesson);
        if(lessonCreated != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(lessonCreated);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/monthly")
    public ResponseEntity<List<Lesson>> createMonthlyLessonsByWeek(@RequestBody Lesson lesson,
                                                                   @RequestParam(name = "weekDay") int weekDay,
                                                                   @RequestParam(name = "month") int month,
                                                                   @RequestParam(name = "year", required = false, defaultValue = "-1") int year,
                                                                   BindingResult result
                                                               ) throws ParseException {
        if(year<0){
            year = TimeUtil.getCurrentYear();
        }
        List<Lesson> lessonsCreated = lessonService.createMonthlyByWeekDay(month, year, weekDay, lesson);
        if(result.hasErrors() || lessonsCreated == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonsCreated);

    }
}
