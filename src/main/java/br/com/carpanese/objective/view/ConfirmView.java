package br.com.carpanese.objective.view;

import java.text.MessageFormat;

import javax.swing.JOptionPane;

import br.com.carpanese.objective.model.Node;
import br.com.carpanese.objective.utils.Constants;

/**
 * Classe para a exibicao das confirmacoes
 * @author tiago.carpanese
 *
 */
public class ConfirmView {
	
	/**
	 * Retorna a opcao escolhida como true (sim) false (nao)
	 * @param titulo titulo da janela
	 * @param node no
	 * @return true ou false de acordo com o escolhido
	 */
	public static Integer confirmNode(String titulo, Node node) {
		return JOptionPane.showConfirmDialog(null, 
				MessageFormat.format(Constants.Question.PERGUNTA_ESCOLHA_INI, node.getDescription()), 
				titulo,
				JOptionPane.YES_NO_OPTION);
	}
}
