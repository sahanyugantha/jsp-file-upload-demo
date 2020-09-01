package com.sahan.jspandservlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileUpload() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getServletContext();
		String filePath = context.getInitParameter("file-upload");
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);

			for (FileItem fileItem : fileItems) {

				if (!fileItem.isFormField()) {
					System.out.println("File name : " + fileItem.getName());
					try {
						fileItem.write(new File(filePath+"test/" + fileItem.getName()));
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("EEE : " + e.getMessage());
					}

				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
