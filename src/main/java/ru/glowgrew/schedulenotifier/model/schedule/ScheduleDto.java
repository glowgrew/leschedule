package ru.glowgrew.schedulenotifier.model.schedule;

import lombok.Builder;
import lombok.Data;
import ru.glowgrew.schedulenotifier.model.group.Group;

import java.time.DayOfWeek;

@Data
@Builder
public class ScheduleDto {

    private Group group;
    private DayOfWeek day;
    private int lesson;
    private String subject;

}
