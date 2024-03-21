package br.edu.imepac.services;// AlunoService.java
import br.edu.imepac.interfaces.AlunoDAO;

import java.util.List;

public class AlunoService {
    private AlunoDAO alunoDAO;

    public AlunoService(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public List<Aluno> getAllAlunos() {
        return alunoDAO.getAllAlunos();
    }

    public Aluno getAlunoById(int id) {
        return alunoDAO.getAlunoById(id);
    }

    public void addAluno(Aluno aluno) {
        alunoDAO.addAluno(aluno);
    }

    public void updateAluno(Aluno aluno) {
        alunoDAO.updateAluno(aluno);
    }

    public void deleteAluno(int id) {
        alunoDAO.deleteAluno(id);
    }
}