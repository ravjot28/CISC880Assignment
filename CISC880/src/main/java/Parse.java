import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Parse {

	private static Map<String, Method> methods = new HashMap<String, Method>();

	public static void main(String[] args) {
		try {

			File file = new File(
					"C:\\Users\\Ravjot\\Desktop\\Assignment\\CISC880Assignment\\CISC880\\src\\main\\resources\\Call_Tree_5.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(XMLTree.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XMLTree tree = (XMLTree) jaxbUnmarshaller.unmarshal(file);

			XMLNode root = tree.getNodes().get(0);
			System.out.println(root.getChildren().size());
			for (XMLNode node : root.getChildren()) {
				// System.out.println(node.getClass1());
				buildTree(node, null);
			}
			System.out.println("Tree built");
			for (XMLNode node : root.getChildren()) {
				process(node);
			}
			System.out.println("Tree processed");

			for (XMLNode node : root.getChildren()) {
				process1(node);
			}
			Iterator it = methods.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				// System.out.println(pair.getKey() + " = " + pair.getValue());
				if (new Algorithm().isSubsumedMethod((Method) pair.getValue()) &&((Method) pair.getValue()).getMinCPD()!= 9999999) {
					// System.out.println(pair.getKey());
					System.out.println("Induced " + pair.getKey()
							+ +((Method) pair.getValue()).getMaxHeight() + " "
							+ ((Method) pair.getValue()).getMinCPD()+" "+((Method) pair.getValue()).getInduced());
				}
			}

			// System.out.println(tree);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void process(XMLNode node) {
		if (node != null) {
			// System.out.println(node.getClass1()+node.getMethodName());

			// ag.reduceRecursivePaths(node);
			node.setAdjustedChildren(node.getChildren());
			node.setAdjustedParent(node.getParent());
			if (node.getChildren() != null) {
				for (XMLNode child : node.getChildren()) {
					process(child);
				}
			}
		}

	}

	public static void process1(XMLNode node) {
		Algorithm ag = new Algorithm();
		ag.calculateHeight(node);
		ag.minCPD(node.getMethod());
		ag.calculateInducedCost(node);
		if (node.getChildren() != null) {
			for (XMLNode child : node.getChildren()) {
				process1(child);
			}
		}
	}

	public static void buildTree(XMLNode node, XMLNode parent) {

		Method method = null;
		if (methods.get(node.getMethodName() + node.getMethodSignature()) != null) {
			method = methods.get(node.getMethodName()
					+ node.getMethodSignature());
			method.getNodes().add(node);
		} else {
			method = new Method();
			List<XMLNode> nodes = new ArrayList<XMLNode>();
			nodes.add(node);
			method.setNodes(nodes);
			methods.put(node.getMethodName() + node.getMethodSignature(),
					method);
		}
		node.setMethod(method);
		node.setParent(parent);
		if (node.getChildren() != null) {
			for (XMLNode child : node.getChildren()) {
				// System.out.println(child + " " + node);
				buildTree(child, node);
			}
		}
	}
}
