package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.HospitalDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.HospitalDTOResponse;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.model.Hospital;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HospitalRepository repository;
	

	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		Hospital h = new Hospital();
		h.setNombre(hospital.getNombre());
		h.setDescripcion(hospital.getDescripcion());
		h.setDistrito(hospital.getDistrito());
		repository.save(h);
	}

	@Override
	public void actualizarHospital(HospitalDTORequest hospital) {
	
		Hospital h = new Hospital();
		h.setIdHospital(hospital.getIdHospital());
		h.setNombre(hospital.getNombre());
		h.setDescripcion(hospital.getDescripcion());
		h.setDistrito(hospital.getDistrito());
		
		repository.saveAndFlush(h);
	}

	@Override
	public void eliminarHospital(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		
		List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> h = repository.findAll();
		for (Hospital hospital : h) {
			
			dto = new HospitalDTOResponse();
			
			dto.setIdHospital(hospital.getIdHospital());
			dto.setNombre(hospital.getNombre());
			dto.setDescripcion(hospital.getDescripcion());
			dto.setDistrito(hospital.getDistrito());
			
			listar.add(dto);
		}
		
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setIdHospital(hospital.getIdHospital());
		dto.setNombre(hospital.getNombre());
		dto.setDescripcion(hospital.getDescripcion());
		dto.setDistrito(hospital.getDistrito());
			
		return dto;
	}

}
