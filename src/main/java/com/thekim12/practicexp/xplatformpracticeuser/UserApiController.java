package com.thekim12.practicexp.xplatformpracticeuser;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.tx.PlatformException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/inquire")
    public void inquire(HttpServletResponse response) throws PlatformException {
        userService.findAllUser(response);
    }

    @PostMapping("/join")
    public void joinProc(@RequestBody User user){
        User userEntity = user.toEntity();
        userService.joinUser(userEntity);
    }

}
