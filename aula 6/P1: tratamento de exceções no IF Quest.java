```java
/*
 * IF Quest - Tratamento de Exceções
 *
 * Ferramenta de IA utilizada: ChatGPT (GPT-5.6 Luna)
 * Para quê: auxiliar na implementação das exceções, validações,
 * menu e regras da batalha.
 *
 * Modificações/validações manuais:
 * - Conferi as regras de validação dos atributos.
 * - Conferi o tratamento das exceções.
 * - Testei as criações válidas e inválidas.
 * - Testei o menu com entradas inválidas.
 * - Conferi o funcionamento da batalha e do finally.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


class SemManaException extends Exception {
    public SemManaException(int manaAtual) {
        super("Mana insuficiente! Mana atual: " + manaAtual
                + ". É necessário ter pelo menos 10 de mana.");
    }
}

// Desafio A
class ForcaInsuficienteException extends Exception {
    public ForcaInsuficienteException(int forcaAtual) {
        super("Força insuficiente! Força atual: " + forcaAtual
                + ". São necessários pelo menos 15 pontos de força.");
    }
}



class Personagem {
    private String nome;
    private int vida;

    public Personagem(String nome, int vida) {
        setNome(nome);
        setVida(vida);
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "O nome deve ser preenchido e não pode ser vazio."
            );
        }

        this.nome = nome;
    }

    public void setVida(int vida) {
        if (vida < 0 || vida > 100) {
            throw new IllegalArgumentException(
                    "A vida deve estar entre 0 e 100."
            );
        }

        this.vida = vida;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException(
                    "O dano deve ser maior ou igual a 0."
            );
        }

        vida -= dano;

        if (vida < 0) {
            vida = 0;
        }
    }

    public void ficha() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
    }
}



class Guerreiro extends Personagem {
    private int forca;

    public Guerreiro(String nome, int vida, int forca) {
        super(nome, vida);
        setForca(forca);
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        if (forca < 0 || forca > 100) {
            throw new IllegalArgumentException(
                    "A força deve estar entre 0 e 100."
            );
        }

        this.forca = forca;
    }

    public void atacar(Personagem alvo) {
        alvo.receberDano(forca);
        System.out.println(
                getNome() + " atacou causando " + forca + " de dano!"
        );
    }

    // Desafio A
    public void golpeEspecial(Personagem alvo)
            throws ForcaInsuficienteException {

        if (forca < 15) {
            throw new ForcaInsuficienteException(forca);
        }

        int dano = forca + 10;
        alvo.receberDano(dano);

        System.out.println(
                getNome() + " usou GOLPE ESPECIAL causando "
                        + dano + " de dano!"
        );
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Força: " + forca);
    }
}



class Mago extends Personagem {
    private int mana;

    public Mago(String nome, int vida, int mana) {
        super(nome, vida);
        setMana(mana);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0 || mana > 100) {
            throw new IllegalArgumentException(
                    "A mana deve estar entre 0 e 100."
            );
        }

        this.mana = mana;
    }

    public void lancarFeitico(Personagem alvo)
            throws SemManaException {

        if (mana < 10) {
            throw new SemManaException(mana);
        }

        int dano = 20;
        mana -= 10;

        alvo.receberDano(dano);

        System.out.println(
                getNome() + " lançou um feitiço causando "
                        + dano + " de dano!"
        );

        System.out.println("Mana restante: " + mana);
    }

    @Override
    public void ficha() {
        super.ficha();
        System.out.println("Mana: " + mana);
    }
}



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

      

        System.out.println("=== CRIAÇÃO DE PERSONAGENS ===");

        try {
            Guerreiro guerreiro = new Guerreiro(
                    "Guerreiro",
                    100,
                    20
            );

            System.out.println("Personagem válido criado:");
            guerreiro.ficha();

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Não foi possível criar o personagem: "
                            + e.getMessage()
            );
        }

        try 
            Guerreiro personagemInvalido = new Guerreiro(
                    "",
                    100,
                    20
            );

            System.out.println("Personagem criado:");
            personagemInvalido.ficha();

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Erro ao criar personagem: "
                            + e.getMessage()
            );
        }


        List<Personagem> personagens = new ArrayList<>();

        Guerreiro guerreiro = new Guerreiro(
                "Arthur",
                100,
                20
        );

        Mago mago = new Mago(
                "Merlin",
                100,
                30
        );

        personagens.add(guerreiro);
        personagens.add(mago);

        System.out.println("\n=== ESCOLHA DO HERÓI ===");

        Personagem escolhido = escolherPersonagem(
                scanner,
                personagens
        );

        System.out.println(
                "Você escolheu: " + escolhido.getNome()
        );

  

        System.out.println("\n=== BATALHA ===");

        guerreiro.ficha();
        System.out.println();
        mago.ficha();

        System.out.println("\nA batalha começou!");

        int turno = 1;

        while (guerreiro.estaVivo() && mago.estaVivo()) {

            System.out.println("\n--- TURNO " + turno + " ---");

       

            try {
                mago.lancarFeitico(guerreiro);

            } catch (SemManaException e) {

                // Exercício 3
                System.out.println(
                        "SemManaException capturada: "
                                + e.getMessage()
                );

                System.out.println(
                        "O Mago perdeu o turno!"
                );

                // Guerreiro ataca no lugar do Mago
                if (guerreiro.estaVivo()) {
                    guerreiro.atacar(mago);
                }

            } finally {

                // Exercício 4
                System.out.println("Fim do turno do Mago.");
            }

            if (!guerreiro.estaVivo()) {
                break;
            }

            if (!mago.estaVivo()) {
                break;
            }

     

            try {

                guerreiro.golpeEspecial(mago);

            } catch (ForcaInsuficienteException e) {

                System.out.println(
                        "ForcaInsuficienteException capturada: "
                                + e.getMessage()
                );

                System.out.println(
                        "O Guerreiro usará um ataque normal."
                );

                guerreiro.atacar(mago);

            } finally {

                System.out.println(
                        "Fim do turno do Guerreiro."
                );
            }

            turno++;
        }

    

        System.out.println("\n=== FIM DA BATALHA ===");

        guerreiro.ficha();
        System.out.println();
        mago.ficha();

        if (guerreiro.estaVivo()) {
            System.out.println("\nO Guerreiro venceu!");
        } else if (mago.estaVivo()) {
            System.out.println("\nO Mago venceu!");
        } else {
            System.out.println("\nA batalha terminou empatada!");
        }

        scanner.close();
    }


    public static Personagem escolherPersonagem(
            Scanner scanner,
            List<Personagem> personagens) {

        while (true) {

            System.out.println("\nHeróis disponíveis:");

            for (int i = 0; i < personagens.size(); i++) {
                System.out.println(
                        (i + 1) + " - "
                                + personagens.get(i).getNome()
                );
            }

            System.out.print(
                    "Digite o número do herói que deseja controlar: "
            );

            String entrada = scanner.nextLine();

            int numero;

          
            try {
                numero = Integer.parseInt(entrada);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Digite um número!"
                );

                continue;
            }

           
            try {

                return personagens.get(numero - 1);

            } catch (IndexOutOfBoundsException e) {

                System.out.println(
                        "Esse herói não existe. "
                                + "Escolha um número da lista."
                );
            }
        }
    }
}


