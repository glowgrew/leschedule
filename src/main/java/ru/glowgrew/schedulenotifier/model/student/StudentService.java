package ru.glowgrew.schedulenotifier.model.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.glowgrew.schedulenotifier.model.group.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    public Student create(StudentCreateData createData) {
        var student = new Student();
        var group = groupRepository.findGroupByDisplayName(createData.getGroupDisplayName());

        student.setVkId(createData.getVkId());
        student.setGroup(group.get()); // todo: ???
        student.setAllowReceivingScheduleChangesNotifications(false);
        student.setAllowReceivingFinalExamNotifications(false);

        return studentRepository.save(student);
    }

    public Optional<Student> findById(final long vkId) {
        return studentRepository.findById(vkId);
    }

    public List<Student> findByDisplayName(final String displayName) {
        return studentRepository.findAllStudentsByGroup_DisplayName(displayName);
    }

    public void delete(long vkId) {
        studentRepository.deleteById(vkId);
    }

    @Transactional
    public void setAllowedToReceiveFinalExamNotificationsStatus(final long vkId, final boolean status) {
        studentRepository.findById(vkId).ifPresent(student -> student.setAllowReceivingFinalExamNotifications(status));
    }

    @Transactional
    public void setAllowedToReceiveScheduleChangesNotificationsStatus(final long vkId, final boolean status) {
        studentRepository.findById(vkId).ifPresent(student -> student.setAllowReceivingScheduleChangesNotifications(status));
    }
}