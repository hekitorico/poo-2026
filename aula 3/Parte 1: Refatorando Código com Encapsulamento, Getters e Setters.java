public class Personagem {

    private String nome;
    private int vida;
    private int nivel;

    public Personagem() {
        this.nome = "Sem nome";
        this.vida = 100;
        this.nivel = 1;
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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida >= 0 && vida <= 100) {
            this.vida = vida;
        } else {
            System.out.println("Erro: A vida deve estar entre 0 e 100.");
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel >= 1) {
            this.nivel = nivel;
        } else {
            System.out.println("Erro: O nível deve ser maior ou igual a 1.");
        }
    }

    public static void main(String[] args) {
        Personagem p = new Personagem();

        p.setVida(-50);
        p.setNome("");
        p.setNivel(0);

        p.setNome("Geralt");
        p.setVida(80);
        p.setNivel(5);

        System.out.println("Nome: " + p.getNome());
        System.out.println("Vida: " + p.getVida());
        System.out.println("Nível: " + p.getNivel());
    }
}
