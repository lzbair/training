package path.io;

public class FirstStep implements Step {

	@Override
	public Step next() {
		return new SecondStep();
	}

	@Override
	public String draw() {
		return ".*";
	}

}
