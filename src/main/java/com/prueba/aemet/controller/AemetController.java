package com.prueba.aemet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prueba.aemet.modelDTO.MunicipioDTO;
import com.prueba.aemet.modelDTO.PrediccionMunDiaSigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.aemet.service.AemetService;

import java.util.List;

@RestController
@FeignClient(name = "aemet", url = "http://localhost:8080")
public class AemetController {
    @Autowired
    private AemetService apiService;

    @GetMapping("/api/municipios")
    public List<MunicipioDTO> getMunicipios() throws JsonProcessingException {
        return apiService.getMunicipios();
    }

    @GetMapping("/api/prediccionDiaSiguiente")
    public PrediccionMunDiaSigDTO getPrediccionMunDiaSig(@RequestParam String idMunicipio, @RequestParam String unidadMedida) {
        return apiService.gePrediccionMunDiaSig(idMunicipio, unidadMedida);
    }


}