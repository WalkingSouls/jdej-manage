//package com.miquankj.datasource;
//
//import com.miquankj.common.datasource.DruidConfig;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//// 扫描 Mapper 接口并容器管理
//@MapperScan(basePackages = PrimaryDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "primarySqlSessionFactory")
//public class PrimaryDataSourceConfig {
//
//    // 精确到 primary 目录，以便跟其他数据源隔离
//    static final String PACKAGE = "com.miquankj.api.dao";
//    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";
//
//    @Value("${spring.datasource.primary.url}")
//    private String url;
//
//    @Value("${spring.datasource.primary.username}")
//    private String username;
//
//    @Value("${spring.datasource.primary.password}")
//    private String password;
//
//    @Value("${spring.datasource.primary.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.primary.initial-size}")
//    private String initialSize;
//
//    @Value("${spring.datasource.primary.min-idle}")
//    private String minIdle;
//
//    @Value("${spring.datasource.primary.max-idle}")
//    private String maxIdle;
//
//    @Value("${spring.datasource.primary.max-active}")
//    private String maxActive;
//
//    @Value("${spring.datasource.primary.max-wait}")
//    private String maxWait;
//
//    @Value("${spring.datasource.primary.time-between-eviction-runs-millis}")
//    private String timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.primary.min-evictable-idle-time-millis}")
//    private String minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.primary.test-while-idle}")
//    private String testWhileIdle;
//
//    @Value("${spring.datasource.primary.test-on-borrow}")
//    private String testOnBorrow;
//
//    @Value("${spring.datasource.primary.test-on-return}")
//    private String testOnReturn;
//
//    @Bean(name = "primaryDataSource")
//    @Primary
//    public DataSource primaryDataSource() {
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
//        return druidConfig.dataSource("primary");
//    }
//
//    @Bean(name = "primaryTransactionManager")
//    @Primary
//    public DataSourceTransactionManager primaryTransactionManager() {
//        return new DataSourceTransactionManager(primaryDataSource());
//    }
//
//    @Bean(name = "primarySqlSessionFactory")
//    @Primary
//    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource primaryDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(primaryDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(PrimaryDataSourceConfig.MAPPER_LOCATION));
//        return sessionFactory.getObject();
//    }
//}
