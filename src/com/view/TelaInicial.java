package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.controller.F7611bController;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;

public class TelaInicial {

	private JFrame frmTicketAlterarUnidade;
	private JTextField txtPedido;
	private JTextField txtPreNota;
	private JTextField txtFilial;
	private JTextField txtNotasFiscais;
	private JTextField txtClientes;

	private F7611bController controller;
	private JTextField txtNovaFilial;
	private JTextField txtChaveSN;
	private JTextField txtNumeroChamadoSN;
	private JProgressBar progressBar;
	private JLabel lblProgressbar;
	static final int MY_MINIMUM = 0;
	static final int MY_MAXIMUM = 100;

	boolean terminou = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frmTicketAlterarUnidade.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicketAlterarUnidade = new JFrame();
		frmTicketAlterarUnidade.setResizable(false);
		frmTicketAlterarUnidade.setTitle("Ticket Alterar Unidade Emitente - OTC");
		frmTicketAlterarUnidade.setBounds(100, 100, 450, 321);
		frmTicketAlterarUnidade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicketAlterarUnidade.getContentPane().setLayout(null);

		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setBounds(10, 11, 46, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblPedido);

		txtPedido = new JTextField();
		txtPedido.setText("27857072,27521674,27436826");
		txtPedido.setBounds(61, 8, 371, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtPedido);
		txtPedido.setColumns(10);

		JLabel lblPrnota = new JLabel("Pre-NF");
		lblPrnota.setBounds(10, 39, 46, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblPrnota);

		txtPreNota = new JTextField();
		txtPreNota.setBounds(61, 36, 371, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtPreNota);
		txtPreNota.setColumns(10);

		JLabel lblFilial = new JLabel("Filial:");
		lblFilial.setBounds(10, 70, 46, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblFilial);

		txtFilial = new JTextField();
		txtFilial.setBounds(61, 67, 86, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtFilial);
		txtFilial.setColumns(10);

		JLabel lblNfes = new JLabel("NFe's:");
		lblNfes.setBounds(10, 101, 46, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblNfes);

		txtNotasFiscais = new JTextField();
		txtNotasFiscais.setBounds(61, 98, 371, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtNotasFiscais);
		txtNotasFiscais.setColumns(10);

		JButton btnGerarSqls = new JButton("Gerar SQL's");
		btnGerarSqls.setEnabled(false);
		
		btnGerarSqls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						controller = new F7611bController();
						// inicio if
						if (!txtPedido.getText().isEmpty() || !txtPreNota.getText().isEmpty()) {
							controller.buscarDadosPorPedidoPreNF(txtPedido.getText().trim(),
									txtPreNota.getText().trim(), txtNovaFilial.getText().trim().toUpperCase(),
									txtChaveSN.getText().trim().toUpperCase(),
									txtNumeroChamadoSN.getText().trim().toUpperCase());

							boolean temDevolucao = controller.verificarSeTemDevolucao(txtPedido.getText().trim());
							terminou = true;
							if (temDevolucao) {
								JOptionPane.showMessageDialog(null,
										"Hey, há pedidos que contém DEVOLUÇÃO!! \\n\\rEm fase de teste.");
							} else {
								JOptionPane.showMessageDialog(null,
										"Pode relaxar que NÃO tem DEVOLUÇÃO! =D \n\rEm fase de teste.");
							}
						}// fim if
					}
		});
		btnGerarSqls.setBounds(301, 249, 125, 36);
		frmTicketAlterarUnidade.getContentPane().add(btnGerarSqls);

		JLabel lblClienteJde = new JLabel("Cliente:");
		lblClienteJde.setBounds(10, 132, 46, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblClienteJde);

		txtClientes = new JTextField();
		txtClientes.setBounds(61, 129, 371, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtClientes);
		txtClientes.setColumns(10);

		JLabel lblFavorSepararPor = new JLabel(
				"Favor separar por virgulas se tiver v\u00E1rios pedidos, pre notas e etc.");
		lblFavorSepararPor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFavorSepararPor.setForeground(Color.RED);
		lblFavorSepararPor.setBounds(10, 157, 416, 23);
		frmTicketAlterarUnidade.getContentPane().add(lblFavorSepararPor);

		JCheckBox checkConfirmaOBS = new JCheckBox("");
		checkConfirmaOBS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkConfirmaOBS.isSelected() && !txtNumeroChamadoSN.getText().isEmpty()
						&& !txtChaveSN.getText().isEmpty() && !txtNovaFilial.getText().isEmpty()) {
					btnGerarSqls.setEnabled(true);
				} else {
					btnGerarSqls.setEnabled(false);
				}
			}
		});
		checkConfirmaOBS.setBounds(405, 156, 21, 23);
		frmTicketAlterarUnidade.getContentPane().add(checkConfirmaOBS);

		JLabel lblNovaFilial = new JLabel("Nova Filial:");
		lblNovaFilial.setBounds(164, 70, 70, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblNovaFilial);

		txtNovaFilial = new JTextField();
		txtNovaFilial.setText("RBA321");
		txtNovaFilial.setBounds(228, 67, 86, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtNovaFilial);
		txtNovaFilial.setColumns(10);

		JLabel lblSuaChave = new JLabel("Sua Chave:");
		lblSuaChave.setBounds(10, 197, 70, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblSuaChave);

		txtChaveSN = new JTextField();
		txtChaveSN.setText("BRATYNG1");
		txtChaveSN.setBounds(76, 194, 86, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtChaveSN);
		txtChaveSN.setColumns(10);

		JLabel lblChamado = new JLabel("Chamado:");
		lblChamado.setBounds(10, 238, 70, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblChamado);

		txtNumeroChamadoSN = new JTextField();
		txtNumeroChamadoSN.setText("INCxxxx");
		txtNumeroChamadoSN.setBounds(76, 235, 86, 20);
		frmTicketAlterarUnidade.getContentPane().add(txtNumeroChamadoSN);
		txtNumeroChamadoSN.setColumns(10);

		JLabel lblNewLabel = new JLabel("Copyright 2018, Andr\u00E9 Lalves, All rights reserved.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 271, 281, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setBounds(282, 191, 150, 16);
		frmTicketAlterarUnidade.getContentPane().add(progressBar);

		lblProgressbar = new JLabel("");
		lblProgressbar.setBounds(282, 212, 97, 14);
		frmTicketAlterarUnidade.getContentPane().add(lblProgressbar);
	}
}
