package sample.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.mybatis.domain.User;
import sample.mybatis.service.UserService;

import javax.annotation.Resource;


/**
 * 程序的入口
 *
 * @author 小翼
 * @version 1.0.0
 */
@EnableAutoConfiguration
@ComponentScan({"sample.mybatis.service","sample.mybatis.mapper","sample.mybatis.conf"})
@MapperScan("sample.mybatis.mapper")
@Controller
public class Application  {

	@Resource
	private UserService  userService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("启动成功！");
	}

	@RequestMapping("/test")
	@ResponseBody
	public String showDome()
	{

		User u=userService.readUserByUsername("12");
		System.out.println("测试一下"+u);
		return userService.toString();
	}


}