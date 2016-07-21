package gui;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import pojo.Cliente;
import pojo.Servico;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.KoalaDAO;

import javax.swing.JButton;

public class NovaOsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabelaServicos;
	private JComboBox<Object> comboBoxServico = new JComboBox<Object>();
	private JComboBox<Object> comboBoxCliente = new JComboBox<Object>();
	private KoalaDAO dao = new KoalaDAO();
	private DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Create the panel.
	 */
	public NovaOsPanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][][][][][][][]",
				"[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));

		JLabel lblNovaOrdemDe = new JLabel("Nova Ordem de Servi\u00E7o");
		lblNovaOrdemDe.setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
		add(lblNovaOrdemDe, "cell 0 0 8 1");

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(lblCliente, "cell 0 3");

		comboBoxCliente.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		add(comboBoxCliente, "cell 0 4 5 1,growx");
		alimentaComboBoxCliente();

		JLabel lblServio = new JLabel("Servi\u00E7o");
		lblServio.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(lblServio, "cell 0 5");

		comboBoxServico.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		add(comboBoxServico, "cell 0 6 5 1,growx");
		alimentaComboBoxServico();

		JScrollBar scrollBar = new JScrollBar();
		add(scrollBar, "flowx,cell 0 8 5 8");

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(btnSalvar, "flowx,cell 0 17");

		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, "cell 19 33");

		tabelaServicos = new JTable();
		tabelaServicos.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		add(tabelaServicos, "cell 0 11");

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		add(btnLimpar, "cell 0 17");
		
		criaTabela();
	}

	public void alimentaComboBoxCliente() {
		for (Cliente c : dao.getClientesOrderNome()) {
			comboBoxCliente.addItem(c.getNomeCliente());
		}
	}

	public void alimentaComboBoxServico() {
		for (Servico s : dao.getServicosOrderNome()) {
			comboBoxServico.addItem(s.getNomeServico());
		}
	}

	private void criaTabela() {
		tabelaServicos = new JTable(getModelo());
		tabelaServicos.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		getModelo().addColumn("Servico");
		getModelo().addColumn("Valor");
		tabelaServicos.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabelaServicos.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabelaServicos.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabelaServicos.getColumnModel().getColumn(1).setPreferredWidth(120);
	}

	public void preencherTabela(DefaultTableModel modelo) {

		modelo.setNumRows(0);
		KoalaDAO dao = new KoalaDAO();
		for (Cliente c : dao.getClientes()) {
			modelo.addRow(
					new Object[] { c.getIdCliente(), c.getNomeCliente(), c.getTelefoneCliente(), c.getEmailCliente() });
		}
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}
}
