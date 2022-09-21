package com.thekim12.practicexp.xplatformpracticeuser;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.tx.PlatformException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

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


}
