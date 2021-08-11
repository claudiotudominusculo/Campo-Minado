package br.com.jok3r.cm;

import br.com.jok3r.cm.modelo.Tabuleiro;
import br.com.jok3r.cm.visao.TabuleiroConsole;

public class Aplicação {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);
	}
}
		
		
		
		
