package ru.glowgrew.schedulenotifier.model.timetable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("timetable_create_request")
public class TimetableCreateRequest {

    private final Payload payload;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TimetableCreateRequest(@JsonProperty("data") Payload payload) {
        this.payload = payload;
    }

    @Data
    @JsonRootName("timetable_create_data")
    public static class Payload {

        private int day;
        private int lesson;
        private String startTime;
        private String endTime;
        private int breakDuration;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        public Payload(int day, int lesson, @JsonProperty("start_time") String startTime,
                       @JsonProperty("end_time") String endTime, @JsonProperty("break_duration") int breakDuration) {
            this.day = day;
            this.lesson = lesson;
            this.startTime = startTime;
            this.endTime = endTime;
            this.breakDuration = breakDuration;
        }
    }
}
