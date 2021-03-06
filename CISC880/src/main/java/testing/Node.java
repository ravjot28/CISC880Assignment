package testing;
import java.lang.reflect.Method;
import java.util.List;

public class Node {

	private Method method;
	private long cost;
	private Node parent;
	private List<Node> children;
	private Node adjustedParent;
	private List<Node> adjustedChildren;
	private int height;
	private int induced;

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Node getAdjustedParent() {
		return adjustedParent;
	}

	public void setAdjustedParent(Node adjustedParent) {
		this.adjustedParent = adjustedParent;
	}

	public List<Node> getAdjustedChildren() {
		return adjustedChildren;
	}

	public void setAdjustedChildren(List<Node> adjustedChildren) {
		this.adjustedChildren = adjustedChildren;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getInduced() {
		return induced;
	}

	public void setInduced(int induced) {
		this.induced = induced;
	}

}
