package com.controller;

import java.util.ArrayList;
import java.util.List;

import com.dao.F7611bDAO;
import com.dao.impl.F7611bDAOImpl;
import com.vo.F7611bVO;

public class F7611bController {
	
	private List<F7611bVO> listaDadosNFs = new ArrayList<F7611bVO>();
	private F7611bDAO dao;

	private boolean pedidoPreenchido = false;
	
	public F7611bController() {
		if (dao == null) {
			dao = new F7611bDAOImpl();
		}
	}

	@SuppressWarnings("static-access")
	public void buscarDadosPorPedidoPreNF(String pedido, String prenota, String novaFilial, String chaveSN, String numeroChamadoSN) {
		if (pedido.isEmpty()) {
			buscarDadosPelaPreNota(prenota);
		} else {
			pedidoPreenchido = true;
			
			listaDadosNFs = buscarDadosPeloPedido(pedido);
			new ManipulacaoArquivos().gravarArquivo(listaDadosNFs, novaFilial, chaveSN, numeroChamadoSN);
		}
	}
		
	public boolean verificarSeTemDevolucao(String pedido) {
		return dao.buscarDevolucaoPeloPedido(pedido);
	}

	private List<F7611bVO> buscarDadosPeloPedido(String pedido) {
		return dao.carregaListaF7611b(pedido, pedidoPreenchido);
	}

	private List<F7611bVO>  buscarDadosPelaPreNota(String prenota) {
		return dao.carregaListaF7611b(prenota, pedidoPreenchido);
	}

}
