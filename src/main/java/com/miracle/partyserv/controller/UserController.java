package com.miracle.partyserv.controller;

import com.miracle.partyserv.Dto.LoginPhUserDto;
import com.miracle.partyserv.Dto.SavePhUserDto;
import com.miracle.partyserv.exception.PhException;
import com.miracle.partyserv.mapper.PhUserMapper;
import com.miracle.partyserv.model.PhResponse;
import com.miracle.partyserv.service.PhUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final PhUserService phUserService;
    private final PhUserMapper phUserMapper;

    public UserController(PhUserService phUserService, PhUserMapper phUserMapper) {
        this.phUserService = phUserService;
        this.phUserMapper = phUserMapper;
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(new PhResponse("OK", "hello from test method :3"));
    }

    @PostMapping("/save-user")
    public ResponseEntity<?> savePhUser(@RequestBody SavePhUserDto savePhUserDto) throws PhException {
        phUserService.savePhUser(phUserMapper.toEntity(savePhUserDto));
        return new ResponseEntity<>(new PhResponse("OK", "user successfully registered"), HttpStatus.CREATED);
    }

    @PostMapping("/login-user")
    public ResponseEntity<?> loginPhUser(@RequestBody LoginPhUserDto loginPhUserDto) {
        return ResponseEntity.ok(new PhResponse("OK", phUserService.loginPhUser(loginPhUserDto.getUsername(), loginPhUserDto.getPassword())));
    }
}
