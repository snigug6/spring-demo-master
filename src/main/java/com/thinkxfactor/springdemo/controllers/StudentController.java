package com.thinkxfactor.springdemo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.thinkxfactor.springdemo.controllers.entity.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    List<Student> students = new ArrayList<>();

    //Get student by roll no :: GET with request params
    //Add Student :: POST
    //Get Student list :: GET
    //Delete student by Id :: GET

    @GetMapping("/echo")
    public String sayEcho(){
        return "Echo from student controller";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "Greetings from student controller" + name + "!!";
    }

    @GetMapping("/greetall")
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/createStudent")
    public HashMap<String, Object> createStudent(@RequestParam String name,@RequestParam int age,@RequestParam String gender){
        HashMap<String,Object> respMap = new HashMap<>();
        respMap.put("name", name);
        respMap.put("age", age);
        respMap.put("gender", gender);
        
        // students.add(respmap);

        return respMap;
    }

    @PostMapping("/addStudent")
    public Student addStudents(@RequestBody Student student){
        //student.setId(UUID.randomUUID().toString());
        //students.add(student);
        System.out.println("Student object recieved");
        Student persistStudent = studentRepository.save(student);
        System.out.println("Student object saved");


        //System.out.println("Total elemnts in array" + students.size());

        return persistStudent;
    }

    @DeleteMapping("/delete/{id}")
    public void greet(@PathVariable Long id){
        studentRepository.deleteById(id);
    
    }

    //@PutMapping("/updateStudent")
    //public List<Student> updateStudents(@RequestBody Student student){
    //    student.setId(UUID.randomUUID().toString());
    //    students.add(student);
    //    System.out.println("Total elemnts in array" + students.size());
    //    
    //    return students;
    //}







    
}
