package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import dao.KoalaDAO;
import gui.ClientePanel;
import pojo.Cliente;

public class RemoveClienteAction extends AbstractAction{
	
	private static final long serialVersionUID = 1L;


	private ClientePanel panel;

	public RemoveClienteAction(ClientePanel panel) {
		super("Excluir");
		this.panel = panel;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			Cliente c = panel.getClienteFind();
			KoalaDAO dao = new KoalaDAO();
			JOptionPane.showMessageDialog(null, c.getIdCliente()+"\n"+c.getNomeCliente()+"\n"+c.getTelefoneCliente()+"\n"+c.getEmailCliente());
			dao.deleteCliente(c.getIdCliente());
			JOptionPane.showMessageDialog(null, "Removido com sucesso!");
			panel.limpar();
			panel.preencherTabela(panel.getModelo());	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
	}

}
