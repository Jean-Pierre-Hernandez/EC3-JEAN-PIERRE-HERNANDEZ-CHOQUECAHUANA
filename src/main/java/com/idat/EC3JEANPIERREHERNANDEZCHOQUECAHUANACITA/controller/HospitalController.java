package com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.HospitalDTORequest;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.dto.HospitalDTOResponse;
import com.idat.EC3JEANPIERREHERNANDEZCHOQUECAHUANACITA.service.HospitalService;

@Controller
@RequestMapping( path = "/hospitales/v1")
public class HospitalController {
	@Autowired
    private HospitalService service;

    @RequestMapping("/listar")
    public @ResponseBody
    ResponseEntity<List<HospitalDTOResponse>> listar() {

        return new ResponseEntity<List<HospitalDTOResponse>>(service.listarHospital(), HttpStatus.OK) ;
    }

    @RequestMapping( path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody HospitalDTORequest hospital) {
        service.guardarHospital(hospital);
        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
    	HospitalDTOResponse c =service.obtenerHospitalId(id);
        if(c != null) {
            service.eliminarHospital(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<Void> actualizar(@RequestBody HospitalDTORequest hospital) {
    	HospitalDTOResponse c =service.obtenerHospitalId(hospital.getIdHospital());
        if(c != null) {
            service.actualizarHospital(hospital);
            return  new ResponseEntity<Void>(HttpStatus.OK);
        }
        return  new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<HospitalDTOResponse> obtenerId(@PathVariable Integer id) {
    	HospitalDTOResponse c =service.obtenerHospitalId(id);
        if(c != null) {
            return  new ResponseEntity<HospitalDTOResponse>(service.obtenerHospitalId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<HospitalDTOResponse>(HttpStatus.NOT_FOUND);
    }

}
