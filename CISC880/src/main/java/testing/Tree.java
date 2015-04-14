package testing;
import java.lang.reflect.Method;
import java.util.List;

public class Tree {

	private Node root;
	List<Method> methods;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}

}
