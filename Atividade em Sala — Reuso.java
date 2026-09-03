```java
/*
 * ATIVIDADE EM SALA - REUSO
 * Uma Família de Classes e um Único Laço
 *
 * PASSO 1 - PLANO
 *
 * Domínio: Veículos
 *
 * Superclasse: Veiculo
 * Subclasses: Carro e Moto
 *
 * Carro é um Veiculo.
 * Moto é um Veiculo.
 *
 * Atributos próprios:
 * - Carro: numeroDePortas
 * - Moto: cilindradas
 *
 * Método abstrato:
 * - mover()
 *   Cada subclasse implementará esse método de uma maneira diferente.
 *
 * Método sobrescrito:
 * - exibirInfo()
 *   As subclasses chamarão a versão herdada com super.exibirInfo()
 *   e depois acrescentarão suas próprias informações.
 *
 * Uso de IA:
 * - A IA foi utilizada para auxiliar na organização e conferência
 *   da hierarquia de classes e dos critérios da atividade.
 */

import java.util.ArrayList;
import java.util.List;

// ============================================================
// SUPERCLASSE
// ============================================================

abstract class Veiculo {

    protected String marca;
    protected String modelo;

    // Construtor da superclasse
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    /*
     * Método abstrato.
     * Cada subclasse deve implementar seu próprio comportamento.
     */
    public abstract void mover();

    /*
     * Método que será reutilizado pelas subclasses.
     */
    public void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
    }
}

// ============================================================
// SUBCLASSE CARRO
// ============================================================

class Carro extends Veiculo {

    private int numeroDePortas;

    // Construtor da subclasse chamando super
    public Carro(String marca, String modelo, int numeroDePortas) {
        super(marca, modelo);
        this.numeroDePortas = numeroDePortas;
    }

    /*
     * Implementação própria do método abstrato.
     */
    @Override
    public void mover() {
        System.out.println("O carro está se movendo pelas ruas.");
    }

    /*
     * Sobrescreve o método da superclasse.
     * Reaproveita a versão herdada usando super.exibirInfo().
     */
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Carro");
        System.out.println("Número de portas: " + numeroDePortas);
    }
}

// ============================================================
// SUBCLASSE MOTO
// ============================================================

class Moto extends Veiculo {

    private int cilindradas;

    // Construtor da subclasse chamando super
    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    /*
     * Implementação própria do método abstrato.
     */
    @Override
    public void mover() {
        System.out.println("A moto está se movendo rapidamente pelas ruas.");
    }

    /*
     * Sobrescreve o método da superclasse.
     * Reaproveita a versão herdada usando super.exibirInfo().
     */
    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Tipo: Moto");
        System.out.println("Cilindradas: " + cilindradas + " cc");
    }
}

// ============================================================
// PROGRAMA PRINCIPAL
// ============================================================

public class Main {

    public static void main(String[] args) {

        /*
         * PASSO 2 - DEMONSTRAÇÃO
         *
         * A coleção é do tipo da superclasse Veiculo,
         * mas contém objetos das duas subclasses.
         */
        List<Veiculo> veiculos = new ArrayList<>();

        veiculos.add(new Carro("Toyota", "Corolla", 4));
        veiculos.add(new Moto("Honda", "CB 500", 500));
        veiculos.add(new Carro("Volkswagen", "Golf", 4));
        veiculos.add(new Moto("Yamaha", "MT-03", 321));

        /*
         * UM ÚNICO LAÇO.
         *
         * Não utilizamos instanceof.
         * O polimorfismo decide automaticamente qual versão
         * dos métodos deve ser executada.
         */
        for (Veiculo veiculo : veiculos) {

            System.out.println("----------------------------");

            // Mesmo comando, comportamento diferente
            veiculo.exibirInfo();
            veiculo.mover();
        }

        System.out.println("----------------------------");

        /*
         * PASSO 3 - AUTOAVALIAÇÃO
         *
         * Critério 1:
         * ATINGIDO - Existe uma superclasse Veiculo e duas
         * subclasses: Carro e Moto. Ambas passam no teste
         * "é um", pois Carro é um Veiculo e Moto é um Veiculo.
         *
         * Critério 2:
         * ATINGIDO - O método abstrato mover() é declarado na
         * superclasse e implementado de forma própria por cada
         * subclasse.
         *
         * Critério 3:
         * ATINGIDO - Os construtores de Carro e Moto chamam
         * super() e acrescentam seus próprios atributos.
         *
         * Critério 4:
         * ATINGIDO - O método exibirInfo() é sobrescrito pelas
         * subclasses e reutiliza a versão herdada através de
         * super.exibirInfo().
         *
         * Critério 5:
         * ATINGIDO - Existe uma coleção List<Veiculo> contendo
         * objetos de Carro e Moto, percorrida por um único laço.
         * Não foi utilizado instanceof ou isinstance.
         *
         * Critério 6:
         * ATINGIDO - O mesmo comando veiculo.mover() produz
         * comportamentos diferentes para Carro e Moto.
         *
         * Trecho que deu mais trabalho:
         * A parte que exigiu mais atenção foi organizar a
         * sobrescrita de exibirInfo() para reutilizar o código
         * da superclasse. Isso foi resolvido utilizando
         * super.exibirInfo().
         *
         * Uso de IA:
         * A IA ajudou a conferir se a estrutura atendia aos
         * critérios de herança e polimorfismo. Foi necessário
         * revisar o código para entender cada parte e garantir
         * que a solução estivesse de acordo com a atividade.
         */
    }
}
```
