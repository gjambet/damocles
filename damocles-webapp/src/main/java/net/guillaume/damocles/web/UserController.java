package net.guillaume.damocles.web;

import net.guillaume.damocles.entities.User;
import net.guillaume.damocles.services.GuardService;
import net.guillaume.damocles.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.*;

// FIXME : add validation on form
// FIXME : have a controller with model as param 

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final String SUCCESS = "user-home";
    private static final String FAIL = "home";
    private static final String REGISTER = "register";
    private static final String LOGIN = "login";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = GET)
    public String registerView() {
        return REGISTER;
    }

    @RequestMapping(value = "/login", method = GET)
    public String loginView() {
        return LOGIN;
    }


    @RequestMapping(value = "/register", method = POST)
    public ModelAndView register(@RequestParam String login, @RequestParam String password) {

        if (userService.find(login) != null) {
            return new ModelAndView(FAIL, "login", login);
        }

        User user = userService.register(login, password);

        return new ModelAndView(SUCCESS, "user", user);
    }

    @RequestMapping(value = "/login", method = POST)
    public ModelAndView login(@RequestParam String login, @RequestParam String password) {

        User user = userService.find(login);
        if (user != null && user.getPassword().equals(password)) {
            return new ModelAndView(SUCCESS, "user", user);
        }

        return new ModelAndView(FAIL, "login", login);
    }

    @RequestMapping(value = "/checkin", method = POST)
    public ModelAndView checkin(@ModelAttribute("user") User user) {

        userService.checkin(user);

        return new ModelAndView(SUCCESS, "user", user);
    }

}
