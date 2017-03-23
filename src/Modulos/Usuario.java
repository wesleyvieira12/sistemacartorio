
package Modulos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;


@Entity
@Table( name = "usuarios" )
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable=false, length= 250)
    private String nome;
    @Column
    private Boolean admin;
    @Column(unique=true, nullable=false, length= 20)
    private String username;
    @Column(nullable=false, length= 250)
    private String senha;
    
    /* Usuario pertence a uma empresa*/
    @ManyToOne
    private Empresa empresa;  
    
    /* Usuario tem varios logs*/
    @OneToMany(cascade=ALL, mappedBy="usuario")
    private List<Log> logs;

    public Usuario(){
        
    }
    public Usuario(String nome, String username, String senha, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.empresa = empresa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
    
    
    
    
    
}
