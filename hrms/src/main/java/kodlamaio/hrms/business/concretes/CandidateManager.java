package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.PrewritingService;
import kodlamaio.hrms.business.abstracts.ProgrammingSkillService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CvDto;
@Service
public class CandidateManager implements CandidateService{
	private CandidateDao candidateDao;
	private CandidateImageService candidateImageService;
	private LanguageService languageService;
	private LinkService linkService;
	private ProgrammingSkillService programmingSkillService;
	private SchoolService schoolService;
	private JobExperienceService jobExperienceService;
	private PrewritingService prewritingService;
	
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateImageService candidateImageService,
			LanguageService languageService, LinkService linkService, ProgrammingSkillService programmingSkillService,
			SchoolService schoolService, JobExperienceService jobExperienceService, PrewritingService prewritingService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateImageService = candidateImageService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.programmingSkillService = programmingSkillService;
		this.schoolService = schoolService;
		this.jobExperienceService = jobExperienceService;
		this.prewritingService = prewritingService;
	}

	

	@Override
	public DataResult<List<Candidate>>getAll(){
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data listelendi.");
	}
	@Override
	public Result add(Candidate candidate) {
		if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentityNumber() == null|| candidate.getBirthYear()==null
				|| candidate.getEmail() == null || candidate.getPassword() == null ) {
			return new ErrorResult("Herhangi bir alan boş bırakılamaz ! ");
			
			
		}else if(candidateDao.getByIdentityNumber(candidate.getIdentityNumber())!= null) {
				return new ErrorResult("Kullanilan bir  TCkimlik no  girdiniz!");
				
		}		
		
		else {
			candidateDao.save(candidate);
			return new SuccessResult("Kayıt başarılı bir şekilde tamamlandı!");
		}

}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentityNumber(identityNumber),"İş arayanlar Tc kimlik no ya göre listelendi.");
	}
	
	@Override
	public DataResult<CvDto> getCvById(int id) {
		CvDto cv = new CvDto();
		cv.setCandidate(this.getById(id).getData());
		cv.setCandidateImages(this.candidateImageService.getById(id).getData());
		cv.setLanguages(this.languageService.getByCandidateId(id).getData());
		cv.setLinks(this.linkService.getByCandidateId(id).getData());
		cv.setProgrammingSkills(this.programmingSkillService.getByCandidateId(id).getData());
		cv.setSchools(this.schoolService.getAll().getData());
		cv.setExperiences(this.jobExperienceService.getAll().getData());
		cv.setPrewritings(this.prewritingService.getByCandidateId(id).getData());
		return new SuccessDataResult<>(cv, "Cv oluşturuldu");
	}



	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}
}



	
