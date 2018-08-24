package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.connection.DBConnection;
import com.dao.F7611bDAO;
import com.util.Util;
import com.vo.F7611bVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class F7611bDAOImpl implements F7611bDAO {

	private List<F7611bVO> listaDadosNFs;
	private F7611bVO vo;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public List<F7611bVO> carregaListaF7611b(String pedidoPreNota, boolean pedidoPreenchido) {
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(Util.queryConsultaDadosNFs(pedidoPreNota, pedidoPreenchido));
			rs = pstmt.executeQuery();
			listaDadosNFs = new ArrayList<F7611bVO>();
			// fdbnnf,fdn001,fddct,fdbser,fdlttr,fdnxtr,fdan8,fdmcu,fdkcoo,fddoco,fdpdct
			while (rs.next()) {
				vo = new F7611bVO();
				vo.setNotaFiscal(rs.getString("fdbnnf"));
				vo.setPreNota(rs.getString("fdn001"));
				vo.setTipoNF(rs.getString("fddct"));
				vo.setSerieNF(rs.getString("fdbser"));
				vo.setStatusAtual(rs.getString("fdlttr"));
				vo.setStatusProximo(rs.getString("fdnxtr"));
				vo.setClienteJDE(rs.getString("fdan8"));
				vo.setFilial(rs.getString("fdmcu"));
				vo.setCia(rs.getString("fdkcoo"));
				vo.setPedido(rs.getString("fddoco"));
				vo.setTipoPedido(rs.getString("fdpdct"));

				System.err.println(vo.toString());

				listaDadosNFs.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listaDadosNFs;
	}

	@Override
	public boolean buscarDevolucaoPeloPedido(String pedido) {
		boolean temDevolucao = false;
		try {
			con = DBConnection.getConnection();
			pstmt = con.prepareStatement(Util.queryDevolucao(pedido));
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int linhas = rs.getInt("linhas");
				if(linhas > 0) {
					temDevolucao = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return temDevolucao;
	}

	@Override
	public List<F7611bVO> carregaListaF7611b(String nf, String dataEmissao, String unidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<F7611bVO> carregaListaF7611b(String nf, String dataEmissao, String unidade, String cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
