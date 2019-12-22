package main.common;

import java.util.List;

/**
 * @author wenzhuang
 * @date 2019/12/20 11:34 PM
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}