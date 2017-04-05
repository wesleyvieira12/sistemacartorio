
package Modulos;

import Hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@Entity
@Table( name = "logs" )
public class Log implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable=false, length= 250)
    private String informacao;
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP) 
    private Date datahora;
    
    /* Log tem um usuario*/
    @ManyToOne
    private Usuario usuario;  
    
    public Log() { }
    public Log(String informacao, Date datahora, Usuario usuario) {
        
        this.informacao = informacao;
        Date data = new Date();
        this.datahora = data;
        this.usuario = usuario;
    }

       
    public void gerandoLog(Usuario u, String info){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Log l = new Log();
        Date data = new Date();
        l.setDatahora(data);
        l.setInformacao(info);
        l.setUsuario(u);
        s.save(l);
        t.commit();
        s.close();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
}
