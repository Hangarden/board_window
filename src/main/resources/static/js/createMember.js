// //닉네임 체크 [S]
// function checkNickName() {
//
//     var nickname = document.getElementById('nickNm').value; //닉네임 입력값 받아오기
//     var nickLength = 0;
//
//     var engCheck = /[a-z]/;
//     var numCheck = /[0-9]/;
//     var specialCheck = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
//
//     //한글, 영문 길이 2,1로 바꾸기
//     for(var i=0; i<nickname.length; i++){ //한글은 2, 영문은 1로 치환
//
//         nick = nickname.charAt(i);
//
//         if(escape(nick).length >4){
//
//             nickLength += 2;
//
//         }else{
//
//             nickLength += 1;
//
//         }
//
//     }
//
//     //닉네임 필수 입력
//     if (nickname == null || nickname == "") {
//
//         alert("닉네임 입력은 필수입니다.");
//
//         //닉네임 빈칸 포함 안됨
//     } else if (nickname.search(/\s/) != -1) {
//
//         alert("닉네임은 빈 칸을 포함 할 수 없습니다.");
//
//         //닉네임 한글 1~10자, 영문 및 숫자 2~20자
//     } //else if (nickname.length<2 || nickname.length>20) {
//     else if (nickLength<2 || nickLength>20) {
//
//         alert("닉네임은 한글 1~10자, 영문 및 숫자 2~20자 입니다.");
//
//         //닉네임 특수문자 포함 안됨
//     } else if (specialCheck.test(nickname)) {
//
//         alert("닉네임은 특수문자를 포함 할 수 없습니다.");
//
//         //닉네임 중복확인
//     } else {
//
//         $.ajax({
//             type : 'POST',
//             url : "Controller를 찾아가는 URL",
//             data : {
//                 data : nickname,
//             },
//             error : function(err) {
//                 alert("실행중 오류가 발생하였습니다.");
//             },
//             success : function(data) {
//
//                 alert("사용할 수 있는 닉네임 입니다.");
//
//             } else {
//
//                 alert("사용할 수 없는 닉네임 입니다.");
//
//     }
//
//     }
//
//     });
//
// }
//
// }