package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.imageUpload.ImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;

import kodlamaio.hrms.entities.concretes.CandidateImage;


@Service
public class CandidateImageManager  implements CandidateImageService{

	private CandidateImageDao candidateImageDao;
	private ImageUploadService imageUploadService;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao, ImageUploadService imageUploadService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<CandidateImage>>(candidateImageDao.findAll());
	}

	@Override
	public Result add(MultipartFile imageFile, CandidateImage candidateImage) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		candidateImage.setImageUrl(uploadImage.get("url"));
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Resim eklendi.");
	}

	@Override
	public DataResult<CandidateImage> getById(int id) {
		return new SuccessDataResult<CandidateImage>(candidateImageDao.getById(id));
	}

	@Override
	public DataResult<CandidateImage> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateImage>(candidateImageDao.getByCandidate_Id(candidateId));
	}

	@Override
	public Result delete(CandidateImage candidateImage) {
		this.candidateImageDao.delete(candidateImage);
		return new SuccessResult("Resim silindi");
	}

	@Override
	public Result update(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("Resim guncellendi");
	}




	

}
	

	