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
            url: "/api/user",
            data: JSON.stringify(data)

        }).done(function () {

        }).fail(function () {

        }); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청합니다.
    }

};
index.init();
