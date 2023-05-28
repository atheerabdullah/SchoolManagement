package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.ApiException.ApiException;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/Teacher")
@AllArgsConstructor

public class TeacherController {


    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        List<Teacher> teachers=teacherService.getAllTeachers();
        return ResponseEntity.status(200).body(teachers);
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiException("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("teacher Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");

    }
}
