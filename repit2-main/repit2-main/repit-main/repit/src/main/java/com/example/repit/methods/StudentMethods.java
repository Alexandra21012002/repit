package com.example.repit.methods;

import com.example.repit.entities.Authentication;
import com.example.repit.entities.Student;
import com.example.repit.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class StudentMethods {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentMethods(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Student getByID(int id){
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }
    @Transactional
    public void save(Student student){
        studentRepository.save(student);
    }

    @Transactional
    public void update(int id, Student Newstudent){
        Student old = getByID(id);

        old.setCity(Newstudent.getCity());
        old.setYearsOld(Newstudent.getYearsOld());
        old.setfName(Newstudent.getfName());
        old.setMobile(Newstudent.getMobile());

        studentRepository.save(old);
    }

    @Transactional
    public void delete(int id){
        studentRepository.deleteById(id);
    }
}
