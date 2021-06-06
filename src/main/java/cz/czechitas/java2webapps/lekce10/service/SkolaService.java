package cz.czechitas.java2webapps.lekce10.service;


import cz.czechitas.java2webapps.lekce10.entity.Student;
import cz.czechitas.java2webapps.lekce10.entity.Trida;
import cz.czechitas.java2webapps.lekce10.repository.StudentRepository;
import cz.czechitas.java2webapps.lekce10.repository.TridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SkolaService {

    private final StudentRepository studentRepository;
    private final TridaRepository tridaRepository;

    @Autowired
    public SkolaService(StudentRepository studentRepository, TridaRepository tridaRepository) {
        this.studentRepository = studentRepository;
        this.tridaRepository = tridaRepository;
    }

    public List<Trida> seznam() {
        return tridaRepository.OrderByNazev();
    }

    public Optional<Trida> jednaTrida(Short id) {
        return tridaRepository.findById(id);
    }

    public Optional<Student> jedenStudent(Integer id) {
        return studentRepository.findById(id);
    }

}
