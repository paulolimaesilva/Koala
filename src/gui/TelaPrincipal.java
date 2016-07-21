package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import javax.swing.Action;

import java.awt.Color;

public class TelaPrincipal {

	private final Action cadastraClienteAction = new SwingAction();
	private final Action sair = new SwingAction_1();
	private final Action cadastraServicoAction = new SwingAction_2();
	private final Action NovaOSAction = new SwingAction_3();
	private ClientePanel cdCadastraCliente = new ClientePanel();
	private ServicoPanel cdCadastraServico = new ServicoPanel();
	private NovaOsPanel cdNovaOS = new NovaOsPanel();

	private JFrame frame;
	private CardLayout card;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
					window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {

		initialize();
	}

	public void initialize() {

		frame = new JFrame("Agência Koala");
		// ImageIcon icone = new ImageIcon("./src/icone.png");
		// frame.setIconImage(icone.getImage());
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		card = new CardLayout(0, 0);
		frame.getContentPane().setLayout(card);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_CadastrarCliente");

		panel.add(cdCadastraCliente);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel1, "name_CadastrarServico");

		panel1.add(cdCadastraServico);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		frame.getContentPane().add(panel2, "name_NovaOS");

		panel2.add(cdNovaOS);

		JMenuBar menuBar = new JMenuBar();

		frame.setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAction(sair);
		mnArquivo.add(mntmSair);

		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		menuBar.add(mnCliente);

		JMenuItem mntmCadastrarNovoCliente = new JMenuItem("Cadastrar cliente");
		mntmCadastrarNovoCliente.setAction(cadastraClienteAction);
		mntmCadastrarNovoCliente.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		mnCliente.add(mntmCadastrarNovoCliente);

		JMenu mnServicos = new JMenu("Servi\u00E7os");
		mnServicos.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		menuBar.add(mnServicos);

		JMenuItem mntmCadastroDeServico = new JMenuItem("Cadastrar servi\u00E7o");
		mntmCadastroDeServico.setAction(cadastraServicoAction);
		mntmCadastroDeServico.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		mnServicos.add(mntmCadastroDeServico);

		JMenu mnOrdemDeServio = new JMenu("Ordem de Servi\u00E7o");
		mnOrdemDeServio.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		menuBar.add(mnOrdemDeServio);

		JMenuItem mntmNovaOrdemDe = new JMenuItem("Nova Ordem de Servi\u00E7o");
		mntmNovaOrdemDe.setAction(NovaOSAction);
		mntmNovaOrdemDe.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		mnOrdemDeServio.add(mntmNovaOrdemDe);

		JMenuItem mntmConsultaOrdemDe = new JMenuItem("Consulta Ordem de Servi\u00E7o");
		mntmConsultaOrdemDe.setFont(new Font("Segoe UI Light", Font.PLAIN, 12));
		mnOrdemDeServio.add(mntmConsultaOrdemDe);

		JMenu mnFinanceiro = new JMenu("Financeiro");
		mnFinanceiro.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		menuBar.add(mnFinanceiro);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setFont(new Font("Segoe UI Light", Font.PLAIN, 15));
		menuBar.add(mnSobre);

	}

	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction() {
			putValue(NAME, "Cadastro de Cliente");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_CadastrarCliente");
		}
	}

	private class SwingAction_1 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_1() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_2() {
			putValue(NAME, "Cadastro de Serviço");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_CadastrarServico");
		}
	}

	private class SwingAction_3 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SwingAction_3() {
			putValue(NAME, "Nova Ordem de Serviço");
			putValue(SHORT_DESCRIPTION, "");
		}

		public void actionPerformed(ActionEvent e) {
			card.show(frame.getContentPane(), "name_NovaOS");
		}
	}

}
