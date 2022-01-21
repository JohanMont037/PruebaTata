package PortalTata;

import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bf = CargueArchivos.Leertxt("src/test/resources/insumo.txt");
		String datoAleatorio = CargueArchivos.organizar(CargueArchivos.imprimirArchivo(bf));
		PortalPrueba test = new PortalPrueba();
		test.setup();
		test.llenarFormulario(datoAleatorio);
		
		try {
			test.cerrar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
