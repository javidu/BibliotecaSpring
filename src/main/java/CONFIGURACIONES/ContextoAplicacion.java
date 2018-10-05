/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONFIGURACIONES;

import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author JAVIER
 */
@Configuration
@ComponentScan(basePackages = {"Servicios.Implementación","DAO.JPA"})
@EnableJpaRepositories(basePackages = "DAO.JPA",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class ContextoAplicacion {
    
    /**
     * @return  * @Bean
    public LibroDAO libroDAO(){
       return new LibroDAOJPAImpl();         
    }
    
    @Bean
    public CategoriaDAO categoriaDAO(){
       return new CategoriaDAOJPAImpl();         
    }**/
     
    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/biblioteca");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("DTO");
        
        HibernateJpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
        hibernate.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
        hibernate.setShowSql(true);
        
        entityManager.setJpaVendorAdapter(hibernate);
        
        return entityManager;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setEntityManagerFactory(emf);
        return tx;
    }
    
    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
