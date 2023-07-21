package com.learn.student.userdetails.usercontroller;



import com.learn.student.userdetails.userservice.UserServic;
import com.learn.student.userdetails.newuserinfo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Controller {

    private final UserServic userServic;

    @Autowired
    public Controller(UserServic userServic) {
        this.userServic = userServic;
    }

    @PostMapping
    public void createUser(@RequestBody UserModel user) {
        userServic.createUser(user);
    }
}
