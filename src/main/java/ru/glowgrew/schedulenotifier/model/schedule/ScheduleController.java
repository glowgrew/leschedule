package ru.glowgrew.schedulenotifier.model.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PutMapping
    public ResponseEntity<ScheduleDto> create(@RequestBody ScheduleCreateRequest createRequest) {
        return ResponseEntity.ok(scheduleService.create(createRequest.getData()).toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        scheduleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{groupDisplayName}/{day}")
    public ResponseEntity<List<ScheduleDto>> findByGroupIdAndDay(@PathVariable String groupDisplayName,
                                                                 @PathVariable int day) {
        return ResponseEntity.ok(
                scheduleService.findByGroupDisplayNameAndDay(groupDisplayName, DayOfWeek.of(day)).stream()
                        .map(Schedule::toDto).toList());
    }

}
