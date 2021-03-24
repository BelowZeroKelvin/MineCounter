# MineCounter
一个使用fabric写的计分板  
感谢 [Fallen_Breath](https://github.com/Fallen-Breath) 的 [more-statistic](https://github.com/Fallen-Breath/more-statistics) 
## 快速开始
你可以使用计分板 `/scoreboard` 来统计玩家的挖掘信息，该计分板使用的准则为 `minecraft.custom:minecraft.mine_counter`
通过以下指令来新建该计分板
```
/scoreboard objectives add mine_counter minecraft.custom:minecraft.mine_counter {"text": "挖掘榜"}
```
并使用以下指令在侧边栏显示
```
/scoreboard objectives setdisplay sidebar mine_counter
```