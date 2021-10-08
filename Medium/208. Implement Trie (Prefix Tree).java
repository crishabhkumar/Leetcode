/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
*/

//Solution
class Trie {
     class Node{
            Node [] childs;
            boolean isEnd;
            
            Node(){
                childs = new Node[26];
                isEnd = false;
            }
     }
    final private Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node current = root;
        
        for(int i = 0; i < word.length();i++){
            char ch = word.charAt(i);
            
            if(current.childs[ch - 'a'] == null){
                current.childs[ch - 'a'] = new Node();
            }
            current = current.childs[ch - 'a'];
        }
        current.isEnd = true;
        
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            
            if(curr.childs[ch - 'a'] == null) return false;
            curr = curr.childs[ch - 'a'];
        }
        return curr.isEnd;
        
        
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(int i = 0;i<prefix.length();i++){
            char ch = prefix.charAt(i);
            
            if(curr.childs[ch - 'a'] == null) return false;
            curr = curr.childs[ch - 'a'];
        }
        
        return true;
    
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
 




