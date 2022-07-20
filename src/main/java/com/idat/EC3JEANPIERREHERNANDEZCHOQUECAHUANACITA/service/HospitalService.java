package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service;

import java.util.List;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.HospitalDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.HospitalDTOResponse;

public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHospital(Integer id);
	List<HospitalDTOResponse> listarHospital();
	HospitalDTOResponse obtenerHospitalId(Integer id);
	

}
