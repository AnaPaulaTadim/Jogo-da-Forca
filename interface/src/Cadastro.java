import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


// Classe principal com tela de Login
public class Cadastro extends JFrame {

    private JComboBox<Jogador> listaJogadores;
    private JTextField txtNovoJogador;
    private JButton btnCadastrar, btnEntrar;
    private Map<String, Jogador> jogadores;

    public Cadastro() {
        jogadores = new HashMap<>();
        configurarTela();
    }

    private void configurarTela() {
        setTitle("Cadastro e Login de Jogadores");
        setSize(400, 200);
        setLayout(new BorderLayout(10,10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel Cadastro
        JPanel painelCadastro = new JPanel(new FlowLayout());
        txtNovoJogador = new JTextField(15);
        btnCadastrar = new JButton("Cadastrar");
        painelCadastro.add(new JLabel("Novo Jogador:"));
        painelCadastro.add(txtNovoJogador);
        painelCadastro.add(btnCadastrar);

        // Painel Login
        JPanel painelLogin = new JPanel(new FlowLayout());
        listaJogadores = new JComboBox<>();
        btnEntrar = new JButton("Entrar");
        painelLogin.add(new JLabel("Selecionar Jogador:"));
        painelLogin.add(listaJogadores);
        painelLogin.add(btnEntrar);

        add(painelCadastro, BorderLayout.NORTH);
        add(painelLogin, BorderLayout.SOUTH);

        btnCadastrar.addActionListener(e -> cadastrarJogador());
        btnEntrar.addActionListener(e -> entrarJogo());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cadastrarJogador() {
        String apelido = txtNovoJogador.getText().trim();
        if (!apelido.isEmpty() && !jogadores.containsKey(apelido)) {
            Jogador novoJogador = new Jogador(apelido);
            jogadores.put(apelido, novoJogador);
            listaJogadores.addItem(novoJogador);
            txtNovoJogador.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Jogador já existe ou inválido.");
        }
    }

    private void entrarJogo() {
        Jogador selecionado = (Jogador) listaJogadores.getSelectedItem();
        if (selecionado != null) {
            //  inicia o jogo com o jogador selecionado
            JOptionPane.showMessageDialog(this, "Jogador: " + selecionado.apelido + "\nPontuação: " + selecionado.pontuacao);
            
            //ATUALIZA A PONTUAÇÃO CONFORME O JOGO O AVANÇA
        } else {
            JOptionPane.showMessageDialog(this, "Selecione ou cadastre um jogador!");
        }
    }
}