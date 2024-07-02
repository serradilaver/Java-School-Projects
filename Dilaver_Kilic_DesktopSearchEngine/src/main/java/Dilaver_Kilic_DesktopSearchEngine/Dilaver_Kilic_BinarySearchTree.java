/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dilaver_Kilic_DesktopSearchEngine;

/**
 *
 * @author merye
 */
public class Dilaver_Kilic_BinarySearchTree {

    Dilaver_Kilic_NodeBST root;

    public Dilaver_Kilic_BinarySearchTree() {
        root = null;
    }

    public void insert(String key, String fileName) {
        root = insertRec(root, key, fileName);
    }

    Dilaver_Kilic_NodeBST insertRec(Dilaver_Kilic_NodeBST root, String key, String fileName) {
        if (root == null) {
            root = new Dilaver_Kilic_NodeBST(key, fileName);
            return root;
        } else {
            if (key.compareTo(root.key) < 0) {
                root.left = insertRec(root.left, key, fileName);
            } else if (key.compareTo(root.key) > 0) {
                root.right = insertRec(root.right, key, fileName);
            } else if (key.equals(root.key)) {
                if (root.head == null) {
                    root.head = new Dilaver_Kilic_NodeLL(fileName);
                } else {
                    Dilaver_Kilic_NodeLL current = root.head;
                    while (current != null) {
                        if (current.fileName.equals(fileName)) {
                            current.count++;
                            return root;
                        }
                        if (current.next == null) {
                            current.next = new Dilaver_Kilic_NodeLL(fileName);
                            break;
                        }
                        current = current.next;
                    }
                }
            }
            return root;
        }
    }

    public String printInOrder() {
        return printInOrderRec(root);
    }

    public String printPreOrder() {
        return printPreOrderRec(root);
    }

    public String printPostOrder() {
        return printPostOrderRec(root);
    }

    private String printInOrderRec(Dilaver_Kilic_NodeBST node) {
        StringBuilder output = new StringBuilder();
        if (node != null) {
            output.append(printInOrderRec(node.left));
            output.append(node.key).append(": ");
            output.append(printLinkedList(node.head));
            output.append("\n");
            output.append(printInOrderRec(node.right));
        }
        return output.toString();
    }

    private String printPreOrderRec(Dilaver_Kilic_NodeBST node) {
        StringBuilder output = new StringBuilder();
        if (node != null) {
            output.append(node.key).append(": ");
            output.append(printLinkedList(node.head));
            output.append("\n");
            output.append(printPreOrderRec(node.left));
            output.append(printPreOrderRec(node.right));
        }
        return output.toString();
    }

    private String printPostOrderRec(Dilaver_Kilic_NodeBST node) {
        StringBuilder output = new StringBuilder();
        if (node != null) {
            output.append(printPostOrderRec(node.left));
            output.append(printPostOrderRec(node.right));
            output.append(node.key).append(": ");
            output.append(printLinkedList(node.head));
            output.append("\n");
        }
        return output.toString();
    }

    private String printLinkedList(Dilaver_Kilic_NodeLL head) {
        StringBuilder output = new StringBuilder();
        Dilaver_Kilic_NodeLL current = head;
        while (current != null) {
            output.append("\n").append(current.fileName).append("   ").append(current.count).append("\n");
            current = current.next;
        }
        return output.toString();
    }

    String search(String key) {
        return searchRec(root, key);
    }

    private String searchRec(Dilaver_Kilic_NodeBST node, String key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult == 0) {

            StringBuilder output = new StringBuilder();
            output.append(node.key).append(": ");
            output.append(printLinkedList(node.head));
            return output.toString();
        }
        if (compareResult < 0) {
            return searchRec(node.left, key);
        } else {
            return searchRec(node.right, key);

        }
    }
}
