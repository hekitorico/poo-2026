public class Biblioteca {
    private String nome;
    private Livro livro;

    public Biblioteca(String nome, Livro livro) {
        setNome(nome);
        setLivro(livro);
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public Livro getLivro() {
        return livro;
    }

    // Setters com validação
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da biblioteca não pode ser vazio.");
        }

        this.nome = nome;
    }

    public void setLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("A biblioteca precisa possuir um livro.");
        }

        this.livro = livro;
    }

    public void mostrarDados() {
        System.out.println("Biblioteca: " + nome);
        System.out.println("Livro cadastrado:");
        livro.mostrarDados();
    }

    public static void main(String[] args) {

        System.out.println("=== CRIAÇÃO VÁLIDA - CONSTRUTOR COMPLETO ===");

        Livro livro1 = new Livro(
            "O Hobbit",
            "J. R. R. Tolkien",
            1937
        );

        Biblioteca biblioteca1 = new Biblioteca(
            "Biblioteca Central",
            livro1
        );

        biblioteca1.mostrarDados();


        System.out.println("\n=== CRIAÇÃO VÁLIDA - CONSTRUTOR SIMPLIFICADO ===");

        Livro livro2 = new Livro(
            "Dom Casmurro",
            "Machado de Assis"
        );

        livro2.mostrarDados();


        System.out.println("\n=== TENTATIVA DE CRIAÇÃO INVÁLIDA ===");

        try {
            Livro livroInvalido = new Livro(
                "",
                "Autor Desconhecido",
                2020
            );

            livroInvalido.mostrarDados();

        } catch (IllegalArgumentException e) {
            System.out.println("Criação recusada: " + e.getMessage());
        }


        System.out.println("\n=== OUTRA VALIDAÇÃO ===");

        try {
            Livro livroInvalido = new Livro(
                "Livro Teste",
                "Autor Teste",
                1200
            );

            livroInvalido.mostrarDados();

        } catch (IllegalArgumentException e) {
            System.out.println("Criação recusada: " + e.getMessage());
        }
    }
}
