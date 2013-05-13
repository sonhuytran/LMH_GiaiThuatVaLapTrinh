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
public class P03Permutation {
	private int n;
	private List<int[]> generations;

	public int getN() {
		return n;
	}

	public void setN(int n) throws IllegalArgumentException {
		if (n < 0) {
			throw new IllegalArgumentException("Số n nhập vào là số âm");
		}

		this.n = n;
		this.generate();
	}

	public List<int[]> getGenerations() {
		return generations;
	}

	public P03Permutation(int n) throws IllegalArgumentException {
		super();
		this.setN(n);
		this.generate();
	}

	private void swap(int[] generation, int i, int j) {
		int temp = generation[i];
		generation[i] = generation[j];
		generation[j] = temp;
	}

	private void generate() {
		this.generations = new ArrayList<int[]>();

		if (this.n <= 0) {
			return;
		}

		int[] generation = new int[this.n];

		// Create the first generation
		for (int i = 0; i < generation.length; i++) {
			generation[i] = i + 1;
		}

		this.generations.add(generation);
		int i = this.n - 1;

		// Generate the next generations
		do {
			i = this.n - 2;

			// Find the first element to change
			while (i >= 0 && generation[i] > generation[i + 1]) {
				i--;
			}

			if (i >= 0) {
				generation = generation.clone();
				int j = this.n - 1;

				// swap it with the first element in the right
				// which is greater than it
				while (generation[j] < generation[i]) {
					j--;
				}

				this.swap(generation, i, j);

				// reverse the rest of the list
				int k = i + 1, l = n - 1;

				while (k < l) {
					this.swap(generation, k, l);
					k++;
					l--;
				}

				// finish, add the new generation
				this.generations.add(generation);
			}
		} while (i >= 0);
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
