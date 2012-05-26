
package Btree;

import Btree.BinaryTreeExample.Node;

public class BtreeLCA {
	
	 public static void main(String[] args)
	  {
		  new BtreeLCA().run();
	  }


	  public void run() 
	  {
		  
	  }
	  
	  Node findLCA(Node root,Node n1, Node n2 )
	  {
		  
		  if ( root == null)   // stop if empty
			  return null;
		  else if (root.value == n1.value || root.value == n2.value )   // stop and return if any match , anything subsequent can be discarded
			  return root;
		  else
		  {
			  Node t1 = findLCA(root.left,n1,n2);
			  
			  Node t2 = findLCA(root.right,n1,n2);
			  
			  if(t1 !=null && t2 !=null)  // switch on conducting to parent if both are present
				  return root;
			  else if (t1 !=null)
				  return t1;
			  else       // This return null to top element
				  return t2;
		  }
		  
	  }
}

//TODO:BFS example
