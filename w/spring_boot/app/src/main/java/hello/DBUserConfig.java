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
@MapperScan(basePackages = "hello.user.mapper", sqlSessionFactoryRef = "sqlSessionFactoryUser")
class DBUserConfig {

    @Value("${datasource.user.url}")
    private String url;

    @Value("${datasource.user.username}")
    private String user;

    @Value("${datasource.user.password}")
    private String password;

    @Value("${datasource.user.driverClassName}")
    private String driverClass;

    @Bean(name = "dataSourceUser")
    @Primary
    public DataSource dataSourceUser() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("transactionManagerUser")
    @Primary
    public DataSourceTransactionManager transactionManagerUser() {
        return new DataSourceTransactionManager(dataSourceUser());
    }

    @Bean("sqlSessionFactoryUser")
    @Primary
    public SqlSessionFactory sqlSessionFactoryUser() throws Exception {
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(dataSourceUser());
       return sessionFactory.getObject();
    }
}
