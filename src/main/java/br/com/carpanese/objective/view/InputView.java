package br.com.carpanese.objective.view;

import java.text.MessageFormat;

import javax.swing.JOptionPane;

import br.com.carpanese.objective.utils.Constants;

/**
 * View para inputs do usuario
 * @author tiago.carpanese
 *
 */
public class InputView {
	
	/**
	 * Input do prato filho
	 * @return retorna o nome do prato digitado
	 */
	public static String inputNode() {
		return InputView.showInputUserNode(Constants.Title.TITULO_DESISTO, Constants.Question.QUAL_PRATO_PENSOU);
	}
	
	/**
	 * Input do prato de negacao com formatacao da mensagem
	 * @param pratoAnterior prato anterior escolhido pelo usuario
	 * @param pratoAtual prato digitado pelo usuario (filho)
	 * @return o prato da negacao que sera no parent na arvore
	 */
	public static String inputNodeParent(String pratoAnterior, String pratoAtual) {
		return InputView.showInputUserNode(Constants.Title.TITULO_DESISTO, 
				MessageFormat.format(Constants.Question.PRATO_PENSOU_NEGACAO_1, pratoAnterior, pratoAtual));
	}
	
	/**
	 * Metodo padrao para exibicao do panel
	 * @param titulo titulo da janela
	 * @param mensagem mensagem
	 * @return String digitada pelo usuario
	 */
	private static String showInputUserNode(String titulo, String mensagem) {
		return JOptionPane.showInputDialog(
                null,
                mensagem, 
                titulo,
                JOptionPane.QUESTION_MESSAGE
        );
	}
}
