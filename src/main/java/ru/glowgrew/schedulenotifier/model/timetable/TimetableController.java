package ru.glowgrew.schedulenotifier.model.timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/timetables")
@RequiredArgsConstructor
public class TimetableController {

    private final TimetableService timetableService;

    @PutMapping
    public ResponseEntity<TimetableDto> create(@RequestBody TimetableCreateRequest createRequest) {
        final Timetable timetable = Timetable.fromCreateData(createRequest.getPayload());
        timetableService.save(timetable);

        return ResponseEntity.ok(timetable.toDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        timetableService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{day}")
    public ResponseEntity<List<TimetableDto>> findByDay(@PathVariable int day) {
        return ResponseEntity.ok(timetableService.findByDay(DayOfWeek.of(day)).stream().map(Timetable::toDto).toList());
    }

}
