public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    // Construtor completo
    public Livro(String titulo, String autor, int anoPublicacao) {
        setTitulo(titulo);
        setAutor(autor);
        setAnoPublicacao(anoPublicacao);
    }

    // Segunda forma de criação
    public Livro(String titulo, String autor) {
        this(titulo, autor, 2026);
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    // Setters com validação
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }

        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor não pode ser vazio.");
        }

        this.autor = autor;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        if (anoPublicacao < 1500 || anoPublicacao > 2026) {
            throw new IllegalArgumentException(
                "O ano de publicação deve estar entre 1500 e 2026."
            );
        }

        this.anoPublicacao = anoPublicacao;
    }

    public void mostrarDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + anoPublicacao);
    }
}
