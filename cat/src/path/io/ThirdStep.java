package path.io;

public class ThirdStep implements Step {

	@Override
	public Step next() {
		return new FourthStep();
	}

	@Override
	public String draw() {
		return "...*";
	}

}
