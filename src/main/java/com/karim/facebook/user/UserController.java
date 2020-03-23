package com.karim.facebook.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;


    //------------------- addUser -------------------------

    @PostMapping("")
    public ResponseEntity<User> addUser(@RequestBody User user){
        if (service.findByEmail(user.getEmail()))
            return new ResponseEntity(HttpStatus.CONFLICT);
        return new ResponseEntity<User>(service.addUser(user) , HttpStatus.OK);
    }

    //------------------- getAll ----------------------

    @GetMapping("")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = service.getAllUser();
        if (users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<User>>(users , HttpStatus.OK);
    }

    //------------------- get User ------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        User user = service.getUser(id);
        if (user == null){
            System.out.println("Not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
    }

    //---------------------- Update User ----------------------------

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id , @RequestBody User user){
        User currentUser = service.getUser(id);
        if (currentUser == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        currentUser.setFirstname(user.getFirstname());
        currentUser.setSurname(user.getSurname());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setDate(user.getDate());
        currentUser.setGender(user.getGender());
        service.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser , HttpStatus.OK);
    }

    //---------------------- delete User ---------------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id){
        User user = service.getUser(id);
        if (user == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    //------------------ delete All ---------------------------------
    @DeleteMapping("")
    public ResponseEntity<User> deleteAll(){
        service.deleteAll();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }



}
