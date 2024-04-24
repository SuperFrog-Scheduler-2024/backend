package edu.tcu.cs.superfrogschedulerbackend.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(String studentId) {
        return this.studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    public Student update(String studentId,Student student) {
    return this.studentRepository.findById(studentId)
            .map(oldStudent -> {
                oldStudent.setFirstName(student.getFirstName());
                oldStudent.setLastName(student.getLastName());
                oldStudent.setEmail(student.getEmail());
                oldStudent.setAddress(student.getAddress());
                oldStudent.setInternational(student.isInternational());
                oldStudent.setPhoneNumber(student.getPhoneNumber());
                oldStudent.setSsn(student.getSsn());
                return studentRepository.save(oldStudent);
            }).orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    public void delete(String studentId) {
        this.studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
        this.studentRepository.deleteById(studentId);
    }
}
