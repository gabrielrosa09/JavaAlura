package com.placeti.first_spring_app.controller;

import com.placeti.first_spring_app.paciente.DadosCadastroPaciente;
import com.placeti.first_spring_app.paciente.DadosListagemPaciente;
import com.placeti.first_spring_app.paciente.Paciente;
import com.placeti.first_spring_app.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = "nome") Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
}
