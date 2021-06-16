//时间
function fn(){
    var time = new Date();
    var str= "";
    var div = document.getElementById("time");
//    console.log(time);
    var year = time.getFullYear();
    var mon = time.getMonth();
    var day = time.getDate();
    var h = time.getHours();
    var m = time.getMinutes();
    var s = time.getSeconds();
    var week = time.getDay();
    var yingshe = new Array();
    yingshe[0] = "Jan ";
    yingshe[1] = "Feb ";
    yingshe[2] = "Mar ";
    yingshe[3] = "Apr ";
    yingshe[4] = "May ";
    yingshe[5] = "Jun ";
    yingshe[6] = "Jul ";

    yingshe[7] = "Aug ";
    yingshe[8] = "Sept ";
    yingshe[9] = "Oct ";
    yingshe[10] = "Nov ";
    yingshe[11] = "Dec ";


    switch (week){
        case 0:week="Sun ";
            break;
        case 1:week="Mon ";
            break;
        case 2:week="Tue ";
            break;
        case 3:week="Wed ";
            break;
        case 4:week="Thu ";
            break;
        case 5:week="Fri ";
            break;
        case 6:week="Sat ";
            break;
    }
    str = yingshe[mon] + totwo(day) + ","+year+"    "+ totwo(h)+":"+totwo(m)+":"+totwo(s);

    //str = year +"year"+totwo(mon)+"month"+totwo(day)+"day"+"&nbsp;"+totwo(h)+":"+totwo(m)+":"+totwo(s)+"&nbsp;"+"week"+week;

    div.innerHTML = str;
}
fn();
setInterval(fn,1000);
function totwo(n){
    if(n<=9){
        return n = "0"+n;
    }
    else{
        return n =""+n;
    }
}

