public class Conversa {

    private int id;
    private Atendente atendente;
    private Ticket ticket;
    private String nomeTicket;
    private boolean anexoTicket;
    private String descricaoTicket;
    private String status;
    private String dataEHora;

    public Conversa(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getNomeTicket() {
        return nomeTicket;
    }

    public void setNomeTicket(String nomeTicket) {
        this.nomeTicket = nomeTicket;
    }

    public boolean isAnexoTicket() {
        return anexoTicket;
    }

    public void setAnexoTicket(boolean anexoTicket) {
        this.anexoTicket = anexoTicket;
    }

    public String getDescricaoTicket() {
        return descricaoTicket;
    }

    public void setDescricaoTicket(String descricaoTicket) {
        this.descricaoTicket = descricaoTicket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(String dataEHora) {
        this.dataEHora = dataEHora;
    }

    /*Incluir a Consulta como parâmetro no método garante que, ao criar um novo ticket, ele possa ser
      associado imediatamente à consulta correspondente.*/
//    public void criarTicket(Paciente paciente, TipoProblema tipoProblema, Consulta consulta) {
//        this.ticket = new Ticket();
//        this.ticket.setId(1);
//        this.ticket.setPaciente(paciente);
//        this.ticket.setTipoProblema(tipoProblema);
//        this.ticket.setConsulta(consulta);
//        this.status = "Em aberto";
//        System.out.println("Ticket criado com sucesso!");
//
//
//    }

    // ALTERAR STATUS DO TICKET
//    public void setStatusEmAndamento() {
//        this.status = "em andamento";
//    }
//
//    public void setStatusResolvido() {
//        this.status = "resolvido";
//    }

    public void detalhesDoTicket(){
        System.out.println("--Detalhes do ticket--");
        System.out.println("Status: " + this.getStatus());
    }
}
