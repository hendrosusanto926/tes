
package com.rest.API.Controller;


import com.rest.API.model.User;
import com.rest.API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class SignupController {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@RequestParam(value = "username", defaultValue = "null") String username,
                         HttpServletRequest request
    ){

        String password = request.getHeader("password");
        String confirmPassword = request.getHeader("confirmPassword");

        if(password == null || confirmPassword == null){
            return "Password Missing Error!!";
        }

        if(username!=null){
            for(User user : UserRepository.findAll()){
                if(user.getUsername().equals(username)){
                    System.out.println("Username Already Exists Error");
                    return "Username Already Exists Error";
                }
            }
        }
        if(!password.equals(confirmPassword)){
            System.out.println("Password Mismatch Error!!");
            //return appropriate response error message
            return "Password Mismatch Error!!";
        }
        else if(password.length()<8){
            System.out.println("Weak Password Error");
            return "Password is short. Minimum 8 characters required";
        }
        else {
            System.out.println("Inserting Record");
            //System.out.println("Inserting Record with \nUsername: " + username + "\tPassword: " + password);
            UserRepository.save(new User(username, bCryptPasswordEncoder.encode(password)));
            return "Record Inserted Successfully!";
        }
    }
}
