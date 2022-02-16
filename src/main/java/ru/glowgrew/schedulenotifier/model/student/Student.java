package ru.glowgrew.schedulenotifier.model.student;

import lombok.Data;
import ru.glowgrew.schedulenotifier.model.group.Group;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    private Long vkId;

    @ManyToOne
    private Group group;

    private boolean allowReceivingScheduleChangesNotifications;

    private boolean allowReceivingFinalExamNotifications;

    public StudentDto toDto() {
        return StudentDto.builder().vkId(getVkId()).group(getGroup().toDto()).build();
    }

}
