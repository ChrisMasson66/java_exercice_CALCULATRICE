package com.main;



import java.io.InputStream;



public class Main {
	
	public static void main(String[] args) {
		
	
		//init du stream pour ouvrir le fichier input.txt et faire les calculs
        Streamer strm = new Streamer();       
        InputStream istream = strm.getFileAsIOStream("input.txt");        
        strm.printFileContent(istream,1);
        		
		//La variante avec un signe décallé	avec une fonction spéciale	 
		 Calcul.CalculVariante("5 * - 0.33");
		  
	}
	
}
