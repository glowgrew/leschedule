package ru.glowgrew.schedulenotifier.model.group;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("group_create_request")
public class GroupCreateRequest {

    private final GroupCreateData data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public GroupCreateRequest(@JsonProperty("data") GroupCreateData data) {
        this.data = data;
    }

}
