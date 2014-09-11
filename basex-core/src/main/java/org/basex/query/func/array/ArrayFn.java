package org.basex.query.func.array;

import static org.basex.query.util.Err.*;

import org.basex.query.*;
import org.basex.query.func.*;
import org.basex.query.value.array.*;

/**
 * Functions on arrays.
 *
 * @author BaseX Team 2005-14, BSD License
 * @author Christian Gruen
 */
abstract class ArrayFn extends StandardFunc {
  /**
   * Checks if a position is within the range of an array.
   * @param array array
   * @param pos position
   * @param incl include last entry
   * @return specified position -1
   * @throws QueryException query exception
   */
  final int checkPos(final Array array, final long pos, final boolean incl) throws QueryException {
    final int as = array.arraySize() + (incl ? 1 : 0);
    if(pos < 1 || pos > as) throw ARRAYBOUNDS_X_X.get(info, pos, as);
    return (int) pos - 1;
  }

  /**
   * Checks if a position is within the range of an array.
   * @param array array
   * @param pos position
   * @return specified position -1
   * @throws QueryException query exception
   */
  final int checkPos(final Array array, final long pos) throws QueryException {
    return checkPos(array, pos, false);
  }
}
