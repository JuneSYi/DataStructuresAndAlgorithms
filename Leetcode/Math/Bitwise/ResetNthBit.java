package Math.Bitwise;

public class ResetNthBit {
    /**
     * reset the i th bit means:
     * 1 --> 0
     * 0 -- > 0
     *
     * por ejemplo
     * 1 0 1 0 1 1 0 (reset the 5th bit, meaning if its 1, make it 0, if its 0, make it 0)
     * so & everything with one except for 5th bit
     * 1 1 0 1 1 1 1 (how do we get this mask)
     * -------------
     * 1 0 0 0 1 1 0
     *
     * mask: !(1 << (n-1))
     */
}
