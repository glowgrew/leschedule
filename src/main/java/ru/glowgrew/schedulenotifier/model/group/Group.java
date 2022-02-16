package ru.glowgrew.schedulenotifier.model.group;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "groups")
public class Group extends AbstractPersistable<Long> {

    @Column(unique = true)
    private String displayName;

    public static Group fromCreateData(GroupCreateData groupCreateData) {
        var group = new Group();

        group.setDisplayName(groupCreateData.getDisplayName());

        return group;
    }

    public GroupDto toDto() {
        return GroupDto.builder().id(getId()).displayName(getDisplayName()).build();
    }

}
