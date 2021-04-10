package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.controllers.ConnectionDatab;
import com.models.Article;



public class ArticleDao {
	
	  static  public List<Article> getAllArticles() throws Exception {
	        List<Article> articlesList = new ArrayList<>();

	        String query = "SELECT *  FROM articles";
	        ResultSet res = new ConnectionDatab().connect().createStatement().executeQuery(query);
	        System.out.println(res);
	        while (res.next())
	        {
	        	 articlesList.add(new Article(res.getInt("codearticle"), res.getString("designation"), res.getInt("stock"), res.getString("categorie"),
	        	            res.getDouble("prix"), res.getString("photo"),res.getString("categ")
	        	            ));
	        }

	        return articlesList;
	    }

		 static public List<Article> getArticles(String categorie){
			
			List<Article> articles=new ArrayList<Article>();
			try{
				String query = "SELECT *  FROM articles  where categ= '" +categorie+ "'";
			
		        ResultSet res = new ConnectionDatab().connect().createStatement().executeQuery(query);
		        
		         // Extract data from result set
		         while(res.next()){
		            //Retrieve by column name
		        	int codearticle = res.getInt("codearticle");
		            String designation = res.getString("designation");
		            double prix = res.getDouble("prix");
		            String photo= res.getString("photo");
		            String categ = res.getString("categ");
		            int stock=res.getInt("stock");
		            Article article=new Article(codearticle, designation,  stock, categorie, prix, photo,
		        			 categ);
		            articles.add(article); 
		         }
		         res.close();
		     
		      }catch(Exception e){
		        
		         e.printStackTrace();
		      }
			
			return articles;
		}
	 
}
