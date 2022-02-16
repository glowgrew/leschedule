package ru.glowgrew.schedulenotifier.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {

    private final Long id;

    @JsonProperty("display_name")
    private final String displayName;

}
