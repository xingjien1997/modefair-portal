package com.modefair.portal.controller;

import com.modefair.portal.domain.LoginForm;
import com.modefair.portal.domain.Student;
import com.modefair.portal.domain.StudentSchedule;
import com.modefair.portal.service.ScheduleService;
import com.modefair.portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody LoginForm loginForm) {
        ResponseEntity responseEntity = null;
        try {
            Integer studentId = studentService.authenticate(loginForm.getUsername(), loginForm.getPassword());
            responseEntity = studentId != null ? new ResponseEntity<Integer>(studentId, HttpStatus.OK)
                    : new ResponseEntity<String>("Wrong username or password", HttpStatus.UNAUTHORIZED);;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add-new-student", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addNewStudent(@RequestBody Student student) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("student created", HttpStatus.OK);
        try {
            if (null != student.getStudentName()) {
                studentService.saveOrUpdate(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = ResponseEntity.badRequest().body("something went wrong during student creation");
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/find-all-students", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Student>> findAllStudents() {
        ResponseEntity<List<Student>> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/find-student-schedules-by-student-id/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<StudentSchedule>> findStudentSchedulesByStudentId(@PathVariable("sid") int id) {
        ResponseEntity<List<StudentSchedule>> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(studentService.findStudentSchedulesByStudentId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
}
