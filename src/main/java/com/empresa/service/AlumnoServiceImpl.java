package com.empresa.service;
import java.util.List;
import com.empresa.entity.Alumno;
import com.empresa.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    private AlumnoRepository alummnoRepository;

    @Override
    public List<Alumno> listaAlumno() {
        // TODO Auto-generated method stub
        return alummnoRepository.findAll();
    }

}
