/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Hibernate.HibernateUtil;
import Modulos.Usuario;
import Modulos.Empresa;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Wesley
 */
public class Sessao {
    
    Usuario current_user;
    Empresa current_empresa;
    
    public Sessao(Usuario u){
        this.current_user = u;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        List<Empresa> x = s.createQuery("from Empresa where id="+current_user.getEmpresa().getId()).list();
        this.current_empresa = x.get(0);
        s.close();
    }
    

    
}
