package com.main.operators;

public class OperationController {
	
	private Operation operationCalcul;
	private float v1, v2, res;
	
	
	public OperationController(Operation operation, float v1,float v2)
	{	
		this.operationCalcul = operation;
		this.v1=v1;
		this.v2=v2;
		this.res = this.operationCalcul.Calculate(this.v1,this.v2);
	}
	
	
	public float Resultat()
	{
						
		return this.res;
	}


}
