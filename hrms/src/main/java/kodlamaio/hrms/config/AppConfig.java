package kodlamaio.hrms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service

public class AppConfig {
	@Bean
	public ModelMapper modelMapper() {
			
		return new ModelMapper();
	}
	
	
	@Bean 
	public Cloudinary cloudinary() {
		
	return	new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "wissen",
				"api_key", "793285435792967",
				"api_secret", "fMrGwN65vZoTvCJJni0r7yGJ8sE"
				));
	}

}


