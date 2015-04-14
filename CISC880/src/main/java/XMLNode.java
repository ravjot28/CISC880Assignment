

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class XMLNode {

	private ArrayList<XMLNode> nodes;

	private String leaf;

	private String class1;
	private String methodName;

	private String methodSignature;

	private String time;

	private String count;

	private String inherentTime;

	private String lineNumber;

	private String percent;

	@XmlAttribute
	public String getLeaf() {
		return leaf;
	}

	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}

	@XmlAttribute(name = "class")
	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	@XmlAttribute
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@XmlAttribute
	public String getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}

	@XmlAttribute
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@XmlAttribute
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@XmlAttribute
	public String getInherentTime() {
		return inherentTime;
	}

	public void setInherentTime(String inherentTime) {
		this.inherentTime = inherentTime;
	}

	@XmlAttribute
	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	@XmlAttribute
	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	@XmlElements(value = { @XmlElement(name = "node") })
	public ArrayList<XMLNode> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<XMLNode> nodes) {
		this.nodes = nodes;
	}

	public String toString() {
		return class1 + " " + methodName;
	}

}
