package net.guillaume.damocles.web;

import net.guillaume.damocles.entities.*;
import net.guillaume.damocles.services.GuardService;
import net.guillaume.damocles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static final String SUCCESS = "home";

    @RequestMapping(value = "/")
    public String create() {
        return SUCCESS;
    }

}
