package ru.glowgrew.schedulenotifier.model.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.glowgrew.schedulenotifier.model.group.GroupRepository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final GroupRepository groupRepository;

    public Schedule create(ScheduleCreateData createData) {
        var schedule = new Schedule();
        var group = groupRepository.findGroupByDisplayName(createData.getGroupDisplayName());

        schedule.setGroup(group.get());
        schedule.setDay(DayOfWeek.of(createData.getDay()));
        schedule.setLesson(createData.getLesson());
        schedule.setSubject(createData.getSubject());

        return scheduleRepository.save(schedule);
    }

    public Optional<Schedule> findById(final long id) {
        return scheduleRepository.findById(id);
    }

    public List<Schedule> findByGroupDisplayNameAndDay(final String displayName, final DayOfWeek day) {
        return scheduleRepository.findAllByGroup_DisplayNameAndDayOrderByDayDesc(displayName, day);
    }

    public void delete(long id) {
        scheduleRepository.deleteById(id);
    }
}
