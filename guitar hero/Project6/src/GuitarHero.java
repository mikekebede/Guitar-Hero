public class GuitarHero {
	public static void main(String[] args) {

		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		GuitarString gstring[] = new GuitarString[38];

		// The i'th character of the string corresponds to a frequency of 440 ×
		// 1.05956(i - 24)
		// and we are writing for it to support 37 notes on the chromatic scale from
		// 110Hz to 880 Hz
		for (int i = 0; i < 37; ++i) {
			gstring[i] = new GuitarString(440.0 * Math.pow(1.05956, i - 24));
		}

		while (true) {
			// check if the user has typed a key; if so, process it
			// This while loop only works for one key at a time.
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				for (int i = 0; i < 37; ++i) {
					if (key == keyboard.charAt(i)) {
						gstring[i].pluck();
					}
				}
			}
			// compute the super-position of samples
			double sample = 0.0;
			for (int i = 0; i < 37; ++i) {
				sample += gstring[i].sample();
			}
			// play the sample on standard audio
			StdAudio.play(sample);

			// advance the simulation of each guitar string by one step
			for (int i = 0; i < 37; ++i) {
				gstring[i].tic();
			}
		}
	}
}
