package ru.glowgrew.schedulenotifier.model.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{vkId}")
    public ResponseEntity<StudentDto> findById(@PathVariable long vkId) {
        return ResponseEntity.of(studentService.findById(vkId).map(Student::toDto));
    }

    @GetMapping("/notifications/final-exam/{vkId}")
    public ResponseEntity<Boolean> isAllowedToReceiveFinalExamNotifications(@PathVariable long vkId) {
        return ResponseEntity.of(studentService.findById(vkId).map(Student::toDto).map(
                StudentDto::isAllowReceivingFinalExamNotifications));
    }

    @GetMapping("/notifications/schedule-changes/{vkId}")
    public ResponseEntity<Boolean> isAllowedToReceiveScheduleChangesNotifications(@PathVariable long vkId) {
        return ResponseEntity.of(studentService.findById(vkId).map(Student::toDto).map(
                StudentDto::isAllowReceivingScheduleChangesNotifications));
    }

    @PostMapping("/notifications/final-exam/{vkId}")
    public ResponseEntity<Void> setAllowedToReceiveFinalExamNotificationsStatus(@PathVariable long vkId,
                                                                                @RequestParam(required = false)
                                                                                        boolean status) {
        studentService.setAllowedToReceiveFinalExamNotificationsStatus(vkId, status);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/notifications/schedule-changes/{vkId}")
    public ResponseEntity<Void> setAllowedToReceiveScheduleChangesNotificationsStatus(@PathVariable long vkId,
                                                                                @RequestParam(required = false)
                                                                                        boolean status) {
        studentService.setAllowedToReceiveScheduleChangesNotificationsStatus(vkId, status);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentCreateRequest studentCreateRequest) {
        return ResponseEntity.ok(studentService.create(studentCreateRequest.getData()).toDto());
    }

    @DeleteMapping("/{vkId}")
    public ResponseEntity<Void> delete(@PathVariable long vkId) {
        studentService.delete(vkId);
        return ResponseEntity.ok().build();
    }

}
