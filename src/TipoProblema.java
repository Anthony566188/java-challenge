import java.util.ArrayList;
import java.util.List;

public class TipoProblema {
    private int id;
    private String nome;

    //private List<TipoProblema> tiposDeProblema;

//    public TipoProblema() {
//        this.tiposDeProblema = new ArrayList<>();
//        tiposDeProblema.add(new TipoProblema(){{setId(1); setNome("Problema de Agendamento");}}); // {{}} bloco de inicialização de instância
//        tiposDeProblema.add(new TipoProblema(){{setId(2); setNome("Solicitação de Receita");}});
//        tiposDeProblema.add(new TipoProblema(){{setId(3); setNome("Dúvida Financeira");}});
//    }

//    public List<TipoProblema> getTodosOsTipos() {
//        return tiposDeProblema;
//    }

    public TipoProblema(String nome) {
        this.nome = nome;
    }

    public TipoProblema(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
