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
        e.setBairro("Rodagem");
        e.setCidade("Oeiras");
        e.setCnpj("1020233214435");
        e.setEndereco("Av.floriano");
        e.setEstado("Piaui");
        e.setNome("Catorio tal");
        
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
        u.setNome("Wesley");
        String senha_inicial = "12345";
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha_inicial.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senha = hexString.toString();
        System.out.println(senha);
        u.setSenha(senha);
        u.setUsername("vieiray");
        Transaction t2 = s2.beginTransaction();
        s2.saveOrUpdate(u);
        t2.commit();
        
        List<Usuario> l = s2.createQuery("from Usuario").list();
        for(Usuario x : l){
            System.out.println("Nome:"+x.getNome());
        }
       
        
        s2.close();
        
        
                
    }
    
}
