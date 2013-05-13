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
public class P05BinaryString0101 {
	private int n;
	private List<int[]> generations;

	private void generate() {
		this.generations = new ArrayList<int[]>();

		// Create the first generation
		int[] generation = new int[n];
		int first01 = 0, second01 = 2;

		generation[0] = 0;
		generation[1] = 1;
		generation[2] = 0;
		generation[3] = 1;

		for (int i = 4; i < generation.length; i++) {
			generation[i] = 0;
		}

		this.generations.add(generation);

		do {
			
		} while (first01 < n - 4 && second01 < n - 2);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) throws IllegalArgumentException {
		if (n < 4) {
			throw new IllegalArgumentException("Số n nhập vào nhỏ hơn 4");
		}

		this.n = n;
		this.generate();
	}

	public List<int[]> getGenerations() {
		return generations;
	}

	public P05BinaryString0101(int n) {
		super();
		this.setN(n);
		this.generate();
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int[] generation : this.generations) {
			for (int i = 0; i < generation.length; i++) {
				stringBuilder.append(generation[i] + " ");
			}

			stringBuilder.append("\r\n");
		}

		return stringBuilder.toString();
	}
}
