package com.main;


import java.io.InputStream;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Calcul_Stream {
	
		
		public Calcul_Stream()
		{
			//constructeur vide ...
		}
			
		//chargement du fichier
	    public InputStream getFileAsIOStream(final String fileName) 
	    {       
	    	InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
	       
	        if (ioStream == null) 
	        
	        {
	            throw new IllegalArgumentException(fileName + " non trouvé");
	        }
	        return ioStream;
	    }
	        

	    //Fonction pour écrire le texte dans le fichier
	    public void WriteTextIntoFile(String fileName, StringBuilder textToWrite)
	    {
	    	//System.out.println(textToWrite);
	    	
	    	//init buffer pour l'écriture
	    	BufferedWriter writer = null;
	    	
	    	//dans un try catch pour gestion d'erreur
	        try {
	        	//init du writer 
	            writer = new BufferedWriter(new FileWriter(fileName));
	            
	            //on dump la stringbuilder et écrire le texte dans le fichier
	            writer.append(textToWrite);
	        
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            try {
	                // fermeture du flux
	                writer.close();
		            } 
		            catch (Exception e) 
		            {
		            	
		            }
	        }
	    }
	

}
