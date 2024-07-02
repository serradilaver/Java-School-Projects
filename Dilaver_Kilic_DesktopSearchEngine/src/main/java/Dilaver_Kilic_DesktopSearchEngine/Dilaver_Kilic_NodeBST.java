/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dilaver_Kilic_DesktopSearchEngine;

/**
 *
 * @author merye
 */
public class Dilaver_Kilic_NodeBST {

    String key;
    Dilaver_Kilic_NodeLL head;
    Dilaver_Kilic_NodeBST left;
    Dilaver_Kilic_NodeBST right;

    public Dilaver_Kilic_NodeBST(String key, String fileName) {
        this.key = key;
        head = new Dilaver_Kilic_NodeLL(fileName);
        left = right = null;
    }
}
