import java.util.List;

public class Method {

	private List<XMLNode> nodes;
	private int maxHeight;
	private int minCPD;
	private long induced;

	public List<XMLNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<XMLNode> nodes) {
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

	public long getInduced() {
		return induced;
	}

	public void setInduced(long induced) {
		this.induced = induced;
	}

}
