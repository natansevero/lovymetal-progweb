
package br.edu.ifpb.psd.lovymetal.controllers;

import br.edu.ifpb.psd.lovymetal.entidades.Usuario;
import br.edu.ifpb.psd.lovymetal.facade.FacadeFactory;
import br.edu.ifpb.psd.lovymetal.facade.FacadeIF;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author natan
 */
public class SolicitarAmizade implements CommandIF {
    
    private final FacadeIF facade;
    
    public SolicitarAmizade() {
        this.facade = FacadeFactory.criarFacadeFactory();
    }
    
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession();
        int id_solicitador = (int) session.getAttribute("idUsuario");
        int id_solicitante = Integer.parseInt(req.getParameter("id_solicitante"));
        
        if(facade.solicitarAmizade(id_solicitador, id_solicitante)) {
            
            Usuario usuario = facade.getById(id_solicitante);
            
            Map<String, String> dados_usuario = new HashMap<>();
            dados_usuario.put("id", ""+usuario.getID());
            dados_usuario.put("nome_completo", ""+usuario.getNome_completo());
            dados_usuario.put("apelido", ""+usuario.getApelido());
            dados_usuario.put("data_nasc", ""+usuario.getDatanasc());
            dados_usuario.put("cidade", ""+usuario.getCidade());
            dados_usuario.put("email", ""+usuario.getEmail());
            dados_usuario.put("profissao", ""+usuario.getProfissao());
            dados_usuario.put("descricao", ""+usuario.getDescricao());
            dados_usuario.put("sexo", ""+usuario.getSexo());
            dados_usuario.put("status", ""+usuario.getStatus());
            dados_usuario.put("altura", ""+usuario.getAltura());
            dados_usuario.put("peso", ""+usuario.getPeso());
            dados_usuario.put("cor_cabelo", ""+usuario.getCabelo());
            dados_usuario.put("foto_perfil", ""+usuario.getFotoperfil());
            
            // Status da solicitação para fazer UX com o botão de solicitar
            req.setAttribute("statusSolicitacao", facade.verificarSolicitacao(id_solicitador, id_solicitante));
            
            // Jogo os dados do usuário acessado novamente no escopo de requisição
            req.setAttribute("acessoPerfil", dados_usuario);
            
            RequestDispatcher dispatcher = req.getRequestDispatcher("acessar_perfil.jsp");
            dispatcher.forward(req, res);
        } else {
            res.sendRedirect("home.jsp");
        }
    }
    
}
