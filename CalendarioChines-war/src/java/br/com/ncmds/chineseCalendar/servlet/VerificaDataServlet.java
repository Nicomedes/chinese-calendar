/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ncmds.chineseCalendar.servlet;

import br.com.ncmds.chineseCalendar.modelo.NomeData;
import br.com.ncmds.chineseCalendar.dao.NomeDataDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author juliano
 */
public class VerificaDataServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            NomeData nd = new NomeData();
            int idade = 0;
            String signoChines;
            List<NomeData> lista; 
            
            int anoNascimento =  Integer.parseInt(request.getParameter("anoNascimento"));
            nd.setNome(request.getParameter("nome"));
            nd.setAnoNascimento(anoNascimento);
            Calendar cal = Calendar.getInstance();
            idade = cal.get(Calendar.YEAR) - anoNascimento;
            signoChines = ChineseSign.converte(anoNascimento);
            nd.setIdade(idade);
            nd.setSignoChines(signoChines);
            
            
            
            NomeDataDAO ndDao = new NomeDataDAO();
            
            ndDao.adiciona(nd);
            
            
            lista = new NomeDataDAO().getLista();

            
          
            out.println("<html>");
            out.println("<head>");
          
            out.println("<title>Calendário Chinês - Resultados</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"
                    + nd.getNome() +", você tem"
                    + nd.getIdade() + ", e seu signo no horóscopo chinês é: " 
                    + nd.getSignoChines() + "</h1>");
            out.println("<tr>");
            out.println("<table border=\"1\">");
            out.println("<td>Nome</td>");
            out.println("<td>Ano de Nascimento</td>");
            out.println("<td>Idade</td>");
            out.println("<td>Signo Chinês</td>");
            out.println("</tr>");
            
            
            for(NomeData ndl: lista){
                out.println("<tr>");
                out.print("<td>"+ ndl.getNome() + "</td>");
                out.print("<td>"+ ndl.getAnoNascimento() + "</td>");  
                out.print("<td>"+ ndl.getIdade() + "</td>");  
                out.print("<td>"+ ndl.getSignoChines() + "</td>");
                out.println("</tr>");
        }
            
            
            
            out.println("<a href=index.jsp>Clique aqui para voltar</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(VerificaDataServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
