//package com.miquankj.datasource;
//
//import com.miquankj.common.datasource.DruidConfig;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
////@Configuration（=============没有用到此数据源，先注释掉================）
////@MapperScan(basePackages = SecondaryDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "secondarySqlSessionFactory")
//public class SecondaryDataSourceConfig {
//
//    // 精确到 secondary 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.huace.mcollege.ent.api.dao.secondary";
//    static final String MAPPER_LOCATION = "classpath:mapper/secondary/*.xml";
//
//    @Value("${spring.datasource.secondary.url}")
//    private String url;
//
//    @Value("${spring.datasource.secondary.username}")
//    private String username;
//
//    @Value("${spring.datasource.secondary.password}")
//    private String password;
//
//    @Value("${spring.datasource.secondary.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.secondary.initial-size}")
//    private String initialSize;
//
//    @Value("${spring.datasource.secondary.min-idle}")
//    private String minIdle;
//
//    @Value("${spring.datasource.secondary.max-idle}")
//    private String maxIdle;
//
//    @Value("${spring.datasource.secondary.max-active}")
//    private String maxActive;
//
//    @Value("${spring.datasource.secondary.max-wait}")
//    private String maxWait;
//
//    @Value("${spring.datasource.secondary.time-between-eviction-runs-millis}")
//    private String timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.secondary.min-evictable-idle-time-millis}")
//    private String minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.secondary.test-while-idle}")
//    private String testWhileIdle;
//
//    @Value("${spring.datasource.secondary.test-on-borrow}")
//    private String testOnBorrow;
//
//    @Value("${spring.datasource.secondary.test-on-return}")
//    private String testOnReturn;
//
//    @Bean(name = "secondaryDataSource")
//    public DataSource secondaryDataSource() {
//
//        DruidConfig druidConfig = DruidConfig.builder()
//                .url(url)
//                .username(username)
//                .password(password)
//                .driverClassName(driverClassName)
//                .initialSize(initialSize)
//                .minIdle(minIdle)
//                .maxIdle(maxIdle)
//                .maxActive(maxActive)
//                .maxWait(maxWait)
//                .timeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis)
//                .minEvictableIdleTimeMillis(minEvictableIdleTimeMillis)
//                .testWhileIdle(testWhileIdle)
//                .testOnBorrow(testOnBorrow)
//                .testOnReturn(testOnReturn)
//                .build();
//
//        return druidConfig.dataSource("secondary");
//    }
//
//    @Bean(name = "secondaryTransactionManager")
//    public DataSourceTransactionManager secondaryTransactionManager() {
//        return new DataSourceTransactionManager(secondaryDataSource());
//    }
//
//    @Bean(name = "secondarySqlSessionFactory")
//    public SqlSessionFactory secondarySqlSessionFactory(@Qualifier("secondaryDataSource") DataSource secondaryDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(secondaryDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(SecondaryDataSourceConfig.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
//}
