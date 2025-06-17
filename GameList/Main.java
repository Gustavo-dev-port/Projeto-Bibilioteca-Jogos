package gamelist;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância da tela de cadastro
        TelaCadastro telaCadastro = new TelaCadastro();
        
        // Define a visibilidade da tela
        telaCadastro.setVisible(true);
        
        // Configura o comportamento de fechamento da janela
        telaCadastro.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
}