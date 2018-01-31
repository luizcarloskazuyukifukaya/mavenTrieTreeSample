/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.ilovediitalmeister.maventrietreesample;

/**
 *
 * @author kazuyuf
 */
public class TrieTreeSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trie prefixTree;

        prefixTree = new Trie();  

        prefixTree.insert("GOING");
        prefixTree.insert("GONG");
        prefixTree.insert("PAKISTAN");
        prefixTree.insert("SHANGHAI");
        prefixTree.insert("GONDAL");
        prefixTree.insert("GODAY");
        prefixTree.insert("GODZILLA");

        if( prefixTree.startsWith("GO")==true)
        {
          TrieNode tn = prefixTree.searchNode("GO");
          prefixTree.wordsFinderTraversal(tn,0);
          prefixTree.displayFoundWords();
          prefixTree.displayFoundWords(1);
          prefixTree.displayFoundWords(2);          
          prefixTree.displayFoundWords(3);          
          prefixTree.displayFoundWords(4);          
          prefixTree.displayFoundWords(5);          
        }

        if( prefixTree.startsWith("GOD")==true)
        {
          TrieNode tn = prefixTree.searchNode("GOD");
          prefixTree.wordsFinderTraversal(tn,0);
          prefixTree.displayFoundWords(); 
          prefixTree.displayFoundWords(1);
          prefixTree.displayFoundWords(2);          
          prefixTree.displayFoundWords(3);          
          prefixTree.displayFoundWords(4);          
          prefixTree.displayFoundWords(5);          
        }        
    }    
}
