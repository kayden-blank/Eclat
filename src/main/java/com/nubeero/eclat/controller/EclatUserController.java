package com.nubeero.eclat.controller;

import com.nubeero.eclat.dto.CreateEclatUserDto;
import com.nubeero.eclat.dto.LoginDto;
import com.nubeero.eclat.dto.UpdateUserDto;
import com.nubeero.eclat.exception.EclatException;
import com.nubeero.eclat.model.eclatUser.EclatUser;
import com.nubeero.eclat.response.ResponseBodyObject;
import com.nubeero.eclat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/Eclat/user")
public class EclatUserController {
    @Autowired
    UserService userService;

    @PostMapping("signUp")
    public ResponseEntity<ResponseBodyObject> createUser(@RequestBody CreateEclatUserDto dto) throws EclatException {
        userService.createUser(dto);
       ResponseBodyObject response = userService.createUser(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto dto) throws EclatException {
        userService.updateUser(dto);
        ResponseBodyObject response = userService.updateUser(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto dto) throws EclatException{
        userService.login(dto);
        ResponseBodyObject response= new ResponseBodyObject();
        response.setSuccess(true);
        response.setTimeStamp(LocalDateTime.now());
        response.setMessage("login successful");
        response.setStatus("success");
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAllEclatUser() throws EclatException{
        List<EclatUser> eclatUsers= userService.findAll();
        return new ResponseEntity<>(eclatUsers, HttpStatus.OK);
    }


    @GetMapping("{userId}")
    public ResponseEntity<EclatUser> findById(@PathVariable @RequestParam Long userId) throws EclatException {
        if (userId == null) {
            throw new EclatException("user Id cannot be null");
        } else {
            EclatUser user= userService.findById(userId);
            return new ResponseEntity<>( user,HttpStatus.OK);
        }

        }

    }
