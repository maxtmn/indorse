package com.max.tmn.math.matrix;

import java.io.Console;
import java.util.function.Function;
import java.util.function.Supplier;

import com.max.tmn.math.matrix.Matrix.Value;

public class Main {

	private Console console;
	private Matrix<Integer> matrix;

	public Main(Console console) {
		this.console = console;
	}

	/**
	 * This program expects you to get the size of the matrix as an input by the
	 * user. </br> This should be saved as variables X and Y. </br>The values of
	 * X and Y should be less than 8. </br>Thereafter, the user is asked to
	 * enter the values of the matrix. </br>Once you get all the values of the
	 * matrix, you will then transpose the matrix.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Console console = System.console();
		if (null == console) {
			System.err.println("No console.");
			System.exit(1);
		}
		Main app = new Main(console);

		int length = app.readInput(() -> "Enter matrix length: X=");
		int width = app.readInput(() -> "Enter matrix length: Y=");

		console.format("Input:%n%s%n", app.createMatrix(length, width));

		console.format("Transposed:%n%s", app.operation(Operations::transpose));
		System.exit(0);
	}

	private <U> Matrix<U> operation(
			Function<Matrix<Integer>, Matrix<U>> consumer) {
		return consumer.apply(matrix);
	}

	private Matrix<Integer> createMatrix(int length, int width) {
		this.matrix = new Matrix<Integer>(new Dimension(length, width));

		fill(matrix, Integer::parseInt);

		return matrix;
	}

	public void fill(Matrix<Integer> matrix, Function<String, Integer> mapper) {
		for (int row = 0; row < matrix.dimension().length(); row++)
			for (int col = 0; col < matrix.dimension().width(); col++)
				matrix.set(row, col, Value.of(mapper.apply(console
						.readLine(String
								.format("(%d, %d) = ", row + 1, col + 1)))));
	}

	public int readInput(Supplier<String> supplier) {
		boolean valid = false;
		do {
			int input = Integer.parseInt(console.readLine(supplier.get()));
			valid = validateSize(input);
			if (!valid) {
				console.format("Matrix size can not be less then 0 or greater than 8.%n");
				continue;
			}
			return input;
		} while (!valid);
		throw new IllegalArgumentException();
	}

	public boolean validateSize(int input) {
		return input > 0 && input <= 8;
	}

}
