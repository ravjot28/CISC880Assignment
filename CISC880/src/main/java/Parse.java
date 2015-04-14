

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Parse {

	/**
	 * @param args
	 */
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
				System.exit(1);
			}

			System.out.println(tree);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
