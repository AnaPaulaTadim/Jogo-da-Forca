import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Jogador {
    String apelido;
    int pontuacao;
    Set<String> palavrasJogadas;

    public Jogador(String apelido) {
        this.apelido = apelido;
        this.pontuacao = 0;
        this.palavrasJogadas = new HashSet<>();
    }

    @Override
    public String toString() {
        return apelido;
    }
}
