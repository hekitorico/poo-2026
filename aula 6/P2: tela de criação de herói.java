```java
/*
 * IF Quest - Tela de Criação de Herói
 *
 * Uso de IA:
 * Ferramenta utilizada: ChatGPT (GPT-5.6 Luna)
 * Para quê: auxiliar na criação da interface gráfica e na organização
 * dos componentes utilizando orientação a objetos.
 *
 * Validação manual:
 * - Conferi a herança de JFrame.
 * - Conferi os componentes e o layout.
 * - Testei a abertura da janela.
 * - Conferi os campos e o botão.
 */

import javax.swing.*;
import java.awt.*;

public class TelaCriacaoHeroi extends JFrame {

    private JLabel titulo;
    private JLabel labelNome;
    private JLabel labelVida;
    private JLabel labelClasse;

    private JTextField campoNome;
    private JTextField campoVida;
    private JTextField campoClasse;

    private JButton botaoCriar;

    public TelaCriacaoHeroi() {

        super("IF Quest");

        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

   
        titulo = new JLabel("Criação de Herói", SwingConstants.CENTER);

        labelNome = new JLabel("Nome:");
        labelVida = new JLabel("Vida:");
        labelClasse = new JLabel("Classe:");

        campoNome = new JTextField();
        campoVida = new JTextField();
        campoClasse = new JTextField();

        botaoCriar = new JButton("Criar Herói");

     
        setLayout(new BorderLayout(10, 10));

        // Título no NORTH
        add(titulo, BorderLayout.NORTH);

        // Formulário no CENTER
        JPanel painelFormulario = new JPanel(
                new GridLayout(3, 2, 5, 5)
        );

        painelFormulario.add(labelNome);
        painelFormulario.add(campoNome);

        painelFormulario.add(labelVida);
        painelFormulario.add(campoVida);

        painelFormulario.add(labelClasse);
        painelFormulario.add(campoClasse);

        add(painelFormulario, BorderLayout.CENTER);

       
        add(botaoCriar, BorderLayout.SOUTH);

   
        titulo.setText("Criação de Herói - IF Quest");

     
        System.out.println(
                "Nome inicial do campo: " + campoNome.getText()
        );

  
        botaoCriar.setEnabled(false);


    public static void main(String[] args) {

        TelaCriacaoHeroi tela = new TelaCriacaoHeroi();

        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }
}

