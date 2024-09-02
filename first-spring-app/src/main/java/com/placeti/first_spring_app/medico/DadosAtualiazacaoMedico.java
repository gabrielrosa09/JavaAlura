package com.placeti.first_spring_app.medico;

import com.placeti.first_spring_app.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualiazacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
