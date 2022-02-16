package ru.glowgrew.schedulenotifier.model.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.glowgrew.schedulenotifier.model.group.GroupDto;

@Data
@Builder
public class StudentDto {

    @JsonProperty("vk_id")
    private final long vkId;

    private final GroupDto group;

    private boolean allowReceivingScheduleChangesNotifications;

    private boolean allowReceivingFinalExamNotifications;
}
