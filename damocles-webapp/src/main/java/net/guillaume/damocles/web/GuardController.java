package net.guillaume.damocles.web;

import java.util.ArrayList;
import java.util.List;

import net.guillaume.damocles.entities.Guard;
import net.guillaume.damocles.entities.Message;
import net.guillaume.damocles.entities.Recipient;
import net.guillaume.damocles.entities.Trigger;
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

@Controller
@RequestMapping(value = "/guard")
public class GuardController {

    private static final String SUCCESS = "user-home";
    private static final String GUARD = "guard";

    @Autowired
    private GuardService guardService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = GET)
    public String createView() {
        return GUARD;
    }


    @RequestMapping(value = "/create", method = POST)
    public ModelAndView create(@ModelAttribute User user, @RequestParam String message, @RequestParam String recipient) {

        Message m = new Message(message);
        Trigger t = new Trigger();
        List<Recipient> recipients = new ArrayList<Recipient>();
        recipients.add(new Recipient(recipient));

        Guard g = guardService.create(m, t, recipients);

        user.getGuards().add(g);
        userService.save(user);

        return new ModelAndView(SUCCESS, "user", user);
    }


}
