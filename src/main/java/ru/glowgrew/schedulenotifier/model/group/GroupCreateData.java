package ru.glowgrew.schedulenotifier.model.group;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("group_create_data")
public class GroupCreateData {

    private final String displayName;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public GroupCreateData(@JsonProperty("display_name") String displayName) {
        this.displayName = displayName;
    }

}