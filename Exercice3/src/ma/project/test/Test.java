/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ma.project.test;

import java.util.Date;
import ma.project.entities.Employe;
import ma.project.entities.EmployeTache;
import ma.project.entities.Projet;
import ma.project.entities.Tache;
import ma.project.service.EmployeService;
import ma.project.service.EmployeTacheService;
import ma.project.service.ProjetService;
import ma.project.service.TacheService;
import ma.project.util.HibernateUtil;


public class Test {
    public static void main(String[] args) {
      HibernateUtil.getSessionFactory();
    }
}
