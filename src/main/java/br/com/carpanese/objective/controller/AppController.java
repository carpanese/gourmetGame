package br.com.carpanese.objective.controller;

import javax.swing.JOptionPane;

import br.com.carpanese.objective.model.Node;
import br.com.carpanese.objective.utils.Constants;
import br.com.carpanese.objective.view.ConfirmView;
import br.com.carpanese.objective.view.InputView;
import br.com.carpanese.objective.view.MessageView;

/**
 * Classe padrao para execucao das regras
 * @author tiago.carpanese
 *
 */
public class AppController {
	
	Node rootNode;
	Node parentNode;
	boolean isLeft;
	
	public AppController() {
		createDefaultNode();
		init(rootNode);
	}
	
	private void init(Node node) {
		MessageView.showInformationMessage(Constants.Title.TITULO_PRINCIPAL, Constants.Question.PERGUNTA_INICIAL);
		processNode(node);
	}
	
	/**
	 * Metodo responsavel por processar o no e realizar as perguntas para o usuario
	 * @param node no raiz ou recursivo
	 */
	private void processNode(Node node) {
		Integer confirm = ConfirmView.confirmNode(Constants.Title.TITULO_CONFIRMACAO, node);
		switch (confirm) {
		case JOptionPane.YES_OPTION:
			if(null == node.getLeft()) {
				MessageView.showInformationMessage(Constants.Title.TITULO_ACERTEI, Constants.DESCRICAO_ACERTEI);
				init(rootNode);
				break;
			}
			parentNode = node;
			isLeft = true;
			processNode(node.getLeft());
			break;

		case JOptionPane.NO_OPTION:
			if(null != node.getRight()) {
				isLeft = false;
				parentNode = node;
				processNode(node.getRight());
				break;
			}
			userNodeProcess(node);
			break;
		}
	}
	
	/**
	 * Metodo para processamento da decisao do usuario de input
	 * @param node ultimo no para a pergunta de negacao
	 */
	private void userNodeProcess(Node node) {
		Node nodeChild = new Node(InputView.inputNode());
		Node nodeParent = new Node(InputView.inputNodeParent(nodeChild.getDescription(), node.getDescription()));
		nodeParent.add(nodeParent, nodeChild, true);
		nodeParent.add(nodeParent, node, false);
		if(isLeft) {
			parentNode.add(parentNode, nodeParent, true);
		} else {
			parentNode.add(parentNode, nodeParent, false);
		}
		init(rootNode);
	}
	
	/**
	 * Cria o padrao para inicio da aplicacao
	 */
	private void createDefaultNode() {
		parentNode = new Node();
		rootNode = new Node(Constants.PRATO_PADRAO);
		rootNode.add(rootNode, new Node(Constants.PRATO_FILHO_PADRAO), true);
		rootNode.add(rootNode, new Node(Constants.PRATO_PADRAO_BOLO), false);
	}
}
