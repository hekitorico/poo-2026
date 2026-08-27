public class Produto {

    private String nome;
    private double preco;
    private int quantidade;

    public Produto() {
        this.nome = "Sem nome";
        this.preco = 0.0;
        this.quantidade = 0;
    }

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            System.out.println("Erro: O nome não pode ser vazio.");
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: O preço não pode ser negativo.");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade >= 0) {
            this.quantidade = quantidade;
        } else {
            System.out.println("Erro: A quantidade não pode ser negativa.");
        }
    }

    public void aplicarDesconto() {
        this.preco -= this.preco * 0.10;
    }

    public void aplicarDesconto(double percentual) {
        if (percentual >= 0 && percentual <= 100) {
            this.preco -= this.preco * (percentual / 100.0);
        } else {
            System.out.println("Erro: Percentual de desconto inválido.");
        }
    }

    public void exibir() {
        System.out.println("Nome: " + nome + " | Preço: R$ " + String.format("%.2f", preco) + " | Quantidade: " + quantidade);
    }

    public static void main(String[] args) {
        Produto p1 = new Produto();
        Produto p2 = new Produto("Notebook", 3500.00, 5);

        System.out.println("--- Dados Iniciais ---");
        p1.exibir();
        p2.exibir();

        p1.setPreco(100.00);

        System.out.println("\n--- Aplicando Descontos ---");
        p1.aplicarDesconto();
        p2.aplicarDesconto(25.0);

        System.out.println("\n--- Dados Após Descontos ---");
        p1.exibir();
        p2.exibir();
    }
}
