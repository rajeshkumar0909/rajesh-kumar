package org.arpit.javapostsforlearning.webservice;

import java.applet.Applet;
import java.awt.Desktop;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFrame;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

 

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class comments   
{
	void start()
	{
    try
    {
        //

        Client client = Client.create();

        WebResource resource = client
                .resource("https://jsonplaceholder.typicode.com/comments");

        ClientResponse response = resource
                .type("application/json").get(ClientResponse.class);
        
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
             + response.getStatus());
         }
  
        String customer = response.getEntity(String.class);
         
    
          JSONArray new_array = new JSONArray(customer);
          String txt="",txt1="";
          
//          System.out.println("<html><body>");
//          System.out.println("<table><tr><td>postId</td><td>id</td><td>name</td><td>email</td><td>body</td></tr>");
          txt="<html><body><table border='1'><tr><td>postId</td><td>id</td><td>name</td><td>email</td><td>body</td></tr>";
          txt1=txt1+txt;
          
          for (int i=0;i<new_array.length();i++)
          {
        	 
        	  org.json.JSONObject json = new_array.getJSONObject(i);
         
        	  
        	  int a=(int) json.get("postId");
        	  int b=(int) json.get("id");  
               String y=(String) json.get("name");
              String x=(String) json.get("email");
               String z=(String) json.get("body");
           
               
//               System.out.println("<tr><td>"+a+"</td>");  
//               System.out.println("<td>"+b+"</td>");
//               System.out.println("<td>"+y+"</td>");  
//               System.out.println("<td>"+x+"</td>");  
//               System.out.println("<td>"+z+"</td></tr>");
           
               txt="<tr><td>"+a+"</td><td>"+b+"</td><td>"+y+"</td> <td>"+x+"</td><td>"+z+"</td>";
               txt1=txt1+txt;
        	  
          }
          //System.out.println("</table></body></html>");
          txt="</table></body></html>";
          txt1=txt1+txt;
          
          
          BufferedWriter out = new BufferedWriter(new FileWriter("outfilename.html"));
          out.write(txt1);   
          out.close(); 


          File htmlFile = new File("outfilename.html");
          Desktop.getDesktop().browse(htmlFile.toURI());
          
    } catch (Exception e)
    {
        e.printStackTrace();
    }
	}
	
	
    public static void main(String args[])
    {
    	new comments().start();
    	
    	
    	
    }
}
  

  