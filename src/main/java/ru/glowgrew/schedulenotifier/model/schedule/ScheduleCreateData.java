package ru.glowgrew.schedulenotifier.model.schedule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("student_create_data")
public class ScheduleCreateData {

    private String groupDisplayName;
    private int day;
    private int lesson;
    private String subject;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ScheduleCreateData(@JsonProperty("group_display_name") String groupDisplayName, int day, int lesson,
                              String subject) {
        this.groupDisplayName = groupDisplayName;
        this.day = day;
        this.lesson = lesson;
        this.subject = subject;
    }

}