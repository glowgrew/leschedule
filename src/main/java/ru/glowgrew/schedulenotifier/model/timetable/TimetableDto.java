package ru.glowgrew.schedulenotifier.model.timetable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Data
@Builder
public class TimetableDto {

    private DayOfWeek day;
    private int lesson;

    @JsonProperty("start_time")
    private LocalTime startTime;

    @JsonProperty("end_time")
    private LocalTime endTime;

    @JsonProperty("break_duration")
    private Duration breakDuration;

}
