package ru.glowgrew.schedulenotifier.model.schedule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("schedule_create_request")
public class ScheduleCreateRequest {

    private final ScheduleCreateData data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ScheduleCreateRequest(@JsonProperty("data") ScheduleCreateData data) {
        this.data = data;
    }

}
