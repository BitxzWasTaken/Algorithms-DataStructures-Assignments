public class UndoRedoTest {
    public static void main(String[] args) {
        UndoRedo<Integer> node = new UndoRedo<>();

        node.addState(1);
        node.addState(2);
        node.addState(3);
        node.printStates(); // print 1 2 [3]

        node.undo(); // goes back to 2
        node.printStates(); // 1 [2] 3

        node.undo(); // back to 1
        node.printStates(); // [1] 2 3

        node.redo(); // back to 2
        node.printStates(); // 1 [2] 3

        node.addState(4); // adds 4, removes 3
        node.printStates(); // 1 2 [4]

        System.out.println("Current State: " + node.getCurrentState());
    }
}

