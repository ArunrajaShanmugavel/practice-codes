package Btree;

public class BinaryTreeExample 
{

	  public static void main(String[] args)
	  {
		  new BinaryTreeExample().run();
	  }

	  static class Node 
	  {
		  Node left;
		  Node right;
		  int value;
	
		  public Node(int value) 
		  {
			  this.value = value;
		  }
	  }

	  public void run() 
	  {
		  Node rootnode = new Node(25);
		  System.out.println("Building tree with rootvalue " + rootnode.value);
		  System.out.println("=================================");
		  insert(rootnode, 11);
		  insert(rootnode, 9);
		  insert(rootnode, 15);
		  insert(rootnode, 16);
		  insert(rootnode, 23);
		  insert(rootnode, 79);
		  System.out.println("Traversing tree in order");
		  System.out.println("=================================");
		  printInOrder(rootnode);
		  
		  System.out.println("Least Common Ancestor is "+new BtreeLCA().findLCA(rootnode, new Node(9),  new Node(15)).value);

		  //TODO: Find LCA with BTree instead of BST
	  }

	  public void insert(Node node, int value) 
	  {
		  if (value < node.value) 
		  {
			  if (node.left != null) 
			  {
				  insert(node.left, value);
			  } 
			  else 
			  {
				  System.out.println("  Inserted " + value + " to left of node " + node.value);
				  node.left = new Node(value);
			  }
		  } 
		  else if (value > node.value) 
		  {
			  if (node.right != null) 
			  {
				  insert(node.right, value);
			  } 
			  else 
			  {
				  System.out.println("  Inserted " + value + " to right of node " + node.value);
				  node.right = new Node(value);
			  }
		  }
	  }

	  public void printInOrder(Node node) 
	  {
		  if (node != null) 
		  {
			  printInOrder(node.left);
			  System.out.println("  Traversed " + node.value);
			  printInOrder(node.right);
		  }
	  }
	}
