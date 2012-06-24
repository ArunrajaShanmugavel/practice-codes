package Btree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

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
		  insertBST(rootnode, 11);
		  insertBST(rootnode, 9);
		  insertBST(rootnode, 15);
		  insertBST(rootnode, 16);
		  insertBST(rootnode, 23);
		  insertBST(rootnode, 79);

		  //System.out.print("\nInfix traversal-");infix(rootnode);
		  //System.out.print("\nLeastCommonAncestor-"+new BtreeLCA().findLCA(rootnode, new Node(9),  new Node(15)).value);
		  
		  System.out.print("\nBFS-");bfs(rootnode);
		  System.out.print("\nDFS-"); dfs(rootnode);
		 /* System.out.print("\nDFS with recursion-"); dfsRec(rootnode);  // postfix is same
		  
		  System.out.println("\nInserting on BTree-"); bfs(insert(rootnode,77));
		  System.out.println("\nInserting on BTree-"); bfs(insertChg(rootnode,77));*/

	  }
	  
	  public Node insert(Node node, int value)
	  {
		  if(node==null)
			  return new Node(value);
		  else 
		  {
			  if(node.left==null)  // Check is req to avoid duplicate insertion
			  {
				  System.out.println("Lnull-"+node.value);
				  node.left = insert(node.left,value);
			  }
			  else
			  {
				  System.out.println("!Lnull-"+node.value);
				  node.right = insert(node.right,value);
			  }
			  return node;
		  }
	  }
	  
	  public Node insertChg(Node node, int value)
	  {
		  if(node==null)
			  return new Node(value);
		  else 
		  {
			  if(node.right==null)
			  {
				  System.out.println("Rnull-"+node.value);
				  node.right = insertChg(node.right,value);
			  }
			  else
			  {
				  System.out.println("!Rnull-"+node.value);
				  node.left = insertChg(node.left,value);
			  }
			  return node;
		  }
	  }

	  public void insertBST(Node node, int value) 
	  {
		  if (value < node.value) 
		  {
			  if (node.left != null) 
			  {
				  insertBST(node.left, value);
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
				  insertBST(node.right, value);
			  } 
			  else 
			  {
				  System.out.println("  Inserted " + value + " to right of node " + node.value);
				  node.right = new Node(value);
			  }
		  }
	  }

	  public void infix(Node node) 
	  {
		  if (node != null) 
		  {
			  infix(node.left);
			  System.out.print(" " + node.value);
			  infix(node.right);
		  }
	  }
	  
	  public void bfs(Node rt)
	  {
		  Queue<Node> q = new ArrayDeque<Node>();
		  
		  if(rt != null) q.add(rt);
		  
		  while(!q.isEmpty())
		  {
			  Node tNode = q.remove();
			  
			  System.out.print(tNode.value+" ");
			  
			  if(tNode.left!=null)
				  q.add(tNode.left);
			  
			  if(tNode.right!=null)
				  q.add(tNode.right);
		  }
		  
	  }
	  
	  public void dfs(Node rt)
	  {
		  Stack<Node> s = new Stack<Node>();
		  
		  if(rt != null) s.add(rt);
		  
		  while(!s.isEmpty())
		  {
			  Node tNode = s.pop();
			  
			  System.out.print(tNode.value+" ");
			  
			  if(tNode.right!=null)
				  s.add(tNode.right);
			  
			  if(tNode.left!=null)
				  s.add(tNode.left);
		  }
	  }
	  
	  public void bfsRec(Node rt)
	  {
		  // recursion provides stack which is quiet opposite in property to stack
	  }
	  
	  public void dfsRec(Node rt)  //prefix traversal & DFS seems same
	  {
		  if(rt == null)
			  return;
		  else
		  {
			  System.out.print(rt.value+" ");
			  dfsRec(rt.left);
			  dfsRec(rt.right);
		  }
	  }
	}
