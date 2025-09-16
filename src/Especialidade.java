import java.util.ArrayList;
import java.util.List;

public class Especialidade {
    private int id;
    private String nome;

    // Lista estática (compartilhada por todos os objetos)
    private static List<Especialidade> listaDeEspecialidades = new ArrayList<>();

    public Especialidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Método para registrar especialidades
    public static void adicionarEspecialidade(Especialidade especialidade) {
        listaDeEspecialidades.add(especialidade);
    }

    // Retorna a lista completa
    public static List<Especialidade> getEspecialidades() {
        return listaDeEspecialidades;
    }
}