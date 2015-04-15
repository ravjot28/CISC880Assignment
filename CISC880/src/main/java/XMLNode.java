import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

public class XMLNode {

	private ArrayList<XMLNode> children;

	private String leaf;

	private String class1;
	private String methodName;
	private String methodSignature;
	private String cost;
	private String count;
	private String inherentTime;
	private String lineNumber;
	private String percent;

	private XMLNode parent;
	private Method method;
	private XMLNode adjustedParent;
	private List<XMLNode> adjustedChildren;
	int height;
	long induced;

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

	@XmlAttribute(name = "time")
	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
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
	public ArrayList<XMLNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<XMLNode> children) {
		this.children = children;
	}

	public String toString() {
		return class1 + " " + methodName;
	}

	public XMLNode getParent() {
		return parent;
	}

	public void setParent(XMLNode parent) {
		this.parent = parent;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public XMLNode getAdjustedParent() {
		return adjustedParent;
	}

	public void setAdjustedParent(XMLNode adjustedParent) {
		this.adjustedParent = adjustedParent;
	}

	public List<XMLNode> getAdjustedChildren() {
		return adjustedChildren;
	}

	public void setAdjustedChildren(List<XMLNode> adjustedChildren) {
		this.adjustedChildren = adjustedChildren;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getInduced() {
		return induced;
	}

	public void setInduced(long induced) {
		this.induced = induced;
	}

}
