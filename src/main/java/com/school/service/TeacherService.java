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
        log.info("COMMISSIONING_NEW_DIRECTIVE_LEAD: {} {}", teacher.getFirstName(), teacher.getLastName());
        teacherRepository.save(teacher);
    }

    public void terminateContract(Long id) {
        log.warn("EXECUTING_COMMAND_DOSSIER_ARCHIVE: ID {}", id);
        teacherRepository.deleteById(id);
    }

    public void updatePersonnelRecord(Teacher teacher) {
        log.info("RECONFIGURING_FACULTY_SYNERGY_MATRIX: {}", teacher.getId());
        teacherRepository.save(teacher);
    }
}
