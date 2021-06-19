package com.miracle.partyserv.security.details;

import com.miracle.partyserv.model.PhUser;
import com.miracle.partyserv.repository.PhUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PhUserRepository phUserRepository;

    public UserDetailsServiceImpl(PhUserRepository phUserRepository) {
        this.phUserRepository = phUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!phUserRepository.existsByUsername(username)) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        PhUser user = phUserRepository.findByUsername(username);
        return UserDetailsImpl.build(user);
    }
}
