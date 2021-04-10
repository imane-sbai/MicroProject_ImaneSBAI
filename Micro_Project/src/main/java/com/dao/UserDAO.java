package com.dao;

import com.controllers.ConnectionDatab;



import com.models.User;

import java.sql.*;

public class UserDAO {



    public boolean create(User u) throws Exception {
        String query = "INSERT INTO clients(nom,prenom,email,adresse,motpasse) VALUES(?,?,?, ?, ?)";
        PreparedStatement preparedStmt = new ConnectionDatab().connect().prepareStatement(query);


        preparedStmt.setString (1, ((User) u).getNom());
        preparedStmt.setString (2, ((User) u).getPrenom());
        preparedStmt.setString (3, ((User) u).getEmail());
        preparedStmt.setString (4, ((User) u).getAdresse());
        preparedStmt.setString (5, ((User) u).getMotdepasse());
        preparedStmt.execute();

        System.out.println("USER : " + ((User) u).toString());
        return true;
    }
    public boolean finduser(User u) throws Exception {
    	boolean statut=false;
        String query = "select * from clients where email = ? and motpasse = ?";
        PreparedStatement preparedStmt = new ConnectionDatab().connect().prepareStatement(query);

        preparedStmt.setString (1, ((User) u).getEmail());
        preparedStmt.setString (2, ((User) u).getMotdepasse());
        System.out.println(preparedStmt);
		ResultSet rs = preparedStmt.executeQuery();
		statut = rs.next();



        return statut;
    }
    public User findbyemail(String email) throws Exception {
        User user = new User();
        String query = "SELECT *  FROM clients WHERE email = '" + email + "'";
        ResultSet res = new ConnectionDatab().connect().createStatement().executeQuery(query);
        System.out.println(res);
        while (res.next())
        {
           
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            user.setEmail(res.getString("email"));
            user.setMotdepasse(res.getString("motpasse"));
            user.setAdresse(res.getString("adresse"));
        }
        return user;
    }


 

  

  
}
