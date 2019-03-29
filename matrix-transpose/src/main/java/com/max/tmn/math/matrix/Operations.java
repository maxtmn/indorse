package com.max.tmn.math.matrix;

public class Operations {

	/**
	 *  https://en.wikipedia.org/wiki/Transpose
	 *  
	 * @param matrix
	 * @return
	 */
	public static <T> Matrix<T> transpose(Matrix<T> matrix) {
		Matrix<T> result = new Matrix<>(matrix.dimension().width(), matrix
				.dimension().length());

		for (int row = 0; row < matrix.dimension().length(); row++) {
			for (int col = 0; col < matrix.dimension().width(); col++) {
				result.set(col, row, matrix.get(row, col));
			}
		}

		return result;
	}

}
