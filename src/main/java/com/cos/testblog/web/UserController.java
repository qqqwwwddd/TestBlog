package com.cos.testblog.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.testblog.web.dto.JoinReqDto;
import com.cos.testblog.web.dto.LoginReqDto;
import com.cos.testblog.domain.user.User;
import com.cos.testblog.domain.user.UserRepository;

@Controller
public class UserController {

	private UserRepository userRepository;	
	private HttpSession session;
	
	// DI
	public UserController(UserRepository userRepository, HttpSession session) { 
		this.userRepository = userRepository;	
		this.session = session;
	}
	@GetMapping("/test/query/join")
	public void testQueryJoin() {
		userRepository.join("정인", "1234", "cos@naver.com");
	
	}
	
	
	@GetMapping("/test/join")
	public void testJoin() {
		User user = new User();
		user.setUsername("ssar");
		user.setPassword("1234");
		user.setEmail("ssar@naver.com");
		
		// insert into user(username, password, email) values('ssar', '1234', 'ssar@nate.com');
		userRepository.save(user);
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		
		// 1. username, password 받기
		System.out.println(dto.getUsername());
		System.out.println(dto.getPassword());
		
		// 2. DB -> 조회
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
		
		if(userEntity == null) {
			return "redirect:/loginForm";
		}else {
			session.setAttribute("principal", userEntity);
			return "redirect:/home";
		}
	}

		@PostMapping("/join")
		public String join(JoinReqDto dto) { 

			User user = new User(); // user는 비어있음
			user.setUsername(dto.getUsername()); // dto에서 가져오기
			user.setPassword(dto.getPassword());
			user.setEmail(dto.getEmail());

			userRepository.save(user);
		
		return "redirect:/loginForm";
	}
}