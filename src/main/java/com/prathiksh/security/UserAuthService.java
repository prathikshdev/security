package com.prathiksh.security;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAuthEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findByUserName(username).orElseThrow();
    }

    public void persistUser(UserAuthDto userAuthDto) {
        System.out.println("Inside persistUser");
        UserAuthEntity user = new UserAuthEntity();
        BeanUtils.copyProperties(userAuthDto,user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserAuthEntity savedUser = userAuthRepository.save(user);
        if(!ObjectUtils.isEmpty(savedUser)) {
            System.out.println("User saved Successfully");
        }
    }
}
