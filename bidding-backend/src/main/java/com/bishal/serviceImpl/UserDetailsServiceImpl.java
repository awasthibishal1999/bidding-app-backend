package com.bishal.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bishal.model.User;
import com.bishal.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 @Autowired 
     UserRepo userRepository;

	@Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		 if (user == null) throw new UsernameNotFoundException(username);
          grantedAuthorities.add(new SimpleGrantedAuthority("user"));
          return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        		  grantedAuthorities);
	}

}
