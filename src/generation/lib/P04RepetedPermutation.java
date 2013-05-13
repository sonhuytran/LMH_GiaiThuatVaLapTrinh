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
public class P04RepetedPermutation {
	private int n;
	private int k;
	private List<int[]> generations;

	public int getN() {
		return this.n;
	}

	public int getK() {
		return this.k;
	}

	public List<int[]> getGenerations() {
		return this.generations;
	}

	public void setNK(int n, int k) {
		if (n < 0) {
			throw new IllegalArgumentException("Số n nhập vào là số âm");
		}

		if (k < 0) {
			throw new IllegalArgumentException("Số k nhập vào là số âm");
		}

		this.n = n;
		this.k = k;
		this.generate();
	}
	
	

	public P04RepetedPermutation(int n, int k) {
		super();
		this.setNK(n, k);
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

	private void generate() {
		this.generations = new ArrayList<int[]>();

		if (n <= 0 || k <= 0) {
			return;
		}

		// Create the first generation
		int[] generation = new int[this.k];

		for (int i = 0; i < this.k; i++) {
			generation[i] = 0;
		}

		// Create the next generations
		int i = this.k - 1;

		do {
			i = this.k - 1;

			while (i >= 0 && generation[i] >= n - 1) {
				i--;
			}

			if (i >= 0) {
				generation = generation.clone();
				generation[i]++;

				for (int j = i + 1; j < generation.length; j++) {
					generation[j] = 0;
				}
				
				this.generations.add(generation);
			}
		} while (i >= 0);
	}
}