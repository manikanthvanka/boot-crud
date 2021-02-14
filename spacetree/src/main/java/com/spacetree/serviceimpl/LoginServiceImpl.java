package com.spacetree.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacetree.dto.LoginDTO;
import com.spacetree.repository.UserReposistory;
import com.spacetree.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserReposistory userReposistory;


	@Override
	public boolean register(LoginDTO loginDto) {
	 boolean isSucess = false;
	
	 try {
		 
			
			isSucess = true;
			
	 }catch(Exception e) {
		 e.printStackTrace(); 
		
	 }
		
		
		return isSucess;
	}
	
	
	
}
