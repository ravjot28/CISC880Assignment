import java.util.List;

public class Method {

	private List<Node> nodes;
	private int maxHeight;
	private int minCPD;
	private int induced;

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public int getMinCPD() {
		return minCPD;
	}

	public void setMinCPD(int minCPD) {
		this.minCPD = minCPD;
	}

	public int getInduced() {
		return induced;
	}

	public void setInduced(int induced) {
		this.induced = induced;
	}

}
