package moa.store.lessons.repository;

import moa.store.lessons.model.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("select lesson from Lesson lesson where month(lesson.date) =:month")
    List<Lesson> getLessonByMonth(@Param("month") int month);
}
