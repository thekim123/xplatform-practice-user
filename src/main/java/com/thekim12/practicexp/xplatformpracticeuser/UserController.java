package com.thekim12.practicexp.xplatformpracticeuser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String home(){
        return "login";
    }

    @GetMapping("/join")
    public String join(){
        return "join";
    }

    @PostMapping("/join")
    public String joinProc(User user){
        User userEntity = user.toEntity();
        System.out.println(user.getUsername());
        userService.joinUser(userEntity);
        return "login";
    }
}
