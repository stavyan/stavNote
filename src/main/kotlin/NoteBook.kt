import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference
import java.io.File

/**
 *@className NoteBook.kt
 *@des 笔记本对象
 *@author stav stavyan@qq.com
 *@blog https://stavtop.club
 *@date 2019/07/18 23:14:35
 */
class NoteBook {
    val path = "note.txt"
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
     *@param json字符串
     */
    fun listAll():String {
        // fastjson
        return JSON.toJSONString(list)
    }


    /**
     *@des 将信息储存到本地硬盘
     *@author stav stavyan@qq.com
     *@blog https://stavtop.club
     *@date 2019/07/21 12:03:31
     */
    fun saveToDisk() {
        // 1. 获取消息
        val str = listAll()
        // 2.存储
        val file = File(path)
        file.writeText(str)
    }

    /**
     *@des 从磁盘加载数据，把list集合重新赋值
     *@author stav stavyan@qq.com
     *@blog https://stavtop.club
     *@date 2019/07/21 12:06:38
     */
    fun loadFromDisk() {
        // 1. 创建本地文件
        val file = File(path)
        // 2. 判断本地file是否
        if (!file.exists()) return
        // 3. 存在 就加载信息
        val str = file.readText()
        // 4.赋值给list集合 将json字符串转化为集合
        val parseList = JSON.parseObject(str, object : TypeReference<ArrayList<String>>() {})
        // 5. 更新当前list集合
        list.clear()
        list.addAll(parseList)
    }
}
