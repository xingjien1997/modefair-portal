package com.modefair.portal.controller;

import com.modefair.portal.domain.Lecturer;
import com.modefair.portal.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/api/lecturer")
public class LecturerController {
    @Autowired
    LecturerService lecturerService;

    @RequestMapping(value = "/find-all-lecturers", method = RequestMethod.GET)
    @ResponseBody
    public List<Lecturer> findAllLecturers() {
        return lecturerService.findAll();
    }
}
