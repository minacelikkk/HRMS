package kodlamaio.hrms.core.utilities.imageUpload;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

@Service
public interface ImageUploadService {
	
	DataResult<Map> uploadImageFile(MultipartFile imageFile);

}
