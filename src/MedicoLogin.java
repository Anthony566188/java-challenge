public class MedicoLogin extends Login {
    private Medico medico;

    public MedicoLogin(String login, String senha) {
        super(login, senha);

    }

    @Override
    public boolean autenticar() {
        // Lógica de autenticação específica para médico
        // Exemplo: Buscar no banco de dados se o login e senha do médico são válidos
        System.out.println("Autenticando como Médico...");
        // Retorna true se a autenticação for bem-sucedida, false caso contrário
        return true;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
