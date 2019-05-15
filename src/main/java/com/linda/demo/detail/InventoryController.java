//package com.linda.demo.detail;
//
//import com.linda.demo.detail.Repo.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/inventory")
//public class InventoryController {
//    @Autowired
//    private StudentRepo studentRepo;
//
//    @GetMapping(value = "/students")
//    public List<Student> getStudents() {
//        return studentRepo.findAll();
//    }
//
//    @PostMapping(value = "/students")
//    public Student studentAdd() {
//        Student student = new Student();
//        student.setName("linda");
//        return studentRepo.save(student);
//
//    }
//}
