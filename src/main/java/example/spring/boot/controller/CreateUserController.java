package example.spring.boot.controller;

import example.spring.boot.data.UserRepository;
import example.spring.boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Karl Bennett
 */
@Controller
@RequestMapping("/user/create")
public class CreateUserController {

    private final UserRepository userRepository;

    @Autowired
    public CreateUserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = GET)
    public String view() {
        return "createUser";
    }

    @RequestMapping(method = POST)
    public String create(User user) {
        return "redirect:/user/" + userRepository.save(user).getId();
    }
}
