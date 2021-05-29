package Entity;

import java.time.LocalDate;

public class Evento {

    private int id;
    private String titulo;
    private LocalDate data;
    private String hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", Titulo='" + titulo + '\'' +
                ", data=" + data +
                ", hora='" + hora + '\'' +
                '}';
    }
}
