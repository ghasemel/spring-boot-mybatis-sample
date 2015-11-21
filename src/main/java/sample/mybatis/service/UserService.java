package sample.mybatis.service;

import sample.mybatis.domain.User;
import sample.mybatis.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * User��Service
 *
 * @author С��
 * @version 1.0.0
 */
@Service
public class UserService {

	
	@Resource
	private UserMapper userMapper;

	public UserService()
	{
		System.out.println("业务逻辑对象创建");
		System.out.println("\t"+userMapper);

	}
	
	
	
	public User readUserByUsername(String username){
		User selectUser = userMapper.selectUser(username);
		return selectUser;
	}
}
