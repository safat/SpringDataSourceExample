package net.therap.controller;

import net.therap.domain.User;
import net.therap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping ("/test")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping (method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        List<User> userList = userService.getUserList();

        String userNames = "";
        for (User user : userList) {
            userNames += user.toString() + " </br>";
        }
        model.addAttribute("message", userList.size()+" <hr> </br> " + userNames);

        return "hello";
    }

}