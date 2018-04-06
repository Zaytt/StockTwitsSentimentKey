package stocktwits.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stocktwits.model.login.APIUser;
import stocktwits.services.UserService;

@RestController
@RequestMapping("stocktwits/user")

public class UserController {

    @Autowired
    UserService userService;

    // Create APIUser
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public APIUser createUser(@RequestBody APIUser user) {
        return userService.createUser(user);
    }
}
