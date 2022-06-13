package com.spring.wlg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class OracleDatabaseConfig {


    private static Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("org.hibernate.dialect.Dialect", "org.hibernate.dialect.Oracle11gDialect");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        properties.setProperty("hibernate.event.merge.entity_copy_observer", "allow");
        return properties;
    }

    @Bean(destroyMethod = "")
    @Primary
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("jdbc/suirsigmads");
    }


}