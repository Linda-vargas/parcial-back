package pe.gob.unmsm.pc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Config {

		@Bean(name = {"conexion_sgv"}) 
		@Primary 
		@ConfigurationProperties(prefix = "sgv.datasource")
		public DataSource hostdataSource() {
			return DataSourceBuilder.create().build(); 
		}
		@Bean(name = {"jdbc_sgv"}) 
		@Autowired 
		public JdbcTemplate hostJdbcTemplate(@Qualifier("conexion_sgv") DataSource dbconexion) { 
			return new  JdbcTemplate(dbconexion); 	
		}
		
		

}
