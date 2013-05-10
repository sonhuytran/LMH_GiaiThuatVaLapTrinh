/**
 * 
 */
package generation.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P01BinaryString {
	private int length = 0;
	private List<String> generatedStrings = null;

	public P01BinaryString(int n) {
		this.length = n;
	}

	public int getLength() {
		return length;
	}

	public List<String> getGeneratedStrings() {
		return generatedStrings;
	}

	public List<String> generate() {
		this.generatedStrings = new ArrayList<String>();
		StringBuilder stringBuilder = new StringBuilder(this.length);

		// the first generation
		for (int i = 0; i < this.length; i++) {
			stringBuilder.append('0');
		}

		// Insert the first generation to the list
		this.generatedStrings.add(stringBuilder.toString());

		int index;

		do {
			// get the first '0' character from the right
			index = stringBuilder.length() - 1;

			while (index >= 0 && stringBuilder.charAt(index) == '1') {
				index--;
			}

			// if a '0' character exists
			if (index >= 0) {
				// change the first '0' character to '1'
				stringBuilder.setCharAt(index, '1');

				// change all the characters in the right of it to '0'
				for (int j = index + 1; j < stringBuilder.length(); j++) {
					stringBuilder.setCharAt(j, '0');
				}

				// add the new generation to the list
				this.generatedStrings.add(stringBuilder.toString());
			}
		} while (index >= 0);

		return this.generatedStrings;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (String string : generatedStrings) {
			stringBuilder.append(string);
			stringBuilder.append("\r\n");
		}

		return stringBuilder.toString();
	}
}