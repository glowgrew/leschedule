package ru.glowgrew.schedulenotifier.model.timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    List<Timetable> findAllByDayOrderByLesson(final DayOfWeek day);

}

