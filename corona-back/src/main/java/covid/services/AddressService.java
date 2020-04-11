package covid.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covid.models.Address;
import covid.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Iterable<Address> getAll() {
		return addressRepository.findAll();
	}
	
	public Optional<Address> getById(String id) {
		return addressRepository.getById(id);
	}
	
	public void addAddress(Address address) {
		addressRepository.save(address);
	}
	
	public void editAddress(String id, Address address) {
		Optional<Address> a = addressRepository.getById(id);
		
		if(a.isPresent()) {
			address.setId(a.get().getId());
			addressRepository.save(address);
		}
	}
	
	public void deleteAddress(String id) {
		Optional<Address> a = addressRepository.getById(id);
		
		if(a.isPresent()) {
			addressRepository.delete(a.get());
		}
	}
}
