
package br.edu.ifsul.controle;


import br.edu.ifsul.dao.EquipamentoDAO;
import br.edu.ifsul.dao.ServicoDAO;
import br.edu.ifsul.dao.OrdemServicoDAO;
import br.edu.ifsul.modelo.Foto;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.util.Util;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Telmo Junior
 */

@Named(value = "controleOrdemServico")
@SessionScoped
public class ControleOrdemServico implements Serializable {
    
    @EJB
    private OrdemServicoDAO dao;
    
    @EJB
    private EquipamentoDAO daoEquipamento;
    
    private OrdemServico objeto;
    
    @EJB
    private ServicoDAO servicoDao;
    
    private ItemServico itemServico;
    
    private Boolean novoItemServico;
	
    private Foto foto;
    
    public ControleOrdemServico(){
        
    }
    
    public void novoItemServico(){
        
        setItemServico(new ItemServico());
        novoItemServico = true;
        System.out.println("itemServico: "+getItemServico());
    }    
    public void alterarItemServico(int index){
        setItemServico(objeto.getItemServicos().get(index));
        novoItemServico = false;
    }            
    public void salvarItemServico(){
        if (novoItemServico){
            objeto.adicionarServico(getItemServico());
        }
        Util.mensagemInformacao("Serviço adicionado com sucesso");
    }                
    public void removerItemServico(int index){
        objeto.removerServico(index);
        Util.mensagemInformacao("Serviço removido com sucesso");
    }

    public void gerarParcelas(){
        objeto.getContasReceber().clear();
        objeto.gerarContasReceber();
    }
    
        public void novaFoto() {
        setFoto(new Foto());
    }

    public void salvarFoto() {
        objeto.adicionarFoto(getFoto());
        Util.mensagemInformacao("Foto adicionada com sucesso!");
    }

    public void removerFoto(int index) {
        objeto.removerFoto(index);
        Util.mensagemInformacao("Foto removida com sucesso!");
    }

    public void enviarFoto(FileUploadEvent event) {
        try {
            getFoto().setArquivo(event.getFile().getContents());
            String nomeFoto = event.getFile().getFileName();
            nomeFoto = nomeFoto.replaceAll("[ ]", "_");
            getFoto().setNomeFoto(nomeFoto);
            Util.mensagemInformacao("Foto enviada com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao enviar foto: " + Util.getMensagemErro(e));
        }
    }

    public void downloadFoto(int index) {
        setFoto(objeto.getFotos().get(index));
        byte[] download = (byte[]) getFoto().getArquivo();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-Disposition", "attachment; filename=" + getFoto().getNomeFoto());
        response.setContentLength(download.length);
        try {
            response.setContentType("application/octet-stream");
            response.getOutputStream().write(download);
            response.getOutputStream().flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            Util.mensagemErro("Erro no download da foto: " + Util.getMensagemErro(e));
        }
    } 
        
    public void visualizarFoto(int index) {
        setFoto(objeto.getFotos().get(index));
    }

    public StreamedContent getImagemDinamica() {
        if (getFoto() != null) {
            return new DefaultStreamedContent(new ByteArrayInputStream(getFoto().getArquivo()), "");
        } else {
            return new DefaultStreamedContent();
        }
    }
    
    public String listar(){
            return "/privado/ordemservico/crudordemservico?faces-redirect=true";
    }

    public void novo(){
        
            objeto = new OrdemServico();  
            objeto.setFotos(new ArrayList());
            objeto.setItemServicos(new ArrayList());
            objeto.setItemProdutos(new ArrayList());
            objeto.setContasReceber(new ArrayList());
    }

    public void alterar(Object id){
            try {
                    objeto = getDao().getObjectById(id);            
            } catch (Exception e){
                    Util.mensagemErro("Erro ao recuperar objeto: " + 
                                    Util.getMensagemErro(e));
            } 
    }

    public void excluir(Object id){
            try {
                    objeto = getDao().getObjectById(id);
                    getDao().remover(objeto);
                    Util.mensagemInformacao("Objeto removido com sucesso!");
            } catch (Exception e){
                    Util.mensagemErro("Erro ao remover objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }

    public void salvar(){
            try {
                    if (objeto.getId() == null){
                            getDao().persist(objeto);
                    } else {
                            getDao().merge(objeto);
                    }
                    Util.mensagemInformacao("Objeto persistido com sucesso!");            
            } catch(Exception e){
                    Util.mensagemErro("Erro ao persistir objeto: " + 
                                    Util.getMensagemErro(e));
            }
    }
    

    public OrdemServico getObjeto() {
        return objeto;
    }

    public void setObjeto(OrdemServico objeto) {
        this.objeto = objeto;
    }

    public OrdemServicoDAO getDao() {
        return dao;
    }

    public void setDao(OrdemServicoDAO dao) {
        this.dao = dao;
    }

    public EquipamentoDAO getDaoEquipamento() {
        return daoEquipamento;
    }

    public void setDaoEquipamento(EquipamentoDAO daoEquipamento) {
        this.daoEquipamento = daoEquipamento;
    }

    public ItemServico getItemServico() {
        return itemServico;
    }

    public void setItemServico(ItemServico itemServico) {
        this.itemServico = itemServico;
    }

    public ServicoDAO getServicoDao() {
        return servicoDao;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }
    
    
}
