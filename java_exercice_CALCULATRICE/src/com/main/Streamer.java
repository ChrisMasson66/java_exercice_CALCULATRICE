package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Streamer {
	
	private StringBuilder SB = null;
	
	
	public Streamer()
	{
		
	}

	
	//chargement du fichier
    public InputStream getFileAsIOStream(final String fileName) 
    {
       
    	InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
       
        if (ioStream == null) 
        
        {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }
    
    
  //affiche le résultat
    public void printFileContent(InputStream istream, int switcher) 
    {
    	
    try {
    	
    	SB=new StringBuilder();
    	
    	InputStreamReader ireader = new InputStreamReader(istream);
        
        BufferedReader buffer = new BufferedReader(ireader);
        
        String line = "";
               
        while ((line = buffer.readLine()) != null) 
        {
        	SB.append(line + " = " + Calcul.LaunchCalcul(line));
        	SB.append("\n");
        	
        	
        	
        	System.out.println( line + " = " + Calcul.LaunchCalcul(line));
        	        	       	
        }
      
        //Ecriture dans le fichier qui est créé auto si non existant
        this.WriteTextIntoFile("data/output.txt",SB);  
        
        	buffer.close();
        	
        	//System.out.println(SB);
      
       } 
      catch (IOException e) 
      {
      
        e.printStackTrace();
        
       }

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
