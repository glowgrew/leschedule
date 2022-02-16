package ru.glowgrew.schedulenotifier.model.group;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/{displayName}")
    public ResponseEntity<GroupDto> findByDisplayName(@PathVariable String displayName) {
        return ResponseEntity.of(groupService.findByDisplayName(displayName).map(Group::toDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<GroupDto>> findAll() {
        return ResponseEntity.ok(groupService.findAll().stream().map(Group::toDto).toList());
    }

    @PutMapping("/")
    public ResponseEntity<GroupDto> create(@RequestBody GroupCreateRequest groupCreateRequest) {
        return ResponseEntity.ok(groupService.create(groupCreateRequest.getData()).toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        groupService.delete(id);
        return ResponseEntity.ok().build();
    }

}
