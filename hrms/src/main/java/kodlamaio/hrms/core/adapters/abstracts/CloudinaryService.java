package kodlamaio.hrms.core.adapters.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);


}