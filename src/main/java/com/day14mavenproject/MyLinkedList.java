package com.day14mavenproject;

public class MyLinkedList<K> {
	public INode head;
	public INode tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(INode newNode) {
		if (this.tail == null) {
			this.tail = newNode;
		}
		if (this.head == null) {
			this.head = newNode;
		} else {
			INode tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}

	public void append(INode myNode) {
		if (this.head == null) {
			this.head = myNode;
		}
		if (this.tail == null) {
			this.tail = myNode;
		} else {
			this.tail.setNext(myNode);
			this.tail = myNode;
		}
	}

	/* This method is used to insert the element in between two nodes */
	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	/* This method is used for deleting the first node */
	public void popFirst() {
		if (head != null)
			this.head = head.getNext();
	}

	/* Method is used for deleting the last node */
	public void popLast() {
		INode tempNode = head;
		while (tempNode.getNext() != tail) {
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(null);
		tail = tempNode;
	}
	
	public INode<K> searchElement(K key)
    {
        INode<K> tempNode =head;
        while (tempNode!=null&&tempNode.getNext()!=null)
        {
            if (tempNode.getKey().equals(key))
            {
                return tempNode;
            }
            tempNode=tempNode.getNext();
        }
        return null;
	}

	public void printMyNodes() {
		StringBuilder myNodes = new StringBuilder("My Nodes : ");
		INode tempNode = head;
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(tail))
				myNodes.append("->");
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}
}
