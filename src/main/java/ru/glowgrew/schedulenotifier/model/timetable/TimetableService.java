package ru.glowgrew.schedulenotifier.model.timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimetableService {

    private final TimetableRepository timetableRepository;

    public Optional<Timetable> findById(final long id) {
        return timetableRepository.findById(id);
    }

    public List<Timetable> findByDay(final DayOfWeek day) {
        return timetableRepository.findAllByDayOrderByLesson(day);
    }

    public void delete(long id) {
        timetableRepository.deleteById(id);
    }

    public void save(final Timetable timetable) {
        timetableRepository.save(timetable);
    }
}
