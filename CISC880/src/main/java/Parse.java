import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Parse {

	private static Map<String, Method> methods = new HashMap<String, Method>();

	public static void main(String[] args) {
		try {

			File file = new File("/Users/Rav/git/CISC880/CISC880/src/main/resources/Call_Tree_5.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(XMLTree.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XMLTree tree = (XMLTree) jaxbUnmarshaller.unmarshal(file);

			XMLNode root = tree.getNodes().get(0);
			System.out.println(root.getNodes().size());
			for (XMLNode node : root.getNodes()) {
				System.out.println(node.getClass1());
				buildTree(node, null);
				Algorithm ag = new Algorithm();
				System.exit(1);
			}

			System.out.println(tree);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void buildTree(XMLNode node, XMLNode parent) {

		Method method = null;
		if (methods.get(node.getMethodName() + node.getMethodSignature()) != null) {
			method = methods.get(node.getMethodName() + node.getMethodSignature());
			method.getNodes().add(node);
		} else {
			method = new Method();
			List<XMLNode> nodes = new ArrayList<XMLNode>();
			nodes.add(node);
			method.setNodes(nodes);
			methods.put(node.getMethodName() + node.getMethodSignature(), method);
		}
		node.setMethod(method);
		node.setParent(parent);
		for (XMLNode child : node.getNodes()) {
			buildTree(child, node);
		}
	}

}
