/**
 * 
 */
package generation.ui;

import generation.lib.P01BinaryString;
import generation.lib.P02SubsetCombination;
import generation.lib.P03Permutation;
import generation.lib.P04RepetedPermutation;
import generation.lib.P05BinaryString0101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Son-Huy TRAN
 * 
 */
public class GenerationMainUI {

	private static BufferedReader keyboard = new BufferedReader(
			new InputStreamReader(System.in));

	private static void binaryString() {
		try {
			System.out.print("Nhập độ dài chuỗi (n):");
			int n = Integer.parseInt(keyboard.readLine());
			P01BinaryString binaryString = new P01BinaryString(n);
			List<String> generatedStrings = binaryString.generate();

			System.out.println("Các chuỗi được sinh ra:");
			System.out.println(generatedStrings);
		} catch (NumberFormatException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi nhập xuất từ bàn phím");
			e.printStackTrace();
		}
	}

	private static void subsetCombination() {
		try {
			// Get inputs
			System.out.print("Nhập tổng số phần tử:");
			int n = Integer.parseInt(keyboard.readLine());
			System.out.print("Nhập số phần tử của tập con:");
			int k = Integer.parseInt(keyboard.readLine());

			// Output
			P02SubsetCombination subsetCombination = new P02SubsetCombination(
					k, n);
			System.out.println("Các dãy được sinh ra:");
			System.out.println(subsetCombination);
		} catch (NumberFormatException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi nhập xuất từ bàn phím");
			e.printStackTrace();
		}
	}

	private static void permutation() {
		try {
			// Get inputs
			System.out.print("Nhập tổng số phần tử:");
			int n = Integer.parseInt(keyboard.readLine());

			// Output
			P03Permutation p03Permutation = new P03Permutation(n);
			System.out.println(p03Permutation);
		} catch (NumberFormatException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi nhập xuất từ bàn phím");
			e.printStackTrace();
		}
	}

	private static void repetedPermutation() {
		try {
			// Get inputs
			System.out.print("Nhập tổng số phần tử:");
			int n = Integer.parseInt(keyboard.readLine());
			System.out.print("Nhập độ dài dãy chỉnh hợp lặp:");
			int k = Integer.parseInt(keyboard.readLine());

			// output
			P04RepetedPermutation p04RepetedPermutation = new P04RepetedPermutation(
					n, k);
			System.out.println(p04RepetedPermutation);
		} catch (NumberFormatException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi nhập xuất từ bàn phím");
			e.printStackTrace();
		}
	}

	private static void binaryString0101() {
		try {
			// Get inputs
			System.out.print("Nhập tổng số phần tử:");
			int n = Integer.parseInt(keyboard.readLine());

			// Output
			P05BinaryString0101 p05BinaryString0101 = new P05BinaryString0101(n);
			System.out.println(p05BinaryString0101);
		} catch (NumberFormatException e) {
			System.out.println("Số nhập vào không hợp lệ");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("Số nhập vào không hợp lệ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Lỗi nhập xuất từ bàn phím");
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		do {
			try {
				System.out.println("");
				System.out.println("*****************");
				System.out
						.println("1. Thuật toán sinh liệt kê các dãy nhị phân có độ dài n");
				System.out
						.println("2. Thuật toán sinh liệt kê các tập con k phần tử");
				System.out.println("3. Thuật toán sinh liệt kê các hoán vị");
				System.out
						.println("4. Thuật toán sinh liệt kê các chỉnh hợp lặp chập k");
				System.out
						.println("5. Thuật toán sinh liệt kê các dãy nhị phân có độ dài n mà trong đó cụm chữ số \"01\" xuất hiện đúng 2 lần");
				System.out
						.print("Bạn chọn bài toán số mấy? (nhập số 0 để kết thúc)");

				int problemCode = Integer.parseInt(keyboard.readLine());

				switch (problemCode) {
				case 0:
					System.exit(0);

				case 1:
					GenerationMainUI.binaryString();
					break;

				case 2:
					GenerationMainUI.subsetCombination();
					break;

				case 3:
					GenerationMainUI.permutation();
					break;

				case 4:
					GenerationMainUI.repetedPermutation();
					break;

				case 5:
					GenerationMainUI.binaryString0101();
					break;

				default:
					break;
				}
			} catch (NumberFormatException e) {
				System.out.print("Mã bài toán không hợp lệ");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.print("Lỗi nhập xuất từ bàn phím");
				e.printStackTrace();
			}
		} while (true);
	}
}