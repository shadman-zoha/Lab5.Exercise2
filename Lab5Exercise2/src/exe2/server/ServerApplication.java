package exe2.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import exe2.ItemProduct.ItemProduct;

public class ServerApplication {

	public static void main(String[] args) {
		
		
		
		try {
			// Port initialization 
			int portNo=4228;
			ServerSocket serverSocket = new ServerSocket(portNo);
			
			System.out.println(" Waiting for request. ");
			
			int itemProductId=0, totalRequest =0;
			
			
			while (true)
			{
				
				// Accept client request for connection
				Socket socket = serverSocket.accept();
				
				// Create input stream to read object
				ObjectInputStream objectIS = new ObjectInputStream(socket.getInputStream());
				
				// Read object from stream and cast to ItemProduct
				ItemProduct item = (ItemProduct) objectIS.readObject();
				
				
				// To validate product name
				Product validation = new Product();
				
				String result = validation.validateItemName(item);
				
				
				// Process object
				item.setItemProductId(++itemProductId);
				
				// Create output stream to send object
				ObjectOutputStream objectOS = new ObjectOutputStream(socket.getOutputStream());
				
				objectOS.writeObject(item);
				
				
				// Send validation result
				objectOS.writeObject(result);
				objectOS.flush();
				
				
				System.out.println(" Total request : " + ++totalRequest);
				System.out.println(" Validation  : " + result);
				System.out.println("\n Waiting for next request. ");
				
				
				objectIS.close();
				objectOS.close();		
							
			}
		
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		

	}

}