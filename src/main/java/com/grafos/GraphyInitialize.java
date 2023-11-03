package com.grafos;

import java.util.Random;
import java.util.Scanner;

public class GraphyInitialize {

	public static void main(String[] args) {

		// TODO criar o cabeçalho da aplicação

		Scanner scan = new Scanner(System.in);

		System.out.println("Number of vertices:");
		int numVertices = scan.nextInt();
		System.out.println("Is it a directed graph? (y/n)");
		boolean isDirected = scan.next().equalsIgnoreCase("y");
		System.out.println("Is it a weighted graph? (y/n)");
		boolean isWeighted = scan.next().equalsIgnoreCase("y");

		GraphMatrix gm = new GraphMatrix( numVertices, isDirected, isWeighted );

		System.out.println(gm);

		System.out.println("Grafo Completo? " + gm.isComplete());
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
		
		// gm.rangeSearch(pontoInicio);
		
		
//		GraphMatrix gm2 = new GraphMatrix(4, 
//				new int[][] {
//			{0,1,1,1},
//			{1,0,1,1},
//			{1,1,0,1},
//			{1,1,1,0}
//			});
//		System.out.println("Grafo Completo? "+gm2.isGrafoCompleto());
		scan.close();
	}

}
