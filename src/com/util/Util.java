package com.util;



public class Util {

	public static final String CAMINHO_SQLS = "./";
	public static final String NOME_ARQUIVO = "_gerados.sql";
	
	public static String QUEBRA_LINHA = System.getProperty("line.separator");

	public static String queryConsultaDadosNFs(String valores, boolean pedidoPreenchido) {
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT distinct fdbnnf, fdn001, fddct, fdbser, fdlttr, fdnxtr, fdan8, fdmcu, fdkcoo, fddoco, fdpdct ");
		sb.append("FROM proddta.f7611b ");

		if (pedidoPreenchido) {
			sb.append("WHERE fddoco IN (");
		} else {
			sb.append("WHERE fdn001 IN (");
		}
		sb.append(valores);
		sb.append(")");

		return sb.toString();
	}

	public static String queryDevolucao(String pedido) {

		StringBuilder sb = new StringBuilder();

		sb.append("select count(*) as linhas from proddta.fbn42010 ");
		sb.append("where dvoorn in (");
		sb.append(pedido);
		sb.append(")");
		
		return sb.toString();
	}

	public static String querySelect_UpdateF42119(String pedido, String tipoPedido, String filialNova, String chaveSN,
			String numeroChamadoSN) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SDMCU,SDEMCU,SDUSER,SDPID,SDJOBN,SDUPMJ");
		sb.append(" FROM PRODDTA.F42119");
		sb.append(" WHERE SDDOCO=");
		sb.append(pedido);
		sb.append(" AND SDDCTO='");
		sb.append(tipoPedido);
		sb.append("';");

		sb.append(QUEBRA_LINHA);

		sb.append("UPDATE PRODDTA.F42119");
		sb.append(" SET SDMCU = '      " + filialNova + "',");
		sb.append(" SDEMCU = '      " + filialNova + "',");
		sb.append(" SDUSER='" + chaveSN + "',");
		sb.append(" SDPID='SQL',");
		sb.append(" SDJOBN='" + numeroChamadoSN + "',");
		sb.append("SDUPMJ=substr(to_char(SYSDATE,'CC'),2,1)||to_char(SYSDATE,'YY')||to_char(SYSDATE,'DDD')");
		sb.append(" WHERE SDDOCO=");
		sb.append(pedido);
		sb.append(" AND SDDCTO='");
		sb.append(tipoPedido);
		sb.append("';");

		sb.append(QUEBRA_LINHA);
		sb.append(QUEBRA_LINHA);

		return sb.toString();
	}

	public static String querySelect_UpdateF42019(String pedido, String tipoPedido, String filialNova, String chaveSN,
			String numeroChamadoSN) {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT SHMCU,SHUSER,SHPID,SHJOBN,SHUPMJ");
		sb.append(" FROM PRODDTA.F42019");
		sb.append(" WHERE SHDOCO=");
		sb.append(pedido);
		sb.append(" AND SHDCTO='");
		sb.append(tipoPedido);
		sb.append("';");

		sb.append(QUEBRA_LINHA);

		sb.append("UPDATE PRODDTA.F42019");
		sb.append(" SET SHMCU='      " + filialNova + "',");
		sb.append(" SHUSER='" + chaveSN + "',");
		sb.append(" SHPID='SQL',");
		sb.append(" SHJOBN='" + numeroChamadoSN + "',");
		sb.append(" SHUPMJ=substr(to_char(SYSDATE,'CC'),2,1)||to_char(SYSDATE,'YY')||to_char(SYSDATE,'DDD')");
		sb.append(" WHERE SHDOCO='");
		sb.append(tipoPedido);
		sb.append("';");

		sb.append(QUEBRA_LINHA);
		sb.append(QUEBRA_LINHA);

		return sb.toString();
	}

	public static String querySelect_UpdateF7611B(String preNota, String notaFiscal, String filial, String serieNF,
			String tipoNF, String novaFilial, String chaveSN, String numeroChamadoSN) {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT FDMCU,FDUSER,FDPID,FDJOBN,FDUPMJ");
		sb.append(" FROM PRODDTA.F7611B");
		sb.append(" WHERE FDN001=" + preNota);
		sb.append(" AND FDBNNF=" + notaFiscal);
		sb.append(" AND FDMCU='" + filial + "'");
		sb.append(" AND FDBSER='" + serieNF + "'");
		sb.append(" AND FDDCT='" + tipoNF + "';");

		sb.append(QUEBRA_LINHA);

		sb.append("UPDATE PRODDTA.F7611B");
		sb.append(" SET FDMCU = '      " + novaFilial + "',");
		sb.append(" FDUSER='" + chaveSN + "',");
		sb.append(" FDPID='SQL',");
		sb.append(" FDJOBN='" + numeroChamadoSN + "',");
		sb.append(" FDUPMJ=substr(to_char(SYSDATE,'CC'),2,1)||to_char(SYSDATE,'YY')||to_char(SYSDATE,'DDD')");
		sb.append(" WHERE FDN001=" + preNota);
		sb.append(" AND FDBNNF=" + notaFiscal);
		sb.append(" AND FDMCU='" + filial + "'");
		sb.append(" AND FDBSER='" + serieNF + "'");
		sb.append(" AND FDDCT='" + tipoNF + "';");

		sb.append(QUEBRA_LINHA);
		sb.append(QUEBRA_LINHA);

		return sb.toString();
	}

	public static String querySelect_UpdateF7601B(String preNota, String notaFiscal, String filial, String serieNF,
			String tipoNF, String novaFilial, String chaveSN, String numeroChamadoSN) {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT FHMCU,FHUSER,FHPID,FHJOBN,FHUPMJ");
		sb.append(" FROM PRODDTA.F7601B");
		sb.append(" WHERE FHN001=" + preNota);
		sb.append(" AND FHBNNF=" + notaFiscal);
		sb.append(" AND FHMCU='" + filial + "'");
		sb.append(" AND FHBSER='" + serieNF + "'");
		sb.append(" AND FHDCT='" + tipoNF + "';");

		sb.append(QUEBRA_LINHA);

		sb.append("UPDATE PRODDTA.F7601B");
		sb.append(" SET FHMCU='      " + novaFilial + "',");
		sb.append(" FHUSER='" + chaveSN + "',");
		sb.append(" FHPID='SQL',");
		sb.append(" FHJOBN='" + numeroChamadoSN + "',");
		sb.append(" FHUPMJ=substr(to_char(SYSDATE,'CC'),2,1)||to_char(SYSDATE,'YY')||to_char(SYSDATE,'DDD')");
		sb.append(" WHERE FHN001=" + preNota);
		sb.append(" AND FHBNNF=" + notaFiscal);
		sb.append(" AND FHMCU='" + filial + "'");
		sb.append(" AND FHBSER='" + serieNF + "'");
		sb.append(" AND FHDCT='" + tipoNF + "';");

		sb.append(QUEBRA_LINHA);
		sb.append(QUEBRA_LINHA);

		return sb.toString();
	}

}
