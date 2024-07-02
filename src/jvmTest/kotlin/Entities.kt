import domain.DIFFICULTIES
import domain.Mode1
import domain.SIZES

val GAME_MODE = Mode1()
val GAME_MODE_BIG = Mode1().apply { selection.size.selected = SIZES.BIG }
val GAME_MODE_HARD = Mode1().apply { selection.difficulty.selected = DIFFICULTIES.HARD }
val GAME_MODE_BIG_BOUGHT = Mode1().apply { selection.size.available = SIZES.BIG }

val PLAYFIELD_3: Array<IntArray> = arrayOf(
    intArrayOf(8, 0, 3, 0, 9, 4, 7, 5, 1),
    intArrayOf(6, 5, 9, 0, 1, 2, 4, 3, 8),
    intArrayOf(7, 0, 4, 3, 5, 8, 6, 2, 9),
    intArrayOf(3, 4, 1, 0, 6, 9, 8, 7, 2),
    intArrayOf(2, 9, 7, 1, 8, 3, 5, 6, 4),
    intArrayOf(5, 8, 6, 2, 4, 7, 9, 1, 3),
    intArrayOf(9, 0, 2, 0, 7, 6, 1, 4, 5),
    intArrayOf(1, 7, 8, 4, 2, 5, 3, 9, 6),
    intArrayOf(4, 6, 5, 9, 3, 1, 2, 8, 7),
)

val PLAYFIELD_3_INPUT: Array<IntArray> = arrayOf(
    intArrayOf(8, -1, 3, 0, 9, 4, 7, 5, 1),
    intArrayOf(6, 5, 9, 0, 1, 2, 4, 3, 8),
    intArrayOf(7, 0, 4, 3, 5, 8, 6, 2, 9),
    intArrayOf(3, 4, 1, 0, 6, 9, 8, 7, 2),
    intArrayOf(2, 9, 7, 1, 8, 3, 5, 6, 4),
    intArrayOf(5, 8, 6, 2, 4, 7, 9, 1, 3),
    intArrayOf(9, 0, 2, 0, 7, 6, 1, 4, 5),
    intArrayOf(1, 7, 8, 4, 2, 5, 3, 9, 6),
    intArrayOf(4, 6, 5, 9, 3, 1, 2, 8, 7),
)