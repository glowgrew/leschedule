package ru.glowgrew.schedulenotifier.model.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByGroup_DisplayNameAndDayOrderByDayDesc(final String displayName, final DayOfWeek day);

}

