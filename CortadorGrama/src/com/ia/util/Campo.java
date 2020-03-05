package com.ia.util;

public class Campo {

	public class Situacao {
		public char[][] campo;
		public Cortador.Posicao posicaoCortador;

		public String toString() {
			StringBuffer string = new StringBuffer();

			for (int i = 0; i < this.campo.length; i++) {
				for (int j = 0; j < this.campo[0].length; j++) {
					string.append(this.campo[i][j]);
					if (i == posicaoCortador.x && j == posicaoCortador.y)
						string.append(Campo.cortador);
					string.append("\t");
				}

				string.append("\n");
			}

			return string.toString();
		}
	}

	public final static char formigueiro = 'f';
	public final static char gramaAlta = 'G';
	public final static char gramaBaixa = 'g';
	public final static char cortador = 'C';

	// TODO alterar para private e "getX()" e "getY()"
	public final int tamanhoX;
	public final int tamanhoY;
	private char[][] matriz;

	public Campo(int x, int y) {
		this.matriz = new char[x][y];
		this.tamanhoX = x;
		this.tamanhoY = y;

		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++)
				this.matriz[i][j] = Campo.gramaAlta;
	}

	public char[][] getCloneMatriz() {
		char[][] clone = new char[this.tamanhoX][this.tamanhoY];

		for (int i = 0; i < this.tamanhoX; i++)
			for (int j = 0; j < this.tamanhoY; j++)
				clone[i][j] = this.matriz[i][j];

		return clone;
	}

	public void setPosicao(int posX, int posY, char objeto) {
		this.matriz[posX][posY] = objeto;
	}

	public Situacao getSituaçãoAtual() {
		Situacao situação = new Situacao();

		situação.posicaoCortador = Controle.getInstancia().getCortador().getPosicao();
		situação.campo = this.getCloneMatriz();

		return situação;
	}
}
