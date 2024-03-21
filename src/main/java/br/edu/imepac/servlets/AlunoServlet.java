package br.edu.imepac.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AlunoServlet extends HttpServlet {
    private AlunoService alunoService;

    @Override
    public void init() throws ServletException {
        super.init();
        alunoService = new AlunoService(new AlunoDAOImpl(Database.getConnection()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests (for listing all students, getting a student by ID, etc.)
        String action = request.getParameter("action");
        if (action == null) {
            // List all students
            List<Aluno> alunos = alunoService.getAllAlunos();
            // Send alunos to JSP or JSON response
        } else if (action.equals("getById")) {
            // Get student by ID
            int id = Integer.parseInt(request.getParameter("id"));
            Aluno aluno = alunoService.getAlunoById(id);
            // Send aluno to JSP or JSON response
        }
        // Add other actions as needed
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle POST requests (for adding a new student)
        // Extract student data from request parameters
        int idade = Integer.parseInt(request.getParameter("idade"));
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String nome = request.getParameter("nome");
        // Create Aluno object
        Aluno aluno = new Aluno(idade, matricula, nome);
        // Add aluno to database
        alunoService.addAluno(aluno);
        // Send success message or redirect to another page
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle PUT requests (for updating an existing student)
        // Similar to doPost but with updating an existing student
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle DELETE requests (for deleting an existing student)
        // Extract student ID from request parameters
        int id = Integer.parseInt(request.getParameter("id"));
        // Delete student from database
        alunoService.deleteAluno(id);
        // Send success message or redirect to another page
    }
}