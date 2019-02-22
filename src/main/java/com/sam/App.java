package com.sam;

import java.rmi.RemoteException;

import com.sam.autentica.ws.servidor.EchoStub;

public class App {
	public static void main(String args[]) {
		EchoStub client = null;
		EchoStub.Saludar request = null;
		EchoStub.SaludarResponse response = null;
		
		long timeout = 2 * 60 * 1000; // Two minutes
		
		try {
			client = new EchoStub();
			client._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeout);

			request = new EchoStub.Saludar();					
			request.setNombre("Sam");
			
			response = client.saludar(request);			
		} catch (RemoteException e) {
			System.out.println(e.toString());
		}

		System.out.println(response.get_return());
	}
}
