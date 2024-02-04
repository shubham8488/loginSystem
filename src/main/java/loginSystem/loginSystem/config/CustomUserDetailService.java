package loginSystem.loginSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import loginSystem.loginSystem.model.LoginUser;
import loginSystem.loginSystem.repository.LoginUserRepository;

public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	LoginUserRepository user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		LoginUser ur=user.findByUsername(username);
		if(ur==null ) {
			System.out.println("User Not Found in DB !!");
			throw new UsernameNotFoundException("User Not Found in DB !!");
		} 
		return new CustomUserDetail(ur);
	}

}
