package br.com.carpanese.objective.model;

/**
 * Classe de nos para arvore
 * @author tiago.carpanese
 *
 */
public class Node {
	
	private String description;
    private Node left;
    private Node right;

    public Node (String description) {
        this.description = description;
        right = null;
        left = null;
    }
    
    public Node () {
    	//DEFAULT CONSTRUCTOR
    }
    
    /**
     * Adiciona um novo no na arvore
     * @param parent pai onde sera adicionado o novo no
     * @param child no a ser adicionado
     * @param left boleano para adicinar na esquerda ou direita
     */
    public void add(Node parent, Node child, Boolean left) {
        if (left) {
           parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right ) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

}
