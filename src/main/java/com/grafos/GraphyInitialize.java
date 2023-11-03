package com.grafos;

import java.util.Random;
import java.util.Scanner;

public class GraphyInitialize {

	public static void main(String[] args) {

		// TODO criar o cabeçalho da aplicação

		Scanner scan = new Scanner(System.in);

		System.out.println("Quantos vértices terá o grafo a ser gerado?");
		GraphMatrix gm = new GraphMatrix(scan.nextInt());
		System.out
				.print("Qual o tipo da matriz?\n0: Simples \n1: Dígrafo \n2: Aleatório com arestas paralelas\n tipo: ");
		gm.setTipoMatriz(scan.nextInt());
		gm.randomize();
		System.out.println(gm);

		System.out.println("Grafo Completo? " + gm.isGrafoCompleto());
		int pontoInicio = -1;
		while (true) {
			System.out.println("Na busca em profundidade, qual o ponto de início? (0 - " + (gm.getNumVertices() - 1)
					+ ".\nDigite \"-1\" para um aleatório)");
			pontoInicio = scan.nextInt();
			if (pontoInicio >= -1 && pontoInicio < gm.getNumVertices()) {
				if (pontoInicio == -1) {
					pontoInicio = new Random().nextInt(0, gm.getNumVertices());
				}
				break;
			}
			System.out.println("Valor inválido!");
		}
		
		gm.rangeSearch(pontoInicio);
		
		
//		GraphMatrix gm2 = new GraphMatrix(4, 
//				new int[][] {
//			{0,1,1,1},
//			{1,0,1,1},
//			{1,1,0,1},
//			{1,1,1,0}
//			});
//		System.out.println("Grafo Completo? "+gm2.isGrafoCompleto());

	}

}
