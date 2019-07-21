
/**
 *@des
 *@author stav stavyan@qq.com
 *@blog https://stavtop.club
 *@date 2019/07/21 13:46:22
 */
fun main(args: Array<String>) {
    val noteBook = NoteBook()
//    noteBook.addGenesis("首页")
//    noteBook.addNote("张给李转400")
//    noteBook.saveToDisk()
    noteBook.loadFromDisk()
    println(noteBook.list.size)
}
