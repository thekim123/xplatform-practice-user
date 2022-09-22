package com.thekim12.practicexp.xplatformpracticeuser;

import com.thekim12.practicexp.xplatformpracticeuser.model.User;
import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.tx.PlatformException;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    }
    
    @PutMapping("/update")
    public void update(@RequestBody User user) {
    	userService.updateUser(user);
    }
    
    @DeleteMapping("/delete")
    public void delete(HttpServletRequest request) throws PlatformException {
    	userService.deleteUser(request);
    }

}
