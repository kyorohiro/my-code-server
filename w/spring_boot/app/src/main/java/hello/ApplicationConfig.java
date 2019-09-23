package hello;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "hello")
class ApplicationConfig {

    @Value("${datasource.one.url}")
    private String url;

    @Value("${datasource.one.username}")
    private String user;

    @Value("${datasource.one.password}")
    private String password;

    @Value("${datasource.one.driverClassName}")
    private String driverClass;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(getDataSource());
       return sessionFactory.getObject();
    }
}