import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public interface Interface {
    void lerAletatorio();

    ArrayList<Character> InicializarEstado(String palavra);

    void exibirEstado(ArrayList<Character> estado);

    String getErrosArte(int erros);

    boolean processarTentativa(String palavra, ArrayList<Character> estado, char letra);

    boolean processarLetra(char letra);

    String getPalavraFormatada();

    int getErros();

    int getAcertos();

    boolean venceu();

    boolean perdeu();

    String getPalavraCorreta();

    void Jogo(String palavra);
}
