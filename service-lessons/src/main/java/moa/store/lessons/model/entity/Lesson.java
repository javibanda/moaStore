package moa.store.lessons.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "lesson")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Lesson extends BaseEntity {

    private Date date;
    private Time initTime;
    private Time finishTime;
    private Long duration;
}
