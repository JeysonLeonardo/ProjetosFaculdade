package service;

import java.util.List;

import model.Dono;
import repository.DonoRepository;

public class DonoService {

	private DonoRepository donoRepository;
	
	public DonoService() {
		this.donoRepository = new DonoRepository();
	}
	
	public void save(Dono dono) {
		this.donoRepository.save(dono);
	}
	
	public void update(Dono dono) {
		this.donoRepository.update(dono);
	}
	
	public void delete(Dono dono) {
		this.donoRepository.delete(dono);
	}
	
	public List<Dono> find() {
		return this.donoRepository.find();
	}
}
