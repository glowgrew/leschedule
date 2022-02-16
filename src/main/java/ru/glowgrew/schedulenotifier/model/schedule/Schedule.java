package ru.glowgrew.schedulenotifier.model.schedule;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;
import ru.glowgrew.schedulenotifier.model.group.Group;

import javax.persistence.*;
import java.time.DayOfWeek;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "schedules")
public class Schedule extends AbstractPersistable<Long> {

    @ManyToOne
    private Group group;

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    private int lesson;

    private String subject;

    public ScheduleDto toDto() {
        return ScheduleDto.builder().group(group).day(day).lesson(lesson).subject(subject).build();
    }

}
