package PortalTata;

import java.io.*;
import java.util.ArrayList;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class CargueArchivos {
	
	public static BufferedReader  Leertxt (String direccion) {
		
		BufferedReader  bf = null;
		
		try {
			File file = new File (direccion);
			bf = new BufferedReader(new FileReader(file));
		}catch(Exception e ){
			System.out.println(e);
		}
		return bf;
	}
	
	public static ArrayList<String> imprimirArchivo(BufferedReader bf) {
		String text;
		int i = 0;
		System.out.println("1. El archivo contiene los siguientes datos: ");
		ArrayList<String> parts = new ArrayList<String>();
		try {
			while((text = bf.readLine()) != null) {
				i++;
				System.out.println(text);
				parts.add(text);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("2. El n\u00famero de filas del archivos es " + i);
		System.out.println();
		
		return parts;
		
	}
	
	public static String organizar(ArrayList<String> parts) {
		int num = 0;
		System.out.println("Datos de los asociados:" );
		int random = (int) (Math.random() * parts.size() - 1);
		for(String part: parts) {
			num = num + 1;
			String[] text = part.split("-");
			System.out.println();
			System.out.println("Asociado " + num);
			for(int j = 0; j < text.length; j++) {
				switch (j) {
				case 0:
					System.out.println("Primer nombre: " + text[j] + ".");
					break;
				case 1:
					System.out.println("Segundo nombre: " + text[j] + ".");
					break;
				case 2:
					System.out.println("Primer apellido: " + text[j] + ".");
					break;
				case 3:
					System.out.println("Segundo apellido: " + text[j] + ".");
					break;
				case 4:
					System.out.println("Tel\u00e9fono: " + text[j] + ".");
					break;
				case 5:
					String[] date = text[j].split("/");
					System.out.println("Fecha de ingreso:");
					System.out.println("D\u00eda: " + date[0] + " Mes: " + date[1] + " A\u00f1o: " + date[2]);
					break;
				default:
					break;
				}

					
			}
		}
		return parts.get(random);
	}
	

}
