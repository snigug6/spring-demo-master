package com.thinkxfactor.springdemo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.thinkxfactor.springdemo.controllers.entity.User;
import com.thinkxfactor.springdemo.controllers.entity.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String error(){
        return "ERROR";
    }

    int count=0;
    @GetMapping("/counter")
    public String count() {
        count = count + 1;
        return "The counter value is : " + count;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }


    @GetMapping("/hello2")
    public Map<String,String> sayHello2(){

        Map<String,String> respMap = new HashMap<>();
        respMap.put("Name","Ayan");
        respMap.put("Age","21");
        respMap.put("Dept","CSE");

        return respMap;
    } 



    @GetMapping("/getUser")
    public User getUser()
     {
        User us1 = new User();
        us1.setName("Raj");
        us1.setDepartment("CSE");
        us1.setAge(21);
        return us1;
    }

    @GetMapping("/getUsers")
    public List<User> getUsers()
     {
        List<User> users =new ArrayList<>();

        User us1 = new User();
        us1.setName("Raj");
        us1.setDepartment("CSE");
        us1.setAge(21);

        users.add(us1);

        User us2 = new User();
        us2.setName("Rajesh");
        us2.setDepartment("IT");
        us2.setAge(41);

        users.add(us2);


        return users;
    }



    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "Hello " + name + "!!";


    }

    @GetMapping("/greetUser")
    public User greetUser(@RequestParam String name,@RequestParam String department,@RequestParam int age){

        User user = new User();
        user.setName(name);
        user.setDepartment(department);
        user.setAge(age);
        return user;

    }

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        System.out.println("Student object recieved");
        User persistuser = userRepository.save(user);
        System.out.println("Student object saved");

        // DB op
        return persistuser;

    }

    


    
}



