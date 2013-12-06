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

// FIXME : add validation on form
// FIXME : have a controller with model as param 

@Controller
public class UserController {

    private static final String SUCCESS = "user-home.jsp";
    private static final String FAIL = "home.jsp";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam String login, @RequestParam String password) {

	if (userService.find(login) != null) {
	    return new ModelAndView(FAIL, "login", login);
	}

	User user = userService.register(login, password);

	return new ModelAndView(SUCCESS, "user", user);
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam String login, @RequestParam String password) {

	User user = userService.find(login);
	if (user != null && user.getPassword().equals(password)) {
	    return new ModelAndView(SUCCESS, "user", user);
	}

	return new ModelAndView(FAIL, "login", login);
    }

    @RequestMapping(value = "/checkin.do", method = RequestMethod.POST)
    public ModelAndView checkin(@ModelAttribute("user") User user) {

	userService.checkin(user);

	return new ModelAndView(SUCCESS, "user", user);
    }

}
