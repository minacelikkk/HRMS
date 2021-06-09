package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import kodlamaio.hrms.dataAccess.abstracts.LinkDao;

import kodlamaio.hrms.entities.concretes.Link;

public class LinkManager implements LinkService{
	private LinkDao linkDao;
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
			this.linkDao.save(link);
			return new SuccessResult("Link eklendi.");
		}

	

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll(),"Data listelendi.");
	}

	@Override
	public DataResult<List<Link>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getByCandidateId(candidateId));
	}

}
