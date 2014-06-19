package net.therap.controller;

import net.therap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudentList(ModelMap modelMap){
       modelMap.addAttribute("students", studentService.getStudentList().toString());
       return "studentList";
    }
}
