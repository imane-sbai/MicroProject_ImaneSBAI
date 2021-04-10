package com.controllers;

import java.io.IOException;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.Article;
import com.models.User;
import java.util.*;

/**
 * Servlet implementation class ArticleCont
 */
@WebServlet("/ArticleCont")
public class ArticleCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleCont() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int codearticle=Integer.parseInt(request.getParameter("id"));
		
	

		 String query = "select * from articles where codearticle ="+codearticle;
	     
			try {
				   PreparedStatement preparedStmt = new ConnectionDatab().connect().prepareStatement(query);
			        System.out.println(preparedStmt);
					ResultSet res;
				res = preparedStmt.executeQuery();
				Article article=null;
				while(res.next()) {
					article =new Article(res.getInt("codearticle"), res.getString("designation"), res.getInt("stock"), res.getString("categorie"),
	        	            res.getDouble("prix"), res.getString("photo"),res.getString("categ")
	        	            );
				}
				System.out.println(article);
				 
			
				request.setAttribute("article1", article);
				 request.getRequestDispatcher("articledetails.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
