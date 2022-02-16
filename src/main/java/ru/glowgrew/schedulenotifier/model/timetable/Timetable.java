package ru.glowgrew.schedulenotifier.model.timetable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "timetables")
public class Timetable extends AbstractPersistable<Long> {

    private static final DateTimeFormatter TIME_PATTERN = DateTimeFormatter.ofPattern("HH:mm");

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;

    private int lesson;

    private LocalTime startTime;

    private LocalTime endTime;

    private Duration breakDuration;

    public static Timetable fromCreateData(TimetableCreateRequest.Payload payload) {
        var timetable = new Timetable();

        timetable.setDay(DayOfWeek.of(payload.getDay()));
        timetable.setLesson(payload.getLesson());
        timetable.setStartTime(LocalTime.parse(payload.getStartTime(), TIME_PATTERN));
        timetable.setEndTime(LocalTime.parse(payload.getEndTime(), TIME_PATTERN));
        timetable.setBreakDuration(Duration.ofSeconds(payload.getBreakDuration()));

        return timetable;
    }

    public TimetableDto toDto() {
        return TimetableDto.builder().day(day).lesson(lesson).startTime(startTime).endTime(endTime).breakDuration(breakDuration)
                .build();
    }

}
