package kodlamaio.hrms.business.abstracts;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImage;

public interface CandidateImageService {
	
	DataResult<List<CandidateImage>>getAll();
	Result add(MultipartFile file, CandidateImage candidateImage);
	DataResult<CandidateImage> getById(int id);
	DataResult<CandidateImage> getByCandidateId(int candidateId);
	Result delete(CandidateImage candidateImage);
	Result update(CandidateImage candidateImage);
	
	
	

}
