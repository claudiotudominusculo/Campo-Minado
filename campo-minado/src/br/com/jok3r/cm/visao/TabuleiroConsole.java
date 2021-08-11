package br.com.jok3r.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.jok3r.cm.excecao.ExplosaoException;
import br.com.jok3r.cm.excecao.SairException;
import br.com.jok3r.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
private Tabuleiro tab2;
private Scanner entrada = new Scanner (System.in);


public TabuleiroConsole(Tabuleiro tab2) {
	this.tab2 = tab2;
	
	executarJogo();
	
}
	private void executarJogo() {
		try {
			boolean continuar = true;
			while(continuar) {
			cicloDoJogo();
				System.out.println("Outra Partida?(S/n) ");
				String resposta = entrada.nextLine();
				
				if ("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tab2.reinicia();
				}
			}
		}catch(SairException e) {
			System.out.println("Tchau!!");
		}finally {
			entrada.close();
			
		}
	
	}
	private void cicloDoJogo() {
		try {
			
			while (!tab2.objetivoAlcancado()) {
				System.out.println(tab2.toString());
				String digitado = capturarValorDigitado("Digite (Linha, Coluna): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				.map(e -> Integer.parseInt(e.trim())).iterator();
				digitado = capturarValorDigitado("[1] Abrir ou [2](Des)marcar");
				if("1".equals(digitado)) {
					tab2.abrir(xy.next(), xy.next());
				}else if ("2".equals(digitado)) {
					tab2.alternarMarcacao(xy.next(), xy.next());
				}
			}
			System.out.println(tab2);
			System.out.println("Voce ganhou");
		}catch(ExplosaoException e) {
			System.out.println(tab2);
			System.out.println("Voce perdeu");
		}
		
	}

private String capturarValorDigitado(String texto) {
	System.out.println(texto);
	String digitado = entrada.nextLine();
	if("sair".equalsIgnoreCase(digitado)) {
		throw new SairException();
	}return digitado;
}

}
