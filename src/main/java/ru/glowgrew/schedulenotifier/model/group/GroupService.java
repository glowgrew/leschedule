package ru.glowgrew.schedulenotifier.model.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    public Optional<Group> findByDisplayName(final String displayName) {
        return groupRepository.findGroupByDisplayName(displayName);
    }

    public Group create(GroupCreateData groupCreateData) {
        return groupRepository.save(Group.fromCreateData(groupCreateData));
    }

    public void delete(long id) {
        groupRepository.deleteById(id);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
