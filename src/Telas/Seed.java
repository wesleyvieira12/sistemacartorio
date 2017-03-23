/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;


import Hibernate.HibernateUtil;
import Modulos.Empresa;
import Modulos.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Wesley
 */
public class Seed {
    public static void main(String args[]) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        System.out.println("Criando empresa");
        Empresa e = new Empresa();
        e.setBairro("Centro");
        e.setCidade("Oeiras");
        e.setCnpj("06.735.328/0001-32");
        e.setEndereco("Faltando");
        e.setEstado("Piaui");
        e.setNome("Cartorio do primeiro oficio de notas e registro de imoveis comarca de Oeiras-PI");
        
        Transaction t = s.beginTransaction();
        s.saveOrUpdate(e);
        t.commit();
        s.flush();
        s.close();
        
        SessionFactory sf2 = HibernateUtil.getSessionFactory();
        Session s2 = sf2.openSession();
        
        System.out.println("Criando usuario");
        
        Usuario u = new Usuario();
        u.setEmpresa(e);
        u.setNome("Administrador");
        u.setUsername("admin");
        u.setAdmin(true);
        String senha_inicial = "12345";
        
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha_inicial.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senha = hexString.toString();
        u.setSenha(senha);
               
        Transaction t2 = s2.beginTransaction();
        s2.saveOrUpdate(u);
        t2.commit();
        s2.close();
        
        System.exit(0);
                
    }
    
}
