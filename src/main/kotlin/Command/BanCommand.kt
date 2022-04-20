package org.AlerHughes.Command

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.console.command.getGroupOrNull
import net.mamoe.mirai.contact.getMember
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.PlainText
import org.AlerHughes.PluginVoodoo
import kotlin.random.Random

object BanCommand : SimpleCommand (
    PluginVoodoo, "SB","BANME",
    description = "自虐禁言"
    ){
        @Handler
        suspend fun CommandSender.handle() {
            val seed = Random.nextInt(1, 5)
            var time: Int = 60
            var text: String = ""
            if (seed == 1) {
                time = 60
                text = "恭喜你被禁言60秒！ 运气不错~"
            } else if (seed == 2) {
                time = 600
                text = "恭喜你被禁言十分钟！ 安静一会吧~"
            } else if (seed == 3) {
                time = 1800
                text = "恭喜你被禁言半个小时！ 小睡一会吧~"
            }
            else if(seed == 4){
                time = 14400
                text = "你被禁言了4个小时，请对管理员说出你的遗言😋"
            }

            else if(seed == 5) {
                time = 28800
                text = "精致睡眠8小时，不许反悔😇"
            }

            sendMessage(At(user!!) + PlainText(text))
            user?.id?.let { getGroupOrNull()?.getMember(it)?.mute(time) }
        }
    }