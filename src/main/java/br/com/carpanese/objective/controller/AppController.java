package br.com.carpanese.objective.controller;

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
		boolean confirm = ConfirmView.confirmNode(Constants.Title.TITULO_CONFIRMACAO, node);
		if (confirm && null != node.getLeft()) {
			processNode(node.getLeft());
		} else if (confirm) {
			MessageView.showInformationMessage(Constants.Title.TITULO_ACERTEI, Constants.DESCRICAO_ACERTEI);
			createDefaultNode();
			init(rootNode);
		} else {
			if (null != node.getRight()) {
				processNode(node.getRight());
			} else {
				userNodeProcess(node);
			}
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
		processTreeAddNode(rootNode, nodeParent);
		init(rootNode);
	}
	
	/**
	 * Percorre a arvore para adicionar antes do ultimo no (Bolo)
	 * @param root root recursivo
	 * @param newNode No criado pelo usuario
	 */
	private void processTreeAddNode(Node root, Node newNode) {
		if(null == root.getRight().getRight()) {
			newNode.add(newNode, root.getRight(), false);
			root.add(root, newNode, false);
		} else {
			processTreeAddNode(root.getRight(), newNode);
		}
	}
	
	/**
	 * Cria o padrao para inicio da aplicacao
	 */
	private void createDefaultNode() {
		rootNode = new Node(Constants.PRATO_PADRAO);
		rootNode.add(rootNode, new Node(Constants.PRATO_FILHO_PADRAO), true);
		rootNode.add(rootNode, new Node(Constants.PRATO_PADRAO_BOLO), false);
	}
}
