package kodlamaio.hrms.core.adapters.abstracts;

public interface FakeMernisService {
	boolean checkIfRealPerson(String firstName, String lastName,
			String identityNumber, String birthYear);


}
