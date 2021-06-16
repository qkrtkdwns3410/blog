let index = {
    init: function () {
        $("#btn_save").on("click", () => { //function(){} , () = >{} this를 바인딩하기 위하여
            this.save();
        });
    },
    save: function () {
        // alert('user의 save함수 호출됨');
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        // console.log(data);

        //ajax호출시 default가 비동기 호출입니다.

        $.ajax({
            //회원가입 수행 요청
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data),
            contentType: "application/json;charset=UTF-8", //body데이터가 어떤 타입인지 (MIME)
            dataType: "json" //요청을 서버로 해서 응답이 왔을경우 기본적으로 모든 것이 문자열 입니다.(생긴게 json이라면 >>javascript

        }).done(function (resp) {
            alert("회원가입이 완료되었습니다.");
            alert(resp);
            location.href = "/blog";
        }).fail(function (error) {
            alert(JSON.stringify(arror));
        }); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청합니다.
    }

};
index.init();
