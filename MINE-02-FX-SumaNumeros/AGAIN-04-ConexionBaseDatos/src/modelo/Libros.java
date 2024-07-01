package modelo;

import java.sql.Date;

public class Libros {
    private int id;
    private String titulo;
    private String isbn;
    private int numPaginas;
    private Date fechaPublicacion;
    private int idAutor;
    private int idCategoria;
    private int idEditorial;
    
    public Libros(int id, String titulo, String isbn, int numPaginas, Date fechaPublicacion, int idAutor,
            int idCategoria, int idEditorial) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.fechaPublicacion = fechaPublicacion;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
        this.idEditorial = idEditorial;
    }

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(int idEditorial) {
        this.idEditorial = idEditorial;
    }

    
}
