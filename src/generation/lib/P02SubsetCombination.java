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
public class P02SubsetCombination {
	private int k;
	private int n;

	private List<int[]> generations;

	public int getK() {
		return k;
	}

	public int getN() {
		return n;
	}

	public void setNK(int n, int k) {
		this.n = n;
		this.k = k;
		this.generate();
	}

	public List<int[]> getGenerations() {
		return generations;
	}

	public P02SubsetCombination(int k, int n) {
		super();
		this.k = k;
		this.n = n;
		this.generations = null;
		this.generate();
	}

	private void generate() {
		this.generations = new ArrayList<int[]>();

		// Create the first generation
		int[] generation = new int[this.k];

		for (int i = 0; i < this.k; i++) {
			generation[i] = i + 1;
		}

		this.generations.add(generation);

		// Generate the next generations
		int i = this.k - 1;
		int temp = this.n - this.k + 1;

		do {
			generation = generation.clone();
			i = this.k - 1;

			while (i >= 0 && generation[i] >= temp + i) {
				i--;
			}

			if (i >= 0) {
				generation[i]++;

				for (int j = i + 1; j < generation.length; j++) {
					generation[j] = j + 1;
				}

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