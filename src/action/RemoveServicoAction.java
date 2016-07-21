package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import dao.KoalaDAO;
import gui.ServicoPanel;
import pojo.Servico;

public class RemoveServicoAction extends AbstractAction{
	
	private static final long serialVersionUID = 1L;


	private ServicoPanel panel;

	public RemoveServicoAction(ServicoPanel panel) {
		super("Excluir");
		this.panel = panel;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			Servico s = panel.getServicoFind();
			KoalaDAO dao = new KoalaDAO();
			dao.deleteServico(s.getIdServico());
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			panel.limpar();
			panel.preencherTabela(panel.getModelo());	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
	}

}
