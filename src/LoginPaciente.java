public class LoginPaciente extends Login {
    private Paciente paciente;

    public LoginPaciente(String login, String senha) {
        super(login, senha);
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public boolean autenticar() {
        return false;
    }
}
