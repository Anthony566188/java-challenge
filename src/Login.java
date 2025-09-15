public abstract class Login {
    private String login;
    private String senha;

    // Construtor, getters e setters para login e senha
    public Login(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }



    // Método abstrato. As classes filhas devem implementá-lo.
    public abstract boolean autenticar();
}
