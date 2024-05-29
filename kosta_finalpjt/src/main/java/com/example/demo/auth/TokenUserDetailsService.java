package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;
import com.example.demo.member.MemberDao;

@Service
public class TokenUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberDao dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Member m = dao.findById(username).orElseThrow(() -> new UsernameNotFoundException("not found id:" + username));
		System.out.println("security_token service:" + m);
		return new TokenUserDetails(m);
	}

}
