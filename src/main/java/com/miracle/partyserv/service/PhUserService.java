package com.miracle.partyserv.service;

import com.miracle.partyserv.exception.PhException;
import com.miracle.partyserv.model.*;
import com.miracle.partyserv.repository.PhUserRepository;
import com.miracle.partyserv.repository.PhUserRoleRepository;
import com.miracle.partyserv.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PhUserService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final PhUserRepository phUserRepository;
    private final PhUserRoleRepository phUserRoleRepository;

    public PhUserService(AuthenticationManager authenticationManager, PhUserRepository phUserRepository, PasswordEncoder encoder, JwtUtils jwtUtils, PhUserRoleRepository phUserRoleRepository) {
        this.authenticationManager = authenticationManager;
        this.phUserRepository = phUserRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.phUserRoleRepository = phUserRoleRepository;
    }

    public void savePhUser(PhUser phUser) throws PhException {
        if (phUserRepository.existsByUsername(phUser.getUsername())) {
            throw new PhException(PhErrorType.UsernameAlreadyInUse, "Username is already in use.");
        }
        if (phUserRepository.existsByEmail(phUser.getEmail())) {
            throw new PhException(PhErrorType.EmailAlreadyInUse, "Email is already in use.");
        }

        phUser.setPassword(encoder.encode(phUser.getPassword()));
        Set<PhUserRole> roles = new HashSet<>();
        PhUserRole roleType = phUserRoleRepository.findByRoleType(PhRoleType.ROLE_USER);
        roles.add(roleType);
        phUser.setRoles(roles);
        phUserRepository.save(phUser);
    }

    public String loginPhUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        return jwtUtils.generateJwtToken(authentication);
    }
}
