package example.spring.boot.controller;

import example.spring.boot.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Karl Bennett
 */
@Controller
@RequestMapping("/user")
public class RetrieveUserController {

    private final UserRepository userRepository;

    @Autowired
    public RetrieveUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ModelAndView retrieve(@PathVariable Long id) {
        return new ModelAndView("retrieveUser").addObject(userRepository.findOne(id));
    }
}
