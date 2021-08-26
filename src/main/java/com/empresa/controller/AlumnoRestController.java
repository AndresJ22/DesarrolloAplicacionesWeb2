package com.empresa.controller;

import com.empresa.service.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.empresa.entity.Alumno;
@RestController
@RequestMapping("/rest/alumno")
public class AlumnoRestController {
    @Autowired
    private AlumnoService alumnoServicio;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<List<Alumno>> listarAlumnos() {    
        List<Alumno> lista = alumnoServicio.listaAlumno();
        // for (Alumno alumno : lista) {
        // 	   System.out.println(alumno);
		// }
        return ResponseEntity.ok(lista);
    }
}
