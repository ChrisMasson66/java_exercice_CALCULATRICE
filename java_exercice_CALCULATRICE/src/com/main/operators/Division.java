package com.main.operators;

public class Division implements Operation {

	@Override
	public float Calculate(float v1, float v2) {
		// TODO Auto-generated method stub
		float div=0;
		
		try {
			  
			div = v1/v2;
			
			}
			catch(Exception e) {
			    // Exception message
	            System.out.println(
	                "Division par 0 impossible");
			}

		return div;
	}

}
