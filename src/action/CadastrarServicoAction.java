package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import dao.KoalaDAO;
import gui.ServicoPanel;
import pojo.Servico;

public class CadastrarServicoAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	
	
	private ServicoPanel panel;
	
	
	public CadastrarServicoAction(ServicoPanel panel) {
		super("Cadastrar");
		this.panel = panel;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			Servico s = panel.getServicoInsert();
			KoalaDAO dao = new KoalaDAO();
			dao.insertServico(s);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			panel.limpar();
			panel.preencherTabela(panel.getModelo());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
	}
}