// var tabs = document.getElementById("tab").getElementsByTagName("li");
// var divs = document.getElementById("tab_con").getElementsByTagName("div");
// for (var i = 0; i < tabs.length; i++) {
//     tabs[i].onclick = function () {
//         change(this);
//     }
// }
//
// function change(obj) {
//     for (var i = 0; i < tabs.length; i++) {
//         if (tabs[i] == obj) {
//             tabs[i].className = "fli";
//             divs[i].className = "fdiv";
//             var width = (0.16 * i) * 100 + "%";
//             document.getElementById("shade").style.left = width;
//             if (i != 0) {
//                 document.getElementsByClassName("fdiv")[0].style.borderRadius = "20px 20px 20px 20px";
//             }
//         }
//         else {
//             tabs[i].className = "";
//             divs[i].className = "";
//         }
//     }
// }

function displayFile(file) {
    var type = $('#imgType').val();
    if(type === 'file'){
        $('#file').show();
        $('#url').hide();
    }else {
        $('#url').show();
        $('#file').hide();
    }
}

function disNotBuy() {
    var val = $('#showWhat').val();
    var gallaryLi = $('#gallery').children("li");
    //didn't buy
    if(val === '12'){
        gallaryLi.each(function(){
            if( $(this).children("a").find("span").size() > 0 ){
                $(this).hide();
            }
        });
    }else {
        gallaryLi.each(function () {
            $(this).show();
        })
    }
}
function checkAndSubmit(url){
    console.log("check "+url);
    var bookForm =$('#bookForm');
    var title = $('#title');
    var price = $('#price');
    var subtitle = $('#subtitle');
    var detail = $('#detail');
    var passed = true;
    if(title.val().length < 2 || title.val().length >80){
        title.css("border-color","red");
        passed=false;
    }else title.css("border-color","black");
    if(subtitle.val().length <2 || subtitle.val().length >140){
        subtitle.css("border-color","red");
        passed = false;
    }else subtitle.css("border-color","black");
    if(detail.val().length <2 || detail.val().length >1000){
        detail.css("border-color","red");
        passed = false;
    }else detail.css("border-color","black");
    return passed;
}

function encodePasswd(){
    console.log(hex_md5($('#user-password-label').val()));
    var md5 = hex_md5($('#user-password-label').val());
    $('#user-password-label').val(md5)
}
