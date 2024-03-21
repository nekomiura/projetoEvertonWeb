package br.edu.imepac.interfaces;// AlunoDAO.java
import java.util.List;

public interface AlunoDAO {
    List<Aluno> getAllAlunos();
    Aluno getAlunoById(int id);
    void addAluno(Aluno aluno);
    void updateAluno(Aluno aluno);
    void deleteAluno(int id);
}