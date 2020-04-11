package covid.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covid.models.PersonalInfo;
import covid.repositories.PersonalInfoRepository;

@Service
public class PersonalInfoService {

	@Autowired
	private PersonalInfoRepository personalInfoRepository;
	
	public Iterable<PersonalInfo> getAll() {
		return personalInfoRepository.findAll();
	}
	
	public Optional<PersonalInfo> getById(String id) {
		return personalInfoRepository.getById(id);
	}
	
	public void addPersonalInfo(PersonalInfo personalInfo) {
		personalInfoRepository.save(personalInfo);
	}
	
	public void editPersonalInfo(String id, PersonalInfo personalInfo) {
		Optional<PersonalInfo> p = personalInfoRepository.getById(id);
		
		if(p.isPresent()) {
			personalInfo.setId(p.get().getId());
			personalInfoRepository.save(personalInfo);
		}
	}
	
	public void deletePersonalInfo(String id) {
		Optional<PersonalInfo> p = personalInfoRepository.getById(id);
		
		if(p.isPresent()) {
			personalInfoRepository.delete(p.get());
		}
	}
}
