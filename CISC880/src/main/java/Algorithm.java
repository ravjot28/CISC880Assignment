public class Algorithm {

	private int INFINITY = 9999999;

	private int subsumingHeight = 3;
	private int subsumingCPD = 2;

	public boolean isSubsumedMethod(Method m) {
		return m.getMaxHeight() >= subsumingHeight && m.getMinCPD() >= subsumingCPD;
	}

	public void calculateInducedCost(XMLNode n) {
		n.setInduced(Long.parseLong(n.getCost()));

		for (XMLNode c : n.getChildren()) {
			calculateInducedCost(c);
			if (isSubsumedMethod(c.getMethod())) {
				n.setInduced(n.getInduced() + c.getInduced());
			}
		}

		n.getMethod().setInduced(n.getMethod().getInduced() + n.getInduced());
	}

	public void calculateHeight(XMLNode v) {
		v.setHeight(0);
		for (XMLNode c : v.getAdjustedChildren()) {
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
		XMLNode n = m.getNodes().get(0);
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
		for (XMLNode n : m.getNodes()) {
			int dist = distance(p, n);
			if (dist > cpd) {
				cpd = dist;
			}
		}
		return cpd;
	}

	public int distance(Method m, XMLNode n) {
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

	public void reduceRecursivePaths(XMLNode n) {
		n.setAdjustedParent(findAdjustedParent(n));
		n.getAdjustedParent().getAdjustedChildren().add(n);
		for (XMLNode temp : n.getChildren()) {
			reduceRecursivePaths(temp);
		}
	}

	public XMLNode findAdjustedParent(XMLNode current) {
		XMLNode match1 = null;
		XMLNode match2 = null;
		XMLNode n = current.getParent();
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
		XMLNode n1 = current.getParent();
		XMLNode n2 = match1.getAdjustedParent();

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
