package action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import dao.KoalaDAO;
import gui.ClientePanel;
import pojo.Cliente;

public class CadastrarClienteAction extends AbstractAction {


	private static final long serialVersionUID = 1L;


	private ClientePanel panel;

	public CadastrarClienteAction(ClientePanel panel) {
		super("Cadastrar");
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try{
			Cliente c = panel.getClienteInsert();
			JOptionPane.showMessageDialog(null, c.getNomeCliente()+"\n"+c.getTelefoneCliente()+"\n"+c.getEmailCliente());
			KoalaDAO dao = new KoalaDAO();
			dao.insertCliente(c);
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			panel.limpar();
			panel.preencherTabela(panel.getModelo());
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
		}
	}
}