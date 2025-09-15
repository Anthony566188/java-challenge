import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private Connection conn;

    public Sistema() throws SQLException {
        OracleDataSource ods = new OracleDataSource();

        //configurando a URL
        ods.setURL(url);

        ods.setUser(Credencials.user);
        ods.setPassword(Credencials.password);

        conn = ods.getConnection();
        System.out.println("Conectado");
        System.out.println(conn.getCatalog());
    }


    public boolean inserirTipoProblema(TipoProblema tipoProblema){
        String sql = "INSERT INTO TB_TIPO_PROBLEMA (nome_tipo_problema) VALUES (?)";


        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoProblema.getNome());
            ps.execute();
            //conn.commit();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão NULA!");
            } else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }  finally {
            System.out.println("Fechando a conexão com o banco de dados...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean inserirPaciente(Paciente paciente){
        String sql = "INSERT INTO TB_PACIENTE (cpf_paciente, nome_paciente, rg_paciente," +
                " data_nascimento_paciente, endereco_paciente) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getRg());
            ps.setString(4, paciente.getDataNascimento());
            ps.setString(5, paciente.getEndereco());

            ps.execute();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão NULA!");
            } else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }  finally {
            System.out.println("Fechando a conexão com o banco de dados...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;

    }

    public boolean inserirEspecialidade(Especialidade especialidade){
        String sql = "INSERT INTO TB_ESPECIALIDADE (nome_especialidade) VALUES (?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getNome());
            ps.execute();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão NULA!");
            } else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }  finally {
            System.out.println("Fechando a conexão com o banco de dados...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    // PARA INSERIR UM MÉDICO É NECESSÁRIO CONTER UMA ESPECIALIDADE INSERIDA NA TB_ESPECIALIDADE
    public boolean inserirMedico(Medico medico, Especialidade especialidade, MedicoLogin medicoLogin){
        String sql = "INSERT INTO TB_MEDICO (id_especialidade, nome_medico) VALUES (?,?)";

        String sqlLogin = "INSERT INTO TB_MEDICO_LOGIN (id_medico, login, senha) VALUES (?,?,?)";


        try {
            // 1) Inserir médico e pegar ID gerado
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, especialidade.getId());
            ps.setString(2, medico.getNome());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            int idMedico = 0;
            if (rs.next()) {
                idMedico = rs.getInt(1);
            }
            rs.close();
            ps.close();

            // agora você pode setar no objeto (se quiser reaproveitar depois)
            medico.setId(idMedico);
            medicoLogin.setMedico(medico);

            // 2) Inserir login/senha com o id do médico
            PreparedStatement psLogin = conn.prepareStatement(sqlLogin);
            psLogin.setInt(1, idMedico);
            psLogin.setString(2, medicoLogin.getLogin());
            psLogin.setString(3, medicoLogin.getSenha());
            psLogin.execute();
            psLogin.close();

        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão NULA!");
            } else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }  finally {
            System.out.println("Fechando a conexão com o banco de dados...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean inserirConsulta(Consulta consulta, Paciente paciente, Medico medico){
        String sql = "INSERT INTO TB_CONSULTA (id_paciente, id_medico, data_e_hora_inicio, data_e_hora_fim) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, paciente.getId());
            ps.setInt(2 , medico.getId());
            ps.setTimestamp(3, Timestamp.valueOf(consulta.getDataEHoraInicio()));
            ps.setTimestamp(4, Timestamp.valueOf(consulta.getDataEHoraFim()));
            ps.execute();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão NULA!");
            } else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }  finally {
            System.out.println("Fechando a conexão com o banco de dados...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    /*
    PARA CRIAR UM TICKET É NECESSÁRIO QUE NO BANCO JÁ ESTEJA INSERIDO: UM ID DO PACIENTE NA TB_PACIENTE,
    UM ID DO TIPO DE PROBLEMA NA TB_TIPO_PROBLEMA E UM ID DA CONSULTA NA TB_CONSULTA
    */

    public boolean criarTicket(Ticket ticket, Paciente paciente, TipoProblema tipoProblema, Consulta consulta){
        String sql = "INSERT INTO TB_TICKET () VALUES (?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ticket.getId());
            ps.setInt(2, paciente.getId());
            ps.setInt(3, tipoProblema.getId());
            ps.setInt(4, consulta.getId());

            ps.execute();
            //conn.commit();
        } catch (SQLException e) {
            if (conn == null) {
                System.err.println("Conexão NULA!");
            } else {
                System.err.println("Erro no PreparedStatement!");
            }
            e.printStackTrace();
            return false;
        }  finally {
            System.out.println("Fechando a conexão com o banco de dados...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
        return true;
    }

    //Delete
    //Método excluir()

    public boolean excluirTicket(int id) {

        String sql = "DELETE FROM TB_TICKET WHERE id_ticket = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir um Ticket!");
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("Fechando a conexão...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Não foi possível encerrar a conexão!");
                e.printStackTrace();
            }
        }

        return true;
    }

    public boolean excluirTipoProblema(int id) {

        String sql = "DELETE FROM TB_TIPO_PROBLEMA WHERE id_tipo_problema = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir um Tipo de Problema!");
            e.printStackTrace();
            return false;
        }finally {
            System.out.println("Fechando a conexão...");
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Não foi possível encerrar a conexão!");
                e.printStackTrace();
            }
        }

        return true;
    }

    //UPDATE
    // método atualizar()

    public void atualizarTipoProblema(TipoProblema tipoProblema) {
        System.out.println(" --- Atualizando o Tipo de Problema: " + tipoProblema.getNome() + " ---");

        String sql = "UPDATE TB_TIPO_PROBLEMA "
                + "SET nome_tipo_problema = ? "
                + "WHERE id_tipo_problema = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoProblema.getNome());
            ps.setInt(2, tipoProblema.getId());
            ps.execute();
            System.out.println("Tipo de Problema atualizado com sucesso!");
        } catch (SQLException e) {
            if(conn == null) {
                System.out.println("Conexão NULA!");
            }else {
                System.out.println("Erro na instrução PreparedStatement!");
            }
            e.printStackTrace();
        }finally {
            if(conn != null) {
                try {
                    System.out.println("\n>>> Fechando a conexão...");
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Ticket> listar(){

        //criar a lista de tickets
        List<Ticket> tickets = new ArrayList<Ticket>();

        //configurar a query
        String sql = "SELECT * FROM TB_TICKET";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id = rs.getInt(1);
                int id_paciente = rs.getInt(2);
                int id_tipo_problema = rs.getInt(3);
                int id_consulta = rs.getInt(4);

                // Você precisa criar os objetos a partir dos IDs
                // Uma forma simples seria criar objetos com apenas o ID, se você não precisa dos outros dados
                Paciente paciente = new Paciente(id_paciente);
                TipoProblema tipoProblema = new TipoProblema(id_tipo_problema);
                Consulta consulta = new Consulta(id_consulta);

                tickets.add(new Ticket(id, paciente, tipoProblema, consulta));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tickets;
    }
}
