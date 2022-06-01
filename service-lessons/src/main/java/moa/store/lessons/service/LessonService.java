package moa.store.lessons.service;

import moa.store.lessons.model.entity.Lesson;
import moa.store.lessons.repository.CourseRepository;
import moa.store.lessons.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService extends BaseService<Lesson> {

    @Autowired
    public LessonService(LessonRepository lessonRepository){
        repository = lessonRepository;
    }
}
