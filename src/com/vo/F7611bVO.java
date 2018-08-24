package com.vo;

public class F7611bVO {

	private String notaFiscal;
	private String tipoNF;
	private String serieNF;
	private String preNota;
	private String filial;
	private String pedido;
	private String tipoPedido;
	private String statusAtual;
	private String statusProximo;
	private String clienteJDE;
	private String cia;

	public F7611bVO() {
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public String getStatusAtual() {
		return statusAtual;
	}

	public void setStatusAtual(String statusAtual) {
		this.statusAtual = statusAtual;
	}

	public String getStatusProximo() {
		return statusProximo;
	}

	public void setStatusProximo(String statusProximo) {
		this.statusProximo = statusProximo;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getTipoNF() {
		return tipoNF;
	}

	public void setTipoNF(String tipoNF) {
		this.tipoNF = tipoNF;
	}

	public String getSerieNF() {
		return serieNF;
	}

	public void setSerieNF(String serieNF) {
		this.serieNF = serieNF;
	}

	public String getPreNota() {
		return preNota;
	}

	public void setPreNota(String preNota) {
		this.preNota = preNota;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public String getClienteJDE() {
		return clienteJDE;
	}

	public void setClienteJDE(String clienteJDE) {
		this.clienteJDE = clienteJDE;
	}

	public String getCia() {
		return cia;
	}

	public void setCia(String cia) {
		this.cia = cia;
	}

	@Override
	public String toString() {
		return "VO => [notaFiscal=" + notaFiscal + ", tipoNF=" + tipoNF + ", serieNF=" + serieNF + ", preNota="
				+ preNota + ", filial=" + filial + ", pedido=" + pedido + ", tipoPedido=" + tipoPedido
				+ ", statusAtual=" + statusAtual + ", statusProximo=" + statusProximo + ", clienteJDE=" + clienteJDE
				+ ", cia=" + cia + "]";
	}
}
