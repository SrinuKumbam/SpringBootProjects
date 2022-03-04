package com.boot.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.boot.training.model.RestUser;
import com.boot.training.model.VO.Department;
import com.boot.training.model.VO.ResponseEntityVO;
import com.boot.training.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public RestUser saveUser(RestUser user) {
		return userRepository.save(user);
	}
	
	public List<RestUser> getUsers(){
		return (List<RestUser>) userRepository.findAll();
	}
	
	public String updateUser(Long userId, RestUser user) {
		if(userRepository.existsById(userId)) {
			userRepository.save(user);
			return "User has been updated";
		}
		return "User not found";
	}
	
	public String deleteUser(Long id) {
		if(userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "User has been deleted";
		}
		return "User not found";
	}

	public ResponseEntityVO getUserDetails(Long userId) {
		ResponseEntityVO vo = new ResponseEntityVO();
		RestUser user = userRepository.findById(userId).get();
		Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(dept);
		return vo;
	}
}
