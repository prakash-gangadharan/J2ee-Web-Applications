package com.example.LoginLogoutDownload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String filename="hellotable.csv";
		String filepath=getServletContext().getRealPath("/downloads/"+filename);
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
		
		/*FileInputStream fileInputStream=new FileInputStream(filepath+filename);
		int i;
		while((i=fileInputStream.read())!=-1){
			out.write(i);
		}
		fileInputStream.close();
		out.close();*/
		BufferedOutputStream output =null;
		FileInputStream fileInputStream=new FileInputStream(filepath);
		BufferedInputStream bis = new BufferedInputStream(fileInputStream);
		output = new BufferedOutputStream(response.getOutputStream());
        for (int data; (data = bis.read()) > -1;)
        {
        	output.write(data);
		}
        
        fileInputStream.close();
        output.flush();
        bis.close();
		/*int i;
		while((i=fileInputStream.read())!=-1){
			out.write(i);
		}
		fileInputStream.close();
		out.close();*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
