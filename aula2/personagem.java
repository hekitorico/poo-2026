public class Personagem {
    String nome;
    int vida;
    int forca;

    public Personagem(String nome, int vida, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
    }

    public void receberDano(int dano) {
        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void ficha() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + forca);
        System.out.println();
    }

    public void atacar(Personagem alvo) {
        alvo.receberDano(forca);
        System.out.println(nome + " atacou " + alvo.nome + " causando " + forca + " de dano!");
    }

    public static void main(String[] args) {
        Personagem heroi = new Personagem("Batman", 100, 20);
        Personagem chefe = new Personagem("Coringa", 150, 25);

        
        heroi.ficha();
        chefe.ficha();

        

        while (heroi.estaVivo() && chefe.estaVivo()) {
            heroi.atacar(chefe);

            if (chefe.estaVivo()) {
                chefe.atacar(heroi);
            }

            System.out.println();
        }

        
        heroi.ficha();
        chefe.ficha();

        if (heroi.estaVivo()) {
            System.out.println("O Batman venceu!");
        } else {
            System.out.println("O Coringa venceu!");
        }
    }
}
