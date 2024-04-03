package br.com.ufma.apimed.model.consulta.validacoes.agendamento;

import br.com.ufma.apimed.infra.exception.ValidacaoException;
import br.com.ufma.apimed.model.consulta.DadosAgendamentoConsulta;
import br.com.ufma.apimed.model.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
