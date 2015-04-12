public class Algorithm {

	private int INFINITY = 9999999;

	public boolean isSubsumedMethod(Method m) {
		return true;
	}

	public void calculateInducedCost(Node n) {
		n.setInduced(n.getCost());

		for (Node c : n.getChildren()) {
			calculateInducedCost(c);
			if (isSubsumedMethod(c.getMethod())) {
				n.setInduced(n.getInduced() + c.getInduced());
			}
		}

		n.getMethod().setInduced(n.getMethod().getInduced() + n.getInduced());
	}

	public void calculateHeight(Node v) {
		v.setHeight(0);
		for (Node c : v.getAdjustedChildren()) {
			calculateHeight(c);
			if (c.getHeight() + 1 > v.getHeight()) {
				v.setHeight(c.getHeight() + 1);
			}
		}

		if (v.getHeight() > v.getMethod().getMaxHeight()) {
			v.getMethod().setMaxHeight(v.getHeight());
		}
	}

	public void minCPD(Method m) {
		m.setMinCPD(INFINITY);
		Node n = m.getNodes().get(0);
		n = n.getAdjustedParent();

		while (n != null) {
			int dist = CPD(n.getMethod(), m);
			if (dist < m.getMinCPD()) {
				m.setMinCPD(dist);
				n = n.getParent();
			}
		}

	}

	public int CPD(Method p, Method m) {
		int cpd = 0;
		for (Node n : m.getNodes()) {
			int dist = distance(p, n);
			if (dist > cpd) {
				cpd = dist;
			}
		}
		return cpd;
	}

	public int distance(Method m, Node n) {
		int dist = 0;
		while (true) {
			dist += 1;
			n = n.getAdjustedParent();
			if (n == null) {
				return INFINITY;
			}

			if (n.getMethod() == m) {
				return dist;
			}
		}
	}

	public void reduceRecursivePaths(Node n) {
		n.setAdjustedParent(findAdjustedParent(n));
		n.getAdjustedParent().getAdjustedChildren().add(n);
		for (Node temp : n.getChildren()) {
			reduceRecursivePaths(temp);
		}
	}

	public Node findAdjustedParent(Node current) {
		Node match1 = null;
		Node match2 = null;
		Node n = current.getParent();
		while (n != null && match2 == null) {
			if (n.getMethod() == current.getMethod()) {
				if (match1 == null) {
					match1 = n;
				} else {
					match2 = n;
				}
			}
			n = n.getAdjustedParent();
		}

		if (match1 == null || match2 == null) {
			return current.getParent();
		}
		Node n1 = current.getParent();
		Node n2 = match1.getAdjustedParent();

		while (n1 != match1 && n2 != match2) {
			if (n1.getMethod() != n2.getMethod()) {
				return current.getParent();
			}

			n1 = n1.getAdjustedParent();
			n2 = n2.getAdjustedParent();
		}

		if (n1 != match1 || n2 != match2) {
			return current.getParent();
		}

		return match1.getAdjustedParent();
	}

}
