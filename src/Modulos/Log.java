
package Modulos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


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

    public Log(long id, String informacao, Date datahora, Usuario usuario) {
        this.id = id;
        this.informacao = informacao;
        this.datahora = datahora;
        this.usuario = usuario;
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
