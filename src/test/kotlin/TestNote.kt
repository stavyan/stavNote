import org.junit.Test

/**
 *@des 测试笔记本
 *@author stav stavyan@qq.com
 *@blog https://stavtop.club
 *@date 2019/07/18 23:30:24
 */
class TestNote {
    @Test
    fun testAddGenesis() {
        val noteBook = NoteBook()
        noteBook.addGenesis("第一个笔记本首页")
        val result:Boolean = noteBook.addGenesis("第二个笔记本首页")
        println(result)
    }

    @Test
    fun testAddNote() {
        val noteBook = NoteBook()
        noteBook.addGenesis("第一个笔记本首页")
        val result:Boolean = noteBook.addNote("a给b转账100")
        println(result)
    }

    @Test
    fun testListAll() {
        val noteBook = NoteBook()
        noteBook.addGenesis("第一个笔记本首页")
        noteBook.addNote("a给b转账100 ")
        val result:String = noteBook.listAll()
        println(result)
    }
}
