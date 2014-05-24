package path.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cat {
	private List<Step> steps;
	private Step current;

	public String path() {
		StringBuilder sb = new StringBuilder();
		for (Step s : steps) {
			sb.append(s.draw());
		}
		return sb.toString();
	}

	public void leap() {
		this.current = current.next();
		steps.add(this.current);
	}

	public Cat() {
		this.current = new Step() {
			@Override
			public Step next() {
				return new FirstStep();
			}

			@Override
			public String draw() {
				return "*";
			}
		};

		this.steps = new ArrayList<Step>(Arrays.asList(this.current));
	}

}
