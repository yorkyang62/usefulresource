var convertUnit = function(index){
    var indexList = [1,2,3,4,5,6,7,8,9,10,11,12,13];
    var timesName = ["","拾","佰","仟","萬","拾萬","佰萬","仟萬","亿","拾亿","佰亿","仟亿","萬亿"];
    for(i in indexList){
        if(index == indexList[i]){
            return timesName[i];
        }
    }
}

var convertNum = function(num){
    var numList = [0,1,2,3,4,5,6,7,8,9];
    var upNumList = ["零","壹","贰","叁","肆","伍","陆","柒","捌","玖"];
    for(i in numList){
        if(num == numList[i]){
            return upNumList[i];
        }
    }
}

var converInt = function(num){
    var str = num.toString().split("").reverse().join("");
    var len = str.length;
    if(len>13){
        alert("超出最大可处理范围！");
        return;
    }
    var upStr = "";
    for(var i=len;i>0;i--){
        if(str[i-1]>0){
            upStr+=convertNum(str[i-1])+convertUnit(i);
        }
        else{
            upStr+="零";
        }
    }
    upStr = upStr.replace("零拾","零").replace("零佰","零").replace("零仟","零").replace("零萬","零")
    .replace("零拾萬","零").replace("零佰萬","零").replace("零仟萬","零").replace("零亿","零")
    .replace("零拾亿","零").replace("零佰亿","零").replace("零仟亿","零").replace("零萬亿","零");
    var patt1=new RegExp("萬[^亿].*萬");
    var patt2=new RegExp(/(萬)/g);
    var patt3=new RegExp("亿.*亿");
    var patt4=new RegExp(/(亿)/g);
    var patt5 = new RegExp(/(零{2,})/);
    console.log(patt1.exec(upStr));
    if(patt1.exec(upStr)){
        var findStr = patt1.exec(upStr)[0].replace(patt2,"")+"萬";
        upStr = upStr.replace(patt1,findStr);
    }
    if(patt3.exec(upStr)){
        var findStr2 = patt3.exec(upStr)[0].replace(patt4,"")+"亿";
        upStr = upStr.replace(patt3,findStr2);
    }
    var len2 = patt5.exec(upStr).length;
    for(var i = 0;i<len2;i++){
        upStr = upStr.replace(patt5,"零");
    }
    console.log(upStr);
}

converInt(3000300056412);