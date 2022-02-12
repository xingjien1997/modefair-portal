package com.modefair.portal.controller;

import com.modefair.portal.domain.Schedule;
import com.modefair.portal.domain.StudentSchedule;
import com.modefair.portal.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/find-all-by-lecturer-id/{lid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Schedule> findAllByLecturerId(@PathVariable("lid") int id) {
        return scheduleService.findAllByLecturerId(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/find-available-schedules-by-student-id/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Schedule>> findAvailableSchedulesByStudentId(@PathVariable("sid") int id) {
        ResponseEntity<List<Schedule>> responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(scheduleService.findAvailableSchedulesByStudentId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/add-new-schedule-by-student-id-and-schedule-id", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> addNewScheduleByStudentIdAndScheduleId(@RequestBody StudentSchedule schedule) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>("schedule created", HttpStatus.OK);
        try {
            if (null != schedule.getSchedule()) {
                scheduleService.saveOrUpdate(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = ResponseEntity.badRequest().body("something went wrong during schedule insertion");
        }
        return responseEntity;
    }

}
