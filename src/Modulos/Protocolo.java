package Modulos;

import Hibernate.HibernateUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "protocolos")
public class Protocolo implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = true, length = 250)
    private String nome_representante;
    @Column(unique=true,nullable = true, length = 14)
    private String cpf_representante;
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(nullable = false, length = 20)
    private String livro;
    @Column(nullable = false, length = 250)
    private String registro;
    @Column(nullable = true, length = 50)
    private String folha;
    @Column(unique = true, nullable = false, columnDefinition = "text")
    private String anotacao;
    @Column(nullable = true, length = 250)
    private String nome_empresa;
    @Column(nullable = false)
    private char tipo;
    @Column(unique=true,nullable = true, length = 50)
    private String cnpj_empresa;

    /* Protocolo pertence a uma empresa*/
    @ManyToOne
    private Empresa empresa;

    public boolean valido(Protocolo p) {
        boolean erro = false;

        if (p.nome_empresa.equals("") && p.tipo=='J') {
            JOptionPane.showMessageDialog(null,"Nome da empresa em branco");
            erro = true;
        }

        if (p.nome_representante.equals("") && p.tipo == 'F') {
            JOptionPane.showMessageDialog(null,"Nome da pessoa em branco");
            erro = true;
        }

        if (p.livro.equals("") || p.registro.equals("")) {
            JOptionPane.showMessageDialog(null,"Folha ou livro está em branco");
            erro = true;
        }
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        List<Protocolo> protocolos;
        if(p.tipo == 'F'){
            protocolos = s.createQuery("from Protocolo where cpf_representante='" + p.cpf_representante+"'").list();
        }else{
            protocolos = s.createQuery("from Protocolo where cnpj_empresa='" + p.cnpj_empresa+"'").list();
        }
        s.close();
        if (!protocolos.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Existe CPF/CNPJ com este numero!");
            erro = true;
        }

        return erro;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    public long getId() {
        return id;
    }

    public String getIdString() {
        return "" + id;
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

    public String getDataString() {
        if(data!=null){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        return "" + f.format(data);
        }else{
            return "";
        }
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
