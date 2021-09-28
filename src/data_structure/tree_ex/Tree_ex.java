package data_structure.tree_ex;

public class Tree_ex {
    Node head = null;

    public class Node {
        Integer value;
        Node leftNode;
        Node rightNode;

        public Node(Integer data) {
            this.value = data;
            this.leftNode = null;
            this.rightNode = null;
        }
    }

    public boolean insert(Integer data) {
        //Case 1: 노드가 하나도 없을 경우
        if (head == null) {
            this.head = new Node(data);
        } else {
            Node findNode = this.head;
            while (true) {
                //Case 2 : parent 노드보다 값이 클 경우
                if (data <= findNode.value) {
                    if (findNode.leftNode != null) {
                        findNode = findNode.leftNode;
                    } else {
                        findNode.leftNode = new Node(data);
                        break;
                    }
                }
                //Case 3 : parent 노드보다 값이 작을 경우
                else {
                    if (findNode.rightNode != null) {
                        findNode = findNode.rightNode;
                    } else {
                        findNode.rightNode = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;
    }

    public Node searchNode(Integer data) {
        if (this.head == null) {
            return null;
        } else {
            Node searchNode = this.head;

            while (searchNode != null) {
                if (searchNode.value == data) {
                    return searchNode;
                } else {
                    if (searchNode.value >= data) {
                        searchNode = searchNode.leftNode;
                    } else {
                        searchNode = searchNode.rightNode;
                    }
                }
            }
            return null;
        }
    }

    public boolean removeNode(Integer data) {
        /**
         * case 1. 비어있는 경우
         * case 2. 노드가 존재하는 경우 >> 어떻게 이어줄 것인가?
         *      - 가장 마지막에 위치한 노드일 경우 (leaf Node)
         *      - 자식 Node 가 한개인 경우
         *          - 자식 노드를 삭제하고자 하는 노드의 부모와 이어준다.
         *      - 자식 Node 가 두개인 경우
         *          - 오른쪽 자식 노드가 root 가 되는 트리의 가장 작은 값을 올려준다.
         * */

        Node searchNode = this.head;
        Node parentNode = this.head;

        if(this.head == null) {
            return false;
        }else {


            boolean searched = false;

            if(searchNode.value == data && searchNode.leftNode == null && searchNode.rightNode == null) {
                this.head = null;
                return true;
            }

            while(searchNode != null) {
                if(searchNode.value == data) {
                    searched = true;
                    break;
                }else if(data <= searchNode.value){
                    parentNode = searchNode;
                    searchNode = searchNode.leftNode;
                }else {
                    parentNode = searchNode;
                    searchNode = searchNode.rightNode;
                }
            }

            if(!searched) return false;

        }
        /**
         * 1. leaf 노드인 경우
         * 2. 삭제할 Node가 왼쪽 자식 노드만 가지고 있는 경우
         * 3. 삭제할 Node가 오른쪽 자식 노드만 가지고 있는 경우
         * 4. 삭제할 Node가 자식 노드를 두개 가지고 있는 경우
         *  - 삭제할 Node의 오른쪽 트리 중 가장 작은 값을 올려준다.
         * */
        if(searchNode.leftNode == null && searchNode.rightNode == null) {
            if(parentNode.value >= data) {
                parentNode.leftNode = null;
                searchNode = null;
            }else {
                parentNode.rightNode = null;
                searchNode = null;
            }
            return true;
        }else if(searchNode.leftNode != null && searchNode.rightNode == null) {
            if(parentNode.value >= data) {
                parentNode.leftNode = searchNode.leftNode;
                searchNode = null;
            }else {
                parentNode.rightNode = searchNode.leftNode;
                searchNode = null;
            }
            return true;
        }else if(searchNode.leftNode == null && searchNode.rightNode != null){
            if(parentNode.value >= data) {
                parentNode.leftNode = searchNode.rightNode;
                searchNode = null;
            }else {
                parentNode.rightNode = searchNode.rightNode;
                searchNode = null;
            }
            return true;
        }else {
            if (parentNode.value >= data){
                /**
                 * 오른쪽의 트리 중 가장 작은 값을 올린다.
                 * */
                Node minNode = searchNode.rightNode;
                Node parentMinNode = searchNode.rightNode;
                while(minNode.leftNode != null) {
                    parentMinNode = minNode;
                    minNode = minNode.leftNode;
                }
                /**
                 * 오른쪽에 자식이 있는 경우와 없는 경우를 나눈다.
                 * */
                if(minNode.rightNode != null) {
                    parentMinNode.leftNode = minNode.rightNode;
                }else {
                    parentMinNode.leftNode = null;
                }

                parentNode.leftNode = minNode;
                minNode.leftNode = searchNode.leftNode;
                minNode.rightNode = searchNode.rightNode;
            }else {
                /**
                 * 오른쪽의 트리 중 가장 작은 값을 올린다.
                 * */
                Node minNode = searchNode.rightNode;
                Node parentMinNode = searchNode.rightNode;
                while(minNode.leftNode != null) {
                    parentMinNode = minNode;
                    minNode = minNode.leftNode;
                }
                /**
                 * 오른쪽에 자식이 있는 경우와 없는 경우를 나눈다.
                 * */
                if(minNode.rightNode != null) {
                    parentMinNode.leftNode = minNode.rightNode;
                }else {
                    parentMinNode.leftNode = null;
                }

                parentNode.rightNode = minNode;
                minNode.leftNode = searchNode.leftNode;
                minNode.rightNode = searchNode.rightNode;

                searchNode = null;
            }
            return true;
        }
    }

}
