package com.iris.db.config;

import com.iris.db.domain.constant.SqlConstant;
import com.iris.db.service.SystemEnvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;


@Configuration
public class DataSourceHelper {
    private Logger log= LoggerFactory.getLogger(DataSourceHelper.class);

    @Autowired
    private SystemEnvService systemEnvService;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @PostConstruct
    public void init(){
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName(driver);
            URI uri= new URI(url.replace("jdbc:",""));
            String host=uri.getHost();
            int port=uri.getPort();
            String path=uri.getPath();
            connection= DriverManager.getConnection(
                    "jdbc:mysql://"+host+":"+port,
                    username,password
            );
            statement=connection.createStatement();
            String sql=String.format(SqlConstant.CHECK_DATABASE,SqlConstant.DATABASE_NAME);
            ResultSet resultSet = statement.executeQuery(sql);
            if(!resultSet.next()){
                // not found database, initial database first
                systemEnvService.prepareDatabase();
            }
            if(resultSet.isClosed()){
                resultSet.close();
            }
        } catch (ClassNotFoundException | URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if(connection!=null) {
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
