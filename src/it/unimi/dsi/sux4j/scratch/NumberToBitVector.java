package it.unimi.dsi.sux4j.scratch;

import java.math.BigInteger;

import it.unimi.dsi.bits.BitVector;
import it.unimi.dsi.bits.LongArrayBitVector;
import it.unimi.dsi.bits.TransformationStrategy;

/** A transformation strategy that converts strings representing integers between 0 (inclusive)
 *  and 2<sup><var>k</var></sup> (exclusive)) into fixed-length binary vectors (most-significant
 *  bit is the 0-th).
 */
public class NumberToBitVector implements TransformationStrategy<BigInteger> {
	private static final long serialVersionUID = 1L;
	/** Number of binary digits to be used. */
	private final int width;

	/** Creates a transformation strategy with given number of binary digits.
	 *
	 * @param width number of binary digits;
	 */
	public NumberToBitVector(final int width) {
		this.width = width;
	}

	@Override
	public TransformationStrategy<BigInteger> copy() {
		return new NumberToBitVector(width);
	}

	@Override
	public long numBits() {
		return 0;
	}

	@Override
	public long length(final BigInteger x) {
		return width;
	}

	@Override
	public BitVector toBitVector(BigInteger x) {
		final LongArrayBitVector res = LongArrayBitVector.getInstance(width);
		for (int i = 0; i < width; i++)
			res.add(x.testBit(width - i - 1));
		return res;
	}

	public static void main(String arg[]) {
		final NumberToBitVector ntbv = new NumberToBitVector(15);
		System.out.println(ntbv.toBitVector(new BigInteger("567")));
	}

}
