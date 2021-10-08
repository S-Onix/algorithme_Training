package data_structure.tree_ex;

public class Tree_ex {

    /**
     * 트리의 시작지점을 나타내야한다.
     */
    Node head = null;

    public class Node {
        Node left;
        Node right;
        Integer value;

        public Node(Integer value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 트리를 등록시켜줘야하는데
     * 1. 아직 트리에 노드가 없는경우
     * - 등록되는 노드가 head가 된다.
     * 2. 트리에 노드가 있는 경우
     * - 등록될 노드의 값에 따라 넣어줄 위치를 지정해준다.
     */
    public boolean insert(Integer data) {
        if (this.head == null) {
            this.head = new Node(data);
            return true;
        } else {
            Node searchNode = this.head;
            while (true) {
                if (searchNode.value >= data) {
                    if (searchNode.left != null) {
                        searchNode = searchNode.left;
                    } else {
                        searchNode.left = new Node(data);
                        break;
                    }
                } else {
                    if (searchNode.right != null) {
                        searchNode = searchNode.right;
                    } else {
                        searchNode.right = new Node(data);
                        break;
                    }
                }
            }
            return true;
        }
    }

    /**
     * 특정 노드를 찾는법
     * 전제조건 : 트리에 노드가 있는가 없는가
     * <p>
     * 1. 찾고자 하는 노드가 있을경우
     * 해당 노드 리턴
     * 2. 찾고자 하는 노드가 없을 경우
     * null 리턴
     */

    public Node searchNode(Integer data) {
        if (this.head == null) {
            return null;
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (findNode.value > data) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    /**
     * 트리에 노드가 없는 경우
     * 트리에 노드가 있는 경우
     * 제거하고자 하는 노드의 자식이 있는 경우
     *  - 자식 노드가 하나인 경우
     *      - 자식 노드를 제거하고자 하는 노드의 위치로 끌어올린다.
     *  - 자식 노드가 두개인 경우
     *       - 제거하고자하는 노드의 오른쪽 자식 트리 중 가장 작은 값을 제거하고자하는 노드의 위치로 끌어 올린다
     *          >> 루트의 오른쪽 트리의 가작 작은 값은 왼쪽 트리의 값들 보다 큼 따라서 이진트리의 법칙이 성립됨
     * 제거하고자 하는 노드의 자식이 없는 경우
     *  - 해당 노드를 삭제한다(부모의 관계를 끊어준다. >> 이후 할일을 gc가 해줌)
     */
    public boolean delete(Integer data) {
        if (this.head == null) {
            return false;
        } else {
            Node parentNode = this.head;
            Node searchNode = this.head;

            /**
             * 간과하지 말아야할 코너 케이스
             * 노드가 한개만 존재하는 경우 (head인 경우)
             * */
            if(this.head.value == data && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            /**
             * 제거하고자하는 노드의 위치를 찾아준다.
             * */
            while (searchNode != null) {
                if (searchNode.value == data) {
                    break;
                } else if (searchNode.value > data) {
                    parentNode = searchNode;
                    searchNode = searchNode.left;
                } else {
                    parentNode = searchNode;
                    searchNode = searchNode.right;
                }
            }

            if (searchNode == null) {
                return false;
            } else {
                /**
                 * 1. 자식 노드가 없는 경우
                 * 2. 자식 노드가 하나인 경우
                 * 3. 자식 노드가 두개인 경우
                 * */
                if(searchNode.left == null && searchNode.right == null) {
                    if(parentNode.value >= data) {
                        parentNode.left = null;
                    }else {
                        parentNode.right = null;
                    }
                    searchNode = null;
                } else if(searchNode.left == null && searchNode.right != null){
                    if(parentNode.value >= data) {
                        parentNode.left = searchNode.right;
                    }else {
                        parentNode.right = searchNode.right;
                    }
                    searchNode = null;
                }else if (searchNode.left != null && searchNode.right == null) {
                    if(parentNode.value >= data) {
                        parentNode.left = searchNode.left;
                    }else {
                        parentNode.right = searchNode.left;
                    }
                    searchNode = null;
                }else {
                    /**
                     * 오른쪽트리의 순회 작업이 필요하다.
                     * 그렇다면 오른쪽 트리의 부모 / saerch 노드를 변수로 둬야한다.
                     * */
                    Node deleteChildParentNode = searchNode.right;
                    Node deleteChildSearchNode = searchNode.right;

                    while(deleteChildSearchNode.left != null) {
                        deleteChildParentNode = deleteChildSearchNode;
                        deleteChildSearchNode = deleteChildSearchNode.left;
                    }

                    if(deleteChildSearchNode.right != null) {
                        deleteChildParentNode.left = deleteChildSearchNode.right;
                    }else {
                        deleteChildParentNode.left = null;
                    }

                    if(parentNode.value >= data) {
                        /**
                         * 1. 삭제하고자할 노드의 부모와 이어준다.
                         * 2. 삭제하고자할 노드의 두 자식을 이어준다.
                         * */
                        parentNode.left = deleteChildSearchNode;
                        deleteChildSearchNode.left = searchNode.left;
                        deleteChildSearchNode.right = searchNode.right;
                        searchNode = null;

                    }else {
                        parentNode.right = deleteChildSearchNode;
                        deleteChildSearchNode.left = searchNode.left;
                        deleteChildSearchNode.right = searchNode.right;
                        searchNode = null;
                    }

                }

                return true;
            }
        }
    }

    public static void main(String[] args) {
        // Case3-1: 삭제할 Node가 Child Node를 두 개 가지고 있을 경우
        Tree_ex myTree = new Tree_ex();
        myTree.insert(10);
        myTree.insert(15);
        myTree.insert(13);
        myTree.insert(11);
        myTree.insert(14);
        myTree.insert(18);
        myTree.insert(16);
        myTree.insert(19);
        myTree.insert(17);
        myTree.insert(7);
        myTree.insert(8);
        myTree.insert(6);
        System.out.println(myTree.delete(15));
        System.out.println("HEAD: " + myTree.head.value);
        System.out.println("HEAD LEFT: " + myTree.head.left.value);
        System.out.println("HEAD LEFT LEFT: " + myTree.head.left.left.value);
        System.out.println("HEAD LEFT RIGHT: " + myTree.head.left.right.value);

        System.out.println("HEAD RIGHT: " + myTree.head.right.value);
        System.out.println("HEAD RIGHT LEFT: " + myTree.head.right.left.value);
        System.out.println("HEAD RIGHT RIGHT: " + myTree.head.right.right.value);

        System.out.println("HEAD RIGHT RIGHT LEFT: " + myTree.head.right.right.left.value);
        System.out.println("HEAD RIGHT RIGHT RIGHT: " + myTree.head.right.right.right.value);
    }

}
