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
@MapperScan(basePackages = "hello.app.mapper", sqlSessionFactoryRef = "sqlSessionFactoryApp")
class DBAppConfig {

    @Value("${datasource.app.url}")
    private String url;

    @Value("${datasource.app.username}")
    private String user;

    @Value("${datasource.app.password}")
    private String password;

    @Value("${datasource.app.driverClassName}")
    private String driverClass;

    @Bean(name = "dataSourceApp")
    public DataSource dataSourceApp() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("transactionManagerApp")
    public DataSourceTransactionManager transactionManagerApp() {
        return new DataSourceTransactionManager(dataSourceApp());
    }
    @Bean("sqlSessionFactoryApp")
    public SqlSessionFactory sqlSessionFactoryApp() throws Exception {
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(dataSourceApp());
       return sessionFactory.getObject();
    }
}
