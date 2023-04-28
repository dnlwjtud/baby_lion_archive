function changeNickname() {

    const headerName = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
    const tokenValue = document.querySelector("meta[name='_csrf']").getAttribute("content");

    const nicknameEl = document.querySelector('#account-nickname');
    const nickname = nicknameEl.value;


    // const data = {
    //     nickname
    // }


    fetch('http://localhost:8083/adms/accounts/update/nickname', {
        method: "POST",
        headers: {
            // "Content-Type" : "application/json",
            // "Content-Type" : "plain/text",
            [headerName] : tokenValue
        },
        body: nickname
    })
        .then(
            (resp) =>  {
                alert('성공적으로 변경되었습니다.');
                location.reload();
            }
        )
        .catch(
            (err) => console.log(err)
        )

}

function changePwd() {

    const headerName = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
    const tokenValue = document.querySelector("meta[name='_csrf']").getAttribute("content");

    const passwordEl = document.querySelector('#account-password');
    const rawPassword = passwordEl.value;


    // const data = {
    //     nickname
    // }


    fetch('http://localhost:8083/adms/accounts/update/pwd', {
        method: "POST",
        headers: {
            [headerName] : tokenValue
        },
        body: rawPassword
    })
        .then(
            (resp) =>  {
                alert('성공적으로 변경되었습니다.');
                location.reload();
            }
        )
        .catch(
            (err) => console.log(err)
        )

}