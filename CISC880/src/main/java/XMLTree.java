

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tree")
public class XMLTree {

	private ArrayList<XMLNode> nodes;

	private String type;
	private String viewMode;
	private String threadSelection;
	private String threadStatus;
	private String aggregationLevel;

	@XmlElements(value = { @XmlElement(name = "node") })
	public ArrayList<XMLNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<XMLNode> nodes) {
		this.nodes = nodes;
	}

	@XmlAttribute
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute
	public String getViewMode() {
		return viewMode;
	}

	public void setViewMode(String viewMode) {
		this.viewMode = viewMode;
	}

	@XmlAttribute
	public String getThreadSelection() {
		return threadSelection;
	}

	public void setThreadSelection(String threadSelection) {
		this.threadSelection = threadSelection;
	}

	@XmlAttribute
	public String getThreadStatus() {
		return threadStatus;
	}

	public void setThreadStatus(String threadStatus) {
		this.threadStatus = threadStatus;
	}

	@XmlAttribute
	public String getAggregationLevel() {
		return aggregationLevel;
	}

	public void setAggregationLevel(String aggregationLevel) {
		this.aggregationLevel = aggregationLevel;
	}

}