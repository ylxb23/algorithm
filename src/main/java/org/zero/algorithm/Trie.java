package org.zero.algorithm;

public class Trie {

    /**
     * 字典树
     * @param args
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
    Node zero;

    /** Initialize your data structure here. */
    public Trie() {
        zero = new Node('a');   // 随便一个值，仅作根节点用
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.isEmpty()) {
            return;
        }
        Node idx = zero;
        char curr;
        for(int i=0; i<word.length(); i++) {
            curr = word.charAt(i);
            int currIdx = curr - 'a';
            if(idx.next[currIdx] == null) {
                idx.next[currIdx] = new Node(curr);
                idx = idx.next[currIdx];
            } else {
                idx = idx.next[currIdx];
            }
        }
        idx.setIsLeaf(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.isEmpty()) {
            return false;
        }
        Node idx = zero;
        char curr;
        for(int i=0; i<word.length(); i++) {
            curr = word.charAt(i);
            int currIdx = curr - 'a';
            if(idx.next[currIdx] == null) {
                return false;
            } else {
                idx = idx.next[currIdx];
            }
        }
        return idx.isLeaf();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.isEmpty()) {
            return false;
        }
        Node idx = zero;
        char curr;
        for(int i=0; i<prefix.length(); i++) {
            curr = prefix.charAt(i);
            int currIdx = curr - 'a';
            if(idx.next[currIdx] == null) {
                return false;
            } else {
                idx = idx.next[currIdx];
            }
        }
        return true;
    }

    static class Node {
        char c;
        Node[] next;
        boolean isLeaf;
        public Node(char c) {
            this.c = c;
            this.next = new Node[26];   // 26个字母
        }

        public Node next(char n) {
            int i = n - 'a';
            if(i < 0 || i >= 26) {
                return null;
            }
            return this.next[i];
        }

        public void setIsLeaf(boolean isLeaf) {
            this.isLeaf = isLeaf;
        }

        public boolean isLeaf() {
            return this.isLeaf;
        }
    }
}

