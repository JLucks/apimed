package br.com.ufma.apimed.model.consulta;

import br.com.ufma.apimed.model.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long idMedico,

                                       @NotNull
                                       Long idPaciente,

                                       @NotNull
                                       @Future
                                       LocalDateTime data,

                                       Especialidade especialidade) {
}
