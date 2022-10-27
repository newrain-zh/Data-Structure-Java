package org.newrain.example.structure.tree.plus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * b+树节点类
 *
 * @author newrain
 */
public class BPlusNode<K extends Comparable<K>, V> {

    /**
     * 是否为根节点
     */
    private boolean isRoot;

    /**
     * 是否为叶子节点
     */
    private boolean isLeaf;

    /**
     * 父节点
     */

    protected BPlusNode<K, V> parent;

    /**
     * 叶节点的前节点
     */
    protected BPlusNode<K, V> previous;

    /**
     * 叶节点的后节点
     */
    protected BPlusNode<K, V> next;

    /**
     * 节点的关键字列表
     */
    protected List<Map.Entry<K, V>> entries;

    /**
     * 子节点列表
     */
    protected List<BPlusNode<K, V>> children;

    public BPlusNode(boolean isLeaf) {
        this.isLeaf = isLeaf;
        entries = new ArrayList<>();

        if (!isLeaf) {
            children = new ArrayList<>();
        }
    }

    public BPlusNode(boolean isLeaf, boolean isRoot) {
        this(isLeaf);
        this.isRoot = isRoot;
    }

}
