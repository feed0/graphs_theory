package com.grafos;

public @interface Archive {
    
    // public int rangeSearch(int ponto) {
	// // TODO translate to english
	// int numComponents = 1;
	// List<Integer> lista = new ArrayList<>();
	// List<Integer> listaComponenteAtual = Arrays.asList(ponto);
	// while(true){
	// for (int i = 0; i < numVertices; i++) {
	// if (lista.size() + listaComponenteAtual.size() == numVertices) {
	// break;
	// }
	// if (ponto != i && !listaComponenteAtual.contains(i) && !lista.contains(i) &&
	// matrix[ponto][i] != 0) {
	// listaComponenteAtual.add(i);
	// //lista.add(i);
	// ponto = i;
	// i = -1;
	// }
	// }
	// if(lista.size() + listaComponenteAtual.size() != numVertices){
	// boolean newComponent = false;
	// for(int i = listaComponenteAtual.size()-2; i>=0; i--){
	// for(int i2 = 0; i2<numVertices; i2++){
	// if (i != i2 && !listaComponenteAtual.contains(i2) && !lista.contains(i2) &&
	// matrix[ponto][i] != 0) {
	// lista.addAll(listaComponenteAtual);
	// listaComponenteAtual = Arrays.asList(i2);
	// ponto = i2;
	// newComponent = true;
	// numComponents++;
	// break;
	// }
	// }
	// if(newComponent){
	// break;
	// }
	// }
	// }
	// }
	// return numComponents;
	// }

}
