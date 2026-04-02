package com.school.service;

import com.school.model.Teacher;
import com.school.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void appointFaculty(Teacher teacher) {
        log.info("Appointing new faculty: {} {}", teacher.getFirstName(), teacher.getLastName());
        teacherRepository.save(teacher);
    }

    public void terminateContract(Long id) {
        log.warn("Terminating faculty record with ID: {}", id);
        teacherRepository.deleteById(id);
    }

    public void updatePersonnelRecord(Teacher teacher) {
        log.info("Updating personnel file for faculty member: {}", teacher.getId());
        teacherRepository.save(teacher);
    }
}
