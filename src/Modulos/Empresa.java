/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;



/**
 *
 * @author Wesley
 */

@Entity
@Table( name="empresas" )
public class Empresa implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable=true, length= 250)
    private String nome;
    @Column (nullable=true, length= 250)
    private String endereco;
    @Column(nullable=true, length= 250)
    private String bairro;
    @Column(nullable=true, length= 20)
    private String estado;
    @Column(nullable=true, length= 30)
    private String cidade;
    @Column(unique=true, nullable=true, length= 50)
    private String cnpj;
    /* Uma empresa tem varios usuarios*/
    @OneToMany(cascade = ALL, mappedBy="empresa")
    private List<Usuario> usuarios;
    /* Uma empresa tem varios protocolos*/
    @OneToMany(cascade = ALL, mappedBy="empresa")
    private List<Protocolo> protocolos;
   
    public Empresa(){
        
    }

    public Empresa(String nome, String endereco, String bairro, String estado, String cidade, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.estado = estado;
        this.cidade = cidade;
        this.cnpj = cnpj;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Protocolo> getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(List<Protocolo> protocolos) {
        this.protocolos = protocolos;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        String oldCnpj = this.cnpj;
        this.cnpj = cnpj;
        changeSupport.firePropertyChange("cnpj", oldCnpj, cnpj);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
    
}
