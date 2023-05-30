package com.main;

import java.util.*;

import com.main.operators.*;


public class Calcul {
	

    public static float LaunchCalcul(String string)
    {
    	//déclare deux listes pour les operateur/symboles
    	//et on affecte les résultats des fonctions
        List<Character> listOfSymbols = getSymbols(string);
        
        List<String> listOfOperands = getOperators(string);
        
        //nombre de valeur
        int operationCount = listOfSymbols.size();
        
        //on travaille 2 à 2
        float operand1= 0.0F;
        float operand2=0.0F;
        float result=0.0F;
        
        //on vérifie les ops
        while(operationCount>0)
        {
        	//la liste doit au moins contenir une opération prioritaire
            if(listOfSymbols.contains('*') || listOfSymbols.contains('/') || listOfSymbols.contains('-'))
            {
            	//on check les positions
                int currentPositionMultiplication = listOfSymbols.indexOf('*');
                int currentPositionDividation = listOfSymbols.indexOf('/');
                int currentPositionSoustraction = listOfSymbols.indexOf('-');
                
                //selon les cas
                if((currentPositionMultiplication < currentPositionDividation && currentPositionMultiplication !=-1 ) || currentPositionDividation == -1)
                {
                    operand1 = Float.parseFloat(listOfOperands.get(currentPositionMultiplication));
                    operand2 = Float.parseFloat(listOfOperands.get(currentPositionMultiplication+1));
                    
                    //controleur calcul
                	OperationController calc = new OperationController(new Multiplication(), operand1, operand2);                      
                    result = calc.Resultat();

                    listUpdater(listOfSymbols,listOfOperands,currentPositionMultiplication,result);
                    
                    
                    
                }
                else if((currentPositionMultiplication>currentPositionDividation && currentPositionDividation!=-1) || currentPositionMultiplication==-1)
                {
                    operand1=Float.parseFloat(listOfOperands.get(currentPositionDividation));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionDividation+1));
                    
                    //controleur calcul
                	OperationController calc = new OperationController(new Division(), operand1, operand2);                      
                    result = calc.Resultat();

                    listUpdater(listOfSymbols,listOfOperands,currentPositionDividation,result);
                }

            }
            else if(listOfSymbols.contains('-') || listOfSymbols.contains('+'))
            {
                int currentPositionSubstraction=listOfSymbols.indexOf('-');
                int currentPositionAddition=listOfSymbols.indexOf('+');

                if((currentPositionSubstraction<currentPositionAddition && currentPositionSubstraction!=-1) || currentPositionAddition==-1)
                {
                    operand1=Float.parseFloat(listOfOperands.get(currentPositionSubstraction));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionSubstraction+1));
                    
                    //controleur calcul
                	OperationController calc = new OperationController(new Soustraction(), operand1, operand2);                      
                    result = calc.Resultat();
                    
                    //mise  àjour de la liste
                    listUpdater(listOfSymbols,listOfOperands,currentPositionSubstraction,result);
                }
                else if((currentPositionSubstraction > currentPositionAddition && currentPositionAddition!=-1) || currentPositionSubstraction==-1)
                {

                    operand1=Float.parseFloat(listOfOperands.get(currentPositionAddition));
                    operand2=Float.parseFloat(listOfOperands.get(currentPositionAddition+1));
                    
                    //controleur calcul
                	OperationController calc = new OperationController(new Addition(), operand1, operand2);                      
                    result = calc.Resultat();

                    listUpdater(listOfSymbols,listOfOperands,currentPositionAddition,result);
                }

            }
            
            //décrémente
            operationCount--;
        }

        
        Iterator<String> iterator = listOfOperands.iterator(); 

        String finalResult="";

        while(iterator.hasNext())
        {
            finalResult=iterator.next();
        }
        
        //retourne le résultat
        return Float.parseFloat(finalResult);
    }

	//test variable
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            float d = Float.parseFloat(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    
    //gestion liste des symboles  
    private static List<Character> getSymbols(String string)
    {
        List<Character> listOfSymbols=new LinkedList<Character>(); 
        
        //mettre tableau
        
    	String tab[] = string.split("\\s");
    	
        
        for(int i=0;i<tab.length;i++)
        {
            String symbol = tab[i];
            
            if(!isNumeric(symbol))
            	{
		                char[] ch = symbol.toCharArray();  
		                
		                for(int j=0;j< ch.length;j++)
		                {  
		                    if(ch[j]=='-' || ch[j]=='+' || ch[j]=='*' || ch[j]=='/')
		                    {
		                        listOfSymbols.add(ch[j]);
		                    }
		                } 
            	
            	}
            
        }
        return listOfSymbols;
    }
   
    
    private static List<String> getOperators(String string)
    {
       // String[] operandsArray=string.split("-|\\+|\\*|\\/");
    	String[] operandsArray=string.split("\\s");
        
        List<String> listOfOperands=new LinkedList<String>();

        for(int i=0;i<operandsArray.length;i++)
        {
        	if (isNumeric(operandsArray[i]))
        	  listOfOperands.add(operandsArray[i]);
        }
          

        return listOfOperands;
    }

    
    //on met à jour les 2 listes pour les calculs
    private static void listUpdater(List<Character> listOfSymbols, List<String> listOfOperands, int position, float result)
    {
        listOfSymbols.remove(position);
        
        listOfOperands.remove(position);
        
        listOfOperands.remove(position);
        
        listOfOperands.add(position,String.valueOf(result));
       
    }

	
	//calcul signe VARIANTE
	public static void CalculVariante(String expr)
	{
			
		double var1 = 0;
		double var2 = 0;
		char operande = ' ';//par défaut
		char signe = '-';//celui qui pose problème
		double resultat = 0;
			
		String tab[] = expr.split("\\s");
		
		// Creating an empty Stack
        Stack<Double> calcStack = new Stack<Double>();
		
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<=tab.length-1;i++)
		{					
			stack.push(tab[i]);			
		}
		
		
		for(String o : stack)
		{
			try
			{
			
				
			if(o.equals("+")  || o.equals("-")  || o.equals("*")  || o.equals("/") )
				{
				
				if(operande == ' ') //l'opérande vide
				{
							switch(o)
							{							
					            case "+":
					            	operande = '+';
					            
					            	break;
					            case "-":
					            	operande = '-';
					            	
					            	break;
					            case "*":
					            	operande ='*';
					            	break;
					            case "/":
					            	operande ='/';
					            	//stack.pop();
					            	break;
							}
						}
				
						else //présence d'un signe moins 
						{
							//on va multiplier le nombre suivant, CAR C UN NOMBRE, par -1
							if(o.equals("-") )
							{
								//
								int index = stack.indexOf(o) +1;
								
								String number = stack.get(index); //
																
								var2 = Double.parseDouble(number)* (-1);
								
								stack.set(index, String.valueOf(var2)); //et on replace
							}
							
						}					
				}
				else 
				{
					
					Double.parseDouble(o);
					
					var1 = Double.parseDouble(o);
				  
					calcStack.push(var1);
					
				}
			  
			}
			
			catch(NumberFormatException e)
			{
				   System.out.println("ERROR de CALCUL");	
			}	
			
			finally {
				
				//test
				if(calcStack.size() == 2)
				{
					double secondOperand = calcStack.pop();
					double firstOperand = calcStack.pop();
					String opr = String.valueOf(operande);
					//si c'est un nombre qui vient de rentrer alors on calcul
					resultat += calcMachine(opr,secondOperand, firstOperand);
					
					  System.out.println(resultat);	
				}
				
			}
						
		}
				
	}
	 
	//calcul simple
	private static double calcMachine(String o,double a, double b)
	{		
        switch (o) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
        case "/":
            if (b == 0) {
                throw new UnsupportedOperationException("Cannot divide by zero");
            }
            return a / b;
    }
    return 0;
		
	}
	 
}
