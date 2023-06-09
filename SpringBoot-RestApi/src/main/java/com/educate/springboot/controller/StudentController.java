package com.educate.springboot.controller;

import com.educate.springboot.bean.Students;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    @GetMapping("/students")
    public ResponseEntity<Students> getStudent() {
        Students student = new Students(1, "Pratap", "Student", "Student@email.com");
        // return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        //we can pass custom header in responseentity class
        return ResponseEntity.ok()
                .header("Content-Type", "application/json ")
                .body(student);

    }

    @GetMapping("/list")
    public ResponseEntity<List<Students>> getStudentList() {
        List<Students> list = new ArrayList<>();
        list.add(new Students(1, "Pratap", "Student", "Student@email.com"));
        list.add(new Students(2, "Pratap", "Student", "Student@email.com"));
        list.add(new Students(3, "Pratap", "Student", "Student@email.com"));
        list.add(new Students(4, "Pratap", "Student", "Student@email.com"));
        return ResponseEntity.ok(list);
    }

    //Spring Boot Rest APi With Path Variable
    //{ID} URI template Variable
    //http://localhost:8080/student/1
    @GetMapping("/student/{id}")
    public ResponseEntity<Students> studentsPathVariable(@PathVariable long id) {

        return ResponseEntity.ok(new Students(id, "jhds", "Student", "Student@email.com"));
    }


    //http://localhost:8080/student/query?id=66&firstName=Pratap&lastName=Adhav
    @GetMapping("/student/query")
    public ResponseEntity<Students> studentsQuery(@RequestParam long id, @RequestParam String firstName, @RequestParam String lastName) {

        return ResponseEntity.ok(new Students(id, firstName, lastName, "Student@email.com"));
    }

    // Spring Boot Rest Api That handle Http Post request
    //@postMapping() @requestBody

    @PostMapping("/create-student")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Students> createStudent(@RequestBody Students students) {

        System.out.println(students.getEmail());
        System.out.println(students.getId());
        System.out.println(students.getFirstName());
        System.out.println(students.getLastName());
        return new ResponseEntity<>(students,HttpStatus.CREATED);
    }

    @PutMapping("/update-student/{id}")
   // @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Students> updateStudent(@RequestBody Students students, @PathVariable Long id) {
        System.out.println(students.getEmail());
        System.out.println(students.getId());
        System.out.println(students.getFirstName());
        System.out.println(students.getLastName());
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @DeleteMapping("/delete-student/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable Long id) {

        System.out.println("deleted Student");

    }
}
