import java.lang.IndexOutOfBoundsException
import java.util.*
import kotlin.collections.ArrayList


//Generic class
//primary constructor for cases when we don't need to limit size of our collection
class Stack<T>(capacity: Int) {

    //secondary constructor for cases when we need to limit size of our collection using maxSize field
    constructor(capacity: Int, maxSize: Int): this(capacity) {
        this.maxSize = maxSize
    }

    //use ArrayList to avoid nullable values
    private val stack = ArrayList<T>(capacity)
    //current size
    private var size = 0
    //max size if we want to limit it
    private var maxSize = Int.MAX_VALUE


    fun push(obj: T) {
        if (size >= maxSize)
            throw IndexOutOfBoundsException()
        size++
        stack.add(obj)
    }

    //throw Exception to avoid null
    fun pop(): T {
        if (size <= 0)
            throw EmptyStackException()
        return stack[--size]
    }


    override fun hashCode() = stack
        .asSequence()
        .map{ obj -> obj.hashCode() * 31}
        .sum()


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Stack<*>

        if (stack != other.stack) return false
        if (size != other.size) return false

        return true
    }

}
