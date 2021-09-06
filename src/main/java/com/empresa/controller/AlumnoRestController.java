package com.empresa.controller;

import com.empresa.service.AlumnoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

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
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Alumno> insertarAlumno(@RequestBody Alumno obj) {
        if (obj == null) {// osea no hay datos
            return ResponseEntity.noContent().build();
        } else {
            obj.setIdAlumno(0); // mandamos id para q tenga datos y asi jpa inserte pero en la base datos esta
                                // autoIncrement
            Alumno objSalida = alumnoServicio.insertaActualizaAlumno(obj);
            return ResponseEntity.ok(objSalida);
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Alumno> actualizarAlumno(@RequestBody Alumno obj) {
        if (obj == null) {// osea no hay datos
            return ResponseEntity.noContent().build();
        } else {
            Optional<Alumno> optAlumno = alumnoServicio.obtenerPorId(obj.getIdAlumno());
            if (optAlumno.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                Alumno objSalida = alumnoServicio.insertaActualizaAlumno(obj);
                return ResponseEntity.ok(objSalida);
            }
        }
    }

}
