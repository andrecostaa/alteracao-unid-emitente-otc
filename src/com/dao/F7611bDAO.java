package com.dao;

import java.util.List;

import com.vo.F7611bVO;

public interface F7611bDAO {

	
	public List<F7611bVO> carregaListaF7611b(String pedidoPreNota, boolean pedidoPreenchido);
	
	public List<F7611bVO> carregaListaF7611b(String nf, String dataEmissao, String unidade);
	
	public List<F7611bVO> carregaListaF7611b(String nf, String dataEmissao, String unidade, String cliente);

	public boolean buscarDevolucaoPeloPedido(String pedido);
	
	
}
