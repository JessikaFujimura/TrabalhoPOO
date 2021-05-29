package Entity;

import java.util.List;

public class Materia {

    private int id;
    private String codMateria;
    private String nome;
    private List<Aluno> alunos;
    private int faltas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
}
