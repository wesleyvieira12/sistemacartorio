
package Modulos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;


@Entity
@Table( name = "protocolos" )
public class Protocolo implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable=true, length= 250)
    private String nome_representante;
    @Column(nullable=true, length= 14)
    private String cpf_representante;
    @Column(nullable=false)
    @Temporal(TemporalType.DATE) 
    private Date data;
    @Column(nullable=false, length= 20)
    private String livro;
    @Column(nullable=false, length= 250)
    private String registro;
    @Column(nullable=false, length=50)
    private String folha;
    @Column(unique=true, nullable=false,columnDefinition="text")
    private String anotacao;
    @Column(nullable=true, length= 250)
    private String nome_empresa;
    @Column(nullable=true, length= 50)
    private String cnpj_empresa;
    
    /* Protocolo pertence a uma empresa*/
    @ManyToOne
    private Empresa empresa; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_representante() {
        return nome_representante;
    }

    public void setNome_representante(String nome_representante) {
        this.nome_representante = nome_representante;
    }

    public String getCpf_representante() {
        return cpf_representante;
    }

    public void setCpf_representante(String cpf_representante) {
        this.cpf_representante = cpf_representante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    

    
}
