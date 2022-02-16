package ru.glowgrew.schedulenotifier.model.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("student_create_data")
public class StudentCreateData {

    private final long vkId;
    private final String groupDisplayName;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public StudentCreateData(@JsonProperty("vk_id") long vkId,
                             @JsonProperty("group_display_name") String groupDisplayName) {
        this.vkId = vkId;
        this.groupDisplayName = groupDisplayName;
    }

}