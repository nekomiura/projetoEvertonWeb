package br.edu.imepac.dao;// AlunoDAOImpl.java
import br.edu.imepac.entities.Aluno;
import br.edu.imepac.interfaces.AlunoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {
    private static final String GET_ALL_ALUNOS_QUERY = "SELECT * FROM alunos";
    private static final String GET_ALUNO_BY_ID_QUERY = "SELECT * FROM alunos WHERE id = ?";
    private static final String ADD_ALUNO_QUERY = "INSERT INTO alunos (idade, matricula, nome) VALUES (?, ?, ?)";
    private static final String UPDATE_ALUNO_QUERY = "UPDATE alunos SET idade = ?, matricula = ?, nome = ? WHERE id = ?";
    private static final String DELETE_ALUNO_QUERY = "DELETE FROM alunos WHERE id = ?";

    private Connection connection;

    public AlunoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Aluno> getAllAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(GET_ALL_ALUNOS_QUERY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setIdade(rs.getInt("idade"));
                aluno.setMatricula(rs.getInt("matricula"));
                aluno.setNome(rs.getString("nome"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    @Override
    public Aluno getAlunoById(int id) {
        // Similar to getAllAlunos, but with WHERE clause
    }

    @Override
    public void addAluno(Aluno aluno) {
        // Similar to getAlunoById, but with INSERT query
    }

    @Override
    public void updateAluno(Aluno aluno) {
        // Similar to addAluno, but with UPDATE query
    }

    @Override
    public void deleteAluno(int id) {
        // Similar to getAllAlunos, but with DELETE query
    }
}