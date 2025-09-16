import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        // Criando o objeto Sistema para chamar os métodos
        Sistema sistema = new Sistema();

        // Criando um paciente
        Paciente paciente = new Paciente(1, "123456", "Paciente 1", "123456789", "01/07/06", "Endereço 1");

        // Criando um tipo de problema
        TipoProblema tipoProblema = new TipoProblema("Problema com tal coisa");
        TipoProblema tipoProblema2 = new TipoProblema("Problema com tal coisa 2");

        // Criando uma especialidade
        //Especialidade especialidade = new Especialidade( "Cardiologia");
        Especialidade especialidade1 = new Especialidade("Especialidade teste final");


        // Criando um médico
        Medico medico = new Medico(especialidade1, "Medico 1");

        // Criando uma consulta
        // Aqui, a consulta começará no dia 14/09/2025 às 15h00 e terminará às 16h00
        Consulta consulta = new Consulta(1, paciente, medico,
                LocalDateTime.of(2025, 9, 14, 15, 0),
                LocalDateTime.of(2025, 9, 14, 16, 0));




        // Criando o objeto login para chamar o método
        MedicoLogin medicoLogin = new MedicoLogin("medico123", "12345678");

        //System.out.println(sistema.inserirTipoProblema(tipoProblema) ? "Tipo de problema inserido!" : "Tipo de problema NÃO inserido!");
        //System.out.println(sistema.inserirTipoProblema(tipoProblema2) ? "Tipo de problema inserido!" : "Tipo de problema NÃO inserido!");

        //System.out.println(sistema.inserirPaciente(paciente) ? "Paciente inserido!" : "Paciente NÃO inserido!");
        System.out.println(sistema.inserirEspecialidade(especialidade1) ? "Especialidade inserida!" : "Especialidade NÃO inserida!");
        System.out.println(sistema.inserirMedico(medico, especialidade1, medicoLogin) ? "Médico inserido!" : "Médico NÃO inserido!");
        //System.out.println(sistema.inserirConsulta(consulta, paciente, medico) ? "Consulta inserida!" : "Consulta NÃO inserida!");
        //System.out.println(sistema.criarTicket(new Ticket(1), paciente, tipoProblema, consulta) ? "Ticket criado!" : "Ticket NÃO Criado!");

//        System.out.println(sistema.excluirTicket(1) ?
//						"Ticket Removido!" : "Ticket NÃO removido!");
//        System.out.println(sistema.excluirEspecialidade(2) ?
//						"Especialidade Removida!" : "Especialidade NÃO removida!");
//        System.out.println(sistema.excluirTipoProblema(1) ?
//					"Tipo de Problema Removido!" : "Tipo de Problema NÃO removido!");

        //sistema.atualizarTipoProblema(new TipoProblema(1, "Problema com tal coisa 2"));

//        List<Ticket> tickets = sistema.listar();
//        for (Ticket ticket : tickets) {
//            System.out.println("ID do Ticket: " + ticket.getId());
//            System.out.println("ID do Paciente: " + ticket.getPaciente().getId());
//            System.out.println("ID do Tipo de Problema: " + ticket.getTipoProblema().getId());
//            System.out.println("ID da consulta: " + ticket.getConsulta().getId());
//            System.out.println("\n------------------------------------\n");
//        }





    }
}