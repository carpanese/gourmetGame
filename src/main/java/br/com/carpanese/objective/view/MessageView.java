package br.com.carpanese.objective.view;

import javax.swing.JOptionPane;

/**
 * Classe para exibicao das mensagens
 * @author tiago.carpanese
 *
 */
public class MessageView {
	
	/**
	 * Exibe a mensagem de informacao para o usuario
	 * @param titulo titulo da mensagem
	 * @param mensagem mensagem
	 */
	public static void showMessageInformacao(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(
                null,
                mensagem, 
                titulo,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
