package sample.mybatis.conf;

import sample.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 获取第二个数据库的连接信息，在application.properties中配置，并指定特定的前缀
 *
 * @author 小翼
 * @version 1.0.0
 */
@Configuration
public class MyBatisConfiguration {

	public MyBatisConfiguration()
	{
		System.out.println("MyBatisConfiguration被创建");
		System.out.println(properties);
		System.out.println(sqlSessionFactory);
		System.out.println(sessionTemplate);
		System.out.println("-------------------------------------");
	}

	@Autowired
	CustomDataSourceProperties properties;
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	SqlSessionTemplate sessionTemplate;
  //  @Autowired
    //private UserMapper userMapper;
    
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(){
		System.out.println("创建了SqlSessionTemplate");
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	    
    @Bean  
    public UserMapper userMapper() {    
    	return sessionTemplate.getMapper(UserMapper.class); 
    }
    
	@Bean
	public SqlSessionFactory sqlSessionFactory(){
		System.out.println("创建了sqlSessionFactory");
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.driverClassName(this.properties.getDriverClassName())
				.url(this.properties.getUrl())
				.username(this.properties.getUsername())
				.password(this.properties.getPassword());
		bean.setDataSource(factory.build());
		ClassPathResource classPathResource = new ClassPathResource("UserMapper.xml");
		Resource[] resources = {classPathResource};
		bean.setMapperLocations(resources);
		SqlSessionFactory sqlSessionFactory = null;  
         try {  
                sqlSessionFactory = bean.getObject();  
         }catch (Exception e) {  
                e.printStackTrace();  
                System.exit(0);  
         }
         return sqlSessionFactory;
	}
}
