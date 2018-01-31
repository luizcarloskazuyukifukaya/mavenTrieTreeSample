/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.ilovediitalmeister.maventrietreesample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author kazuyuf
 */
public class Trie {
    private final TrieNode root;
    ArrayList<String> words; 
    TrieNode prefixRoot;
    String curPrefix;

    public Trie()
    {
        root = new TrieNode();
        words  = new ArrayList<>();
    }    
    // Inserts a word into the trie.
    public void insert(String word) 
    {
        HashMap<Character, TrieNode> children = root.children;

        TrieNode crntparent;

        crntparent = root;

        //cur children parent = root

        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i);

            TrieNode t;
            if(children.containsKey(c)){ t = children.get(c);}
            else
            {
            t = new TrieNode(c);
            t.parent = crntparent;
            children.put(c, t);
            }

            children = t.children;
            crntparent = t;

            //set leaf node
            if(i==word.length()-1)
                t.isLeaf = true;    
        }
    }
    // Returns if the word is in the trie.
    public boolean search(String word)
    {
        TrieNode t = searchNode(word);
        return t != null && t.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) 
    {
        return searchNode(prefix) != null;
    }
    public TrieNode searchNode(String str)
    {
        Map<Character, TrieNode> children = root.children; 
        TrieNode t = null;
        for(int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            if(children.containsKey(c))
            {
                t = children.get(c);
                children = t.children;
            }
            else{return null;}
        }

        prefixRoot = t;
        curPrefix = str;
        words.clear();
        return t;
    }
  void wordsFinderTraversal(TrieNode node, int offset) 
  {
        //print(node, offset);
        //System.out.println("wordsFinderTraversal >>> IN");
        if(node.isLeaf==true)
        {
          //System.out.println("leaf node found");

          TrieNode altair;
          altair = node;

          Stack<String> hstack = new Stack<>(); 

          while(altair != prefixRoot)
          {
            //System.out.println(altair.c);
            hstack.push( Character.toString(altair.c) );
            altair = altair.parent;
          }

          String wrd = curPrefix;
          while(hstack.empty()==false)
          {
            wrd = wrd + hstack.pop();
          }

          //System.out.println(wrd);
          words.add(wrd);

        }

         Set<Character> kset = node.children.keySet();
         //System.out.println(node.c); System.out.println(node.isLeaf);System.out.println(kset);
         Iterator itr = kset.iterator();
         ArrayList<Character> aloc = new ArrayList<>();

        while(itr.hasNext())
        {
         Character ch = (Character)itr.next();  
         aloc.add(ch);
         //System.out.println(ch);
        } 
        // here you can play with the order of the children

        for( int i=0;i<aloc.size();i++)
        {
         wordsFinderTraversal(node.children.get(aloc.get(i)), offset + 2);
        } 
        //System.out.println("wordsFinderTraversal <<< OUT");

    }
  
    /**
     * This will simply display all words in the tree.
     */
    void displayFoundWords()
    {
        System.out.println("_______________");
        for(int i=0;i<words.size();i++)
        {
            System.out.println(words.get(i));
        } 
        System.out.println("________________");
    }

    /**
     * This will display all words (a part of) to the depth specified by the parameter.
     * @param depth is the parameter to specify how deep in the tree words are to be searched. 
     */
    void displayFoundWords(int depth)
    {
        if (depth > 0) {
            ArrayList<String> foundWords = getAllWords(depth);
            for(int i=0;i<foundWords.size();i++) {
                System.out.println(foundWords.get(i));                            
            }
        } 
    }

    /**
     * This will get all words (a part of) to the depth specified by the parameter.
     * @param depth is the parameter to specify how deep in the tree words are to be searched. 
     * @return return all words on the specified depth level.
     */
    public ArrayList<String> getAllWords(int depth)
    {
        final ArrayList<String> shortWords;
        shortWords = new ArrayList<>(); 
        System.out.println("displayFoundWords called depth=" + depth);
        System.out.println("_______________");
        for(int i=0;i<words.size();i++)
        {
            String shortWord = words.get(i).substring(0, Math.min(words.get(i).length(), depth));
            //System.out.println(shortWord);
            if(shortWords.isEmpty()) {
                shortWords.add(shortWord);
            } else {
                if(!shortWords.contains(shortWord)) {
                    shortWords.add(shortWord);
                }
            }
        } 
        for(int j=0; j<shortWords.size(); j++) {
            System.out.println(shortWords.get(j));            
        }
        System.out.println("________________");

        return shortWords;
    }

    /**
     * This will simply display all words in the tree.
     * @return all words in the tree.
     */
    public ArrayList<String> getAllWords()
    {
        return words;
    }
    
}
