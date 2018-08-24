package com.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.util.Util;
import com.vo.F7611bVO;

public class ManipulacaoArquivos {

	// grava um arquivo texto

	public static void gravarArquivo(List<F7611bVO> listasDadosNfs, String novaFilial, String chaveSN, String numeroChamadoSN) {
		try {
			File file = new File(Util.CAMINHO_SQLS + numeroChamadoSN + Util.NOME_ARQUIVO);
			if(file.exists()) {
				file.delete();
				System.out.println("Arquivo existente... deletado!");
			}
			BufferedWriter arquivo = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
			
			if (escreverQueriesF42119(arquivo, listasDadosNfs, novaFilial, chaveSN, numeroChamadoSN)) {
				System.out.println("escreveu tudo certo! escreverQueriesF42119");
			} else {
				System.err.println("deu merda na escrever queries!");
			}
			
			if (escreverQueriesF42019(arquivo, listasDadosNfs, novaFilial, chaveSN, numeroChamadoSN)) {
				System.out.println("escreveu tudo certo! escreverQueriesF42019 ");
			} else {
				System.err.println("deu merda na escrever queries!");
			}
			
			if (escreverQueriesF7611B(arquivo, listasDadosNfs, novaFilial, chaveSN, numeroChamadoSN)) {
				System.out.println("escreveu tudo certo! escreverQueriesF7611B");
			} else {
				System.err.println("deu merda na escrever queries!");
			}
			
			if (escreverQueriesF7601B(arquivo, listasDadosNfs, novaFilial, chaveSN, numeroChamadoSN)) {
				System.out.println("escreveu tudo certo! escreverQueriesF7601B");
			} else {
				System.err.println("deu merda na escrever queries!");
			}
			
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean escreverQueriesF42119(BufferedWriter arquivo, List<F7611bVO> listasDadosNfs, String novaFilial, String chaveSN, String numeroChamadoSN) {
		try {
			arquivo.write("--#################### INICIO TABELA F42119 ####################" + "\n\r");
			for (F7611bVO obj : listasDadosNfs) {
				arquivo.write(Util.querySelect_UpdateF42119(obj.getPedido(), obj.getTipoPedido(), novaFilial, chaveSN, numeroChamadoSN));
			}
			arquivo.write("--#################### FIM TABELA F42119 ####################" + "\n\r");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private static boolean escreverQueriesF42019(BufferedWriter arquivo, List<F7611bVO> listasDadosNfs, String novaFilial, String chaveSN, String numeroChamadoSN) {
		try {
			arquivo.write("--#################### INICIO TABELA F42019 ####################" + "\n\r");
			for (F7611bVO obj : listasDadosNfs) {
				arquivo.write(Util.querySelect_UpdateF42019(obj.getPedido(), obj.getTipoPedido(), novaFilial, chaveSN, numeroChamadoSN));
			}
			arquivo.write("--#################### FIM TABELA F42019 ####################" + "\n\r");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean escreverQueriesF7611B(BufferedWriter arquivo, List<F7611bVO> listasDadosNfs, String novaFilial, String chaveSN, String numeroChamadoSN) {
		try {
			arquivo.write("--#################### INICIO TABELA F7611B ####################" + "\n\r");
			for (F7611bVO obj : listasDadosNfs) {
				arquivo.write(Util.querySelect_UpdateF7611B(obj.getPreNota(), obj.getNotaFiscal(), obj.getFilial(), obj.getSerieNF(),obj.getTipoNF(), novaFilial, chaveSN, numeroChamadoSN));
			}
			arquivo.write("--#################### FIM TABELA F7611B ####################" + "\n\r");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean escreverQueriesF7601B(BufferedWriter arquivo, List<F7611bVO> listasDadosNfs, String novaFilial, String chaveSN, String numeroChamadoSN) {
		try {
			arquivo.write("--#################### INICIO TABELA F7601B ####################" + "\n\r");
			for (F7611bVO obj : listasDadosNfs) {
				arquivo.write(Util.querySelect_UpdateF7601B(obj.getPreNota(), obj.getNotaFiscal(), obj.getFilial(), obj.getSerieNF(),obj.getTipoNF(), novaFilial, chaveSN, numeroChamadoSN));
			}
			arquivo.write("--#################### FIM TABELA F7601B ####################" + "\n\r");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
