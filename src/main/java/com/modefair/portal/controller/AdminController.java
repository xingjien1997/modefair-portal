package com.modefair.portal.controller;

import com.modefair.portal.domain.LoginForm;
import com.modefair.portal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/find-all-map-with-lecturer-and-courses", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, List<String>> findAllLecturers() {
        return adminService.findAllMapWithLecturerAndCourses();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> authenticate(@RequestBody LoginForm loginForm) {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = adminService.authenticate(loginForm.getUsername(), loginForm.getPassword()) ? new ResponseEntity<>(loginForm.getUsername(), HttpStatus.OK)
                    : new ResponseEntity<>("Wrong username or password", HttpStatus.UNAUTHORIZED);;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }
}
