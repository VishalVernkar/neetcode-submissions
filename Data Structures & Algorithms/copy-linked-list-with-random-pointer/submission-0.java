/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        Node copy = new Node(0);
        Node res = copy;
        while(curr != null){
            if(map.containsKey(curr)){
                copy.next = map.get(curr);
            } else {
                Node currCopy = new Node(curr.val);
                map.put(curr, currCopy);
                copy.next = currCopy;
            }

            Node currRndm = curr.random;
            if(currRndm != null){
                Node currCopy = map.get(curr);
                if(map.containsKey(currRndm)){
                    currCopy.random = map.get(currRndm);
                } else {
                    Node copyRandom = new Node(currRndm.val);
                    map.put(currRndm, copyRandom);
                    currCopy.random = copyRandom;
                }
            }
            copy = copy.next;
            curr = curr.next;
        }

        return res.next;
    }

}

// 12:45 - 13:05
// what does deep copy mean here?
// 
// the problem is while doing deep copy
// for random node -> i need a reference of the copy node

// if traverse from head
// i can create a next node and attach to head
// but I cannot creat a random new node becaue in the copy node it does not exist yet

// brute force
// 
// it'd be easy if the node pointed to any previous node -> hashmap would've helped
// but it is also pointing to future node
//

// Brute force
// actually can I use hash map here?
// map -> original node -> copied node
// if the node already exists we take it and store it here in random

// what if it not yes exists?
// i.e - it is pointing to future node
// may be use other hashmap?
// map orignal random to -> create a copy of random node
// now I have to use copy of random node in future -> how to do it?
// check if curr node has this and get copy attach it

// how to make it to one hashmap?

// 1st -> orginal nodes -> copy of it
// 2nd -> orginal random -> copy of it

// okay in one hash map add every original -> to copy
// check if the current node already exist -> then take its copy and attach it
// if orginal not exist -> create one -> add to map
// if random original does not exisst -> create one -> add to map


// solve later
// I have node
// I have a random in it
// if i have copy of this node i take it from map
// else create a copy and add to map
// for this copy i need to attach a random 
// if its copy exists, then i add it directly here
// else i need to check in hash map if its copy exists thn add it.

// another issue is I have to update
// next is fine
// what about next for random
// I feel it should work as I take the copy and update it lets see
// yes, it worked