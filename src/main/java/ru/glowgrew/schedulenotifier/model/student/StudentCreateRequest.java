package ru.glowgrew.schedulenotifier.model.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("student_create_request")
public class StudentCreateRequest {

    private final StudentCreateData data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StudentCreateRequest(@JsonProperty("data") StudentCreateData data) {
        this.data = data;
    }

}
