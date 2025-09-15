public class LoginAtendente extends Login {
    private Atendente atendente;

    public LoginAtendente(String login, String senha) {
        super(login, senha);
    }


    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @Override
    public boolean autenticar() {
        return false;
    }
}