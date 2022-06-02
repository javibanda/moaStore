package moa.store.lessons.service;

import moa.store.lessons.model.entity.Lesson;
import moa.store.lessons.repository.LessonRepository;
import moa.store.lessons.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LessonService extends BaseService<Lesson> {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository){
        repository = lessonRepository;
        this.lessonRepository = lessonRepository;
    }

    public Lesson create(Lesson lesson){
        lesson.setDuration(TimeUtil.getDuration(lesson.getInitTime(), lesson.getFinishTime()));
        if(lesson.getDuration() > 0) return repository.save(lesson);
        else return null;
    }

    public List<Lesson> getByMonth(int month){
        return lessonRepository.getLessonByMonth(month);
    }

    public List<Lesson> createMonthlyByWeekDay(int month, int year, int weekDay, Lesson lesson) throws ParseException {
        List<Lesson> lessons;
        if((month <= 0 || month > 12 ) || year <= 0 || (weekDay<= 0 || weekDay > 7)){
            return null;
        }

        List<Date> dates = TimeUtil.getAllDayOfTheMonth(year, month, weekDay);
        lessons = getListLessons(dates, lesson);
        for(Lesson l: lessons){
            create(l);
        }
        return lessons;
    }

    private List<Lesson> getListLessons(List<Date> dates, Lesson lesson){

        List<Lesson> lessons = new ArrayList<>();
        for(Date date: dates){
            lessons.add(getNewLesson(date, lesson));
        }
        return lessons;
    }

    private Lesson getNewLesson(Date date, Lesson lesson){
        return Lesson.builder()
                .initTime(lesson.getInitTime())
                .finishTime(lesson.getFinishTime())
                .date(TimeUtil.toSqlDate(date))
                .build();
    }
}
