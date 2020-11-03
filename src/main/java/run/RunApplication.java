package run;

import java.util.ArrayList;
import java.util.List;

import model.*;
import repository.DonoRepository;

public class RunApplication {
	
	private DonoRepository donoRepository;
	
	public static void main(String[] args) {
		RunApplication run = new RunApplication();
		run.create();
		run.read();
//		run.update();
//		run.delete();
		
	}

	public void create() {
		Animal gato = new Animal();
		gato.setNome("Axis");
		gato.setRaca("Persa");
		
		Animal cachorro = new Animal();
		cachorro.setNome("Dogball");
		cachorro.setRaca("Pastor Alemão");
		
		List<Animal> animais = new ArrayList<>();
		animais.add(gato);
		animais.add(cachorro);
		
		Dono dono = new Dono();
		dono.setNome("Jeyson");
		dono.setCpf("549.475.164-37");
		dono.setAnimais(animais);
		
		this.donoRepository = new DonoRepository();
		donoRepository.save(dono);
		
	}
	
	public void read() {
		List<Dono> list = donoRepository.find();
		
		for (Dono dono : list) {
			System.out.println("-----------------------");
			System.out.println("Código:" + dono.getCodigo());
			System.out.println("Dono:" + dono.getNome());
			System.out.println("CPF:" + dono.getCpf());
			System.out.println("");
			
			if (!dono.getAnimais().isEmpty()) {
				
				for (Animal animal : dono.getAnimais()) {
					System.out.println("Animal:" + animal.getNome() + " " + "Raça:" + animal.getRaca());
				}
				
			}
			
			System.out.println("-----------------------");
		}
	}
	
	public void update() {
		Dono dono = donoRepository.findById(1);
		dono.setNome("Jeyson Leonardo");
		
		Animal gato = new Animal();
		gato.setNome("MT");
		gato.setRaca("Persa");
		
		List<Animal> animais = dono.getAnimais();
		animais.add(gato);
		dono.setAnimais(animais);
		
		this.donoRepository = new DonoRepository();
		donoRepository.update(dono);
	}
	
	public void delete() {
		Dono dono = donoRepository.findById(1);
		donoRepository.delete(dono);
		
	}
 }
