
/**
 *@className NoteBook.kt
 *@des 笔记本对象
 *@author stav stavyan@qq.com
 *@blog https://stavtop.club
 *@date 2019/07/18 23:14:35
 */
class NoteBook {
    val list = ArrayList<String>()
    /**
     *@des 添加笔记本首页（只能添加一次）
     *@author stav stavyan@qq.com
     *@blog https://stavtop.club
     *@date 2019/07/18 23:15:26
     *@param genesis 首页内容
     *@return true 添加成功 false 添加失败
     */
    fun addGenesis(genesis:String):Boolean {
        return try {
            require(list.size == 0) { "首页只能添加一次" }
            list.add(genesis)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     *@des 添加转账信息
     *@author stav stavyan@qq.com
     *@blog https://stavtop.club
     *@date 2019/07/18 23:23:07
     *@param content 转账消息
     *@return true 转账成功 false 转账失败
     */
    fun addNote(content:String): Boolean {
        // 首页添加之后才能转账
        return try {
            require(list.size > 0) {"请先添加封面"}
            list.add(content)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     *@des 列举所有消息（包括封面）
     *@author stav stavyan@qq.com
     *@blog https://stavtop.club
     *@date 2019/07/18 23:27:00
     */
    fun listAll():String {
        return list.toString()
    }

}
