import java.util.ArrayList;

/**
 * This class represents an entire minimax game tree
 * containing a node for each possible state from the
 * given starting state.
 *
 * @author Biao Zhang
 * @version 07/28/2020
 */
public class GameTree {

    /**
     * All attributes.
     */
    private Node root;
    private int size;

    /**
     * The constructor for GameTree.
     *
     * @param start State the initial state.
     */
    public GameTree(State start) {
        size = 0;
        root = buildTree(start, null);
    }

    /**
     * Returns the root of this tree.
     *
     * @return Node the root.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Builds a node and its subtree from a given state.
     *
     * @param state the initial state.
     * @param move the move led to the state.
     * @return Node the tree.
     */
    public Node buildTree(State state, State.Move move) {
        Node newnode = new Node(move);
        size++;

        if (state.gameOver()) {
            //Since it's end game,
            //the best child remains null.
            if (state.getValue() == 1) {
                newnode.val = 1;
            } else if (state.getValue() == -1) {
                newnode.val = -1;
            } else {
                newnode.val = 0;
            }
        } else {

            for (State.Move m : state.findAllMoves()) {
                if (state.doMove(m)) {
                    Node newchild = buildTree(state, m);
                    newnode.children.add(newchild);
                    state.undoMove(m);
                }
            }

            //Find max of all children's values
            //Find min of all children's values
            int i = 0;
            int max = 0;
            int min = 0;
            Node maxchild = newnode;
            Node minchild = newnode;
            for (Node child : newnode.children) {
                if (i == 0) {
                    max = child.val;
                    min = child.val;
                    maxchild = child;
                    minchild = child;
                } else {
                    if (child.val > max) {
                        max = child.val;
                        maxchild = child;
                    }

                    if (child.val < min) {
                        min = child.val;
                        minchild = child;
                    }
                }
                i++;
            }

            if (!state.isPlayerTurn()) {
                newnode.val = max;
                newnode.bestchild = maxchild;
            } else {
                newnode.val = min;
                newnode.bestchild = minchild;
            }
        }

        return newnode;
    }

    /**
     * Returns the total number of nodes in the tree.
     *
     * @return int the size of the tree.
     */
    public int getSize() {
        return size;
    }

    /**
     * This class represents a node in the minimax game tree.
     */
    public class Node {

        /**
         * All attributes.
         */
        private int val;
        private ArrayList<Node> children;
        private Node bestchild;
        private State.Move currmove;

        /**
         * The constructor for Node.
         *
         * @param m State.Move the move to this state.
         */
        public Node(State.Move m) {
            currmove = m;
            val = 0;
            children = new ArrayList<Node>();
            // Best child remain null.
        }

        /**
         * Returns the minimax value for this node.
         *
         * @return int the value of this node.
         */
        public int getValue() {
            return val;
        }

        /**
         * Get the move that led to this node.
         *
         * @return State.Move the move to this tate.
         */
        public State.Move getMove() {
            return currmove;
        }

        /**
         * Get the node's best child.
         *
         * @return Node This will be the child that gave this node its value.
         */
        public Node getBestChild() {
            return bestchild;
        }

        /**
         * Find the child whose move matches the parameter.
         *
         * @param m State.Move the move to this state.
         * @return Node the matched child.
         */
        public Node findChild(State.Move m) {
            for (Node child : children) {
                if (child.currmove.equals(m)) {
                    return child;
                }
            }

            return null;
        }

        /**
         * Get the predicted winner for this subtree.
         *
         * @return String the winner.
         */
        public String getPrediction() {
            String ret = "";

            if (bestchild == null) {
                ret = "no one";
                return ret;
            }

            if (bestchild.getValue() == -1) {
                ret = "player";
            } else if (bestchild.getValue() == 1) {
                ret = "computer";
            } else if (bestchild.getValue() == 0) {
                ret = "no one";
            }

            return ret;
        }

    }
}
