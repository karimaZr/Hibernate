/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Marriage;
import ma.projet.config.util.HibernateUtil;
import ma.projet.service.FemmeService;
import ma.projet.service.HommeService;
import ma.projet.service.MarriageService;
import ma.projet.beans.MarriageKey;


/**
 *
 * @author hp
 */
public class Test {
    public static void main(String[] args){
         HibernateUtil.getSessionFactory();
          HommeService hs = new HommeService();
         FemmeService fs = new FemmeService(); 
         MarriageService ms = new MarriageService();
         
        
        hs.create(new Homme("Zrayouil","Mohammed","234567890","casa",new Date()));
        hs.create(new Homme("Zrayouiil","Hamza","65789090","El jadida",new Date()));
        hs.create(new Homme("karimi","Youssef","5467890","Agadir",new Date()));
         
        fs.create(new Femme("zrayouil","karima","234567","casa",new Date()));
        fs.create(new Femme("zrayouil","HAMIDA","234567","casa",new Date()));
        fs.create(new Femme("zrayouil","MBARKA","234567","casa",new Date()));
       
      
       for(Femme fm : fs.getAll()){
            System.out.println("Femme : "+fm.getNom()+" "+fm.getPrenom());
       }
       MarriageKey key1=new MarriageKey(fs.getById(1).getId(),hs.getById(1).getId());
       MarriageKey key2=new MarriageKey(fs.getById(2).getId(), hs.getById(2).getId());
      ms.create(new Marriage(key1,new Date(), new Date(),4));
      ms.create(new Marriage(key2,new Date(), new Date(),2));

    
    }
}
